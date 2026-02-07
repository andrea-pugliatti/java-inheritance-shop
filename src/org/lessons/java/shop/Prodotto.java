package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Prodotto {
    private int code;
    private String name;
    private String brand;
    private BigDecimal price;
    private BigDecimal vat;

    public Prodotto(String name, String brand, BigDecimal price, BigDecimal vat) {
        this();
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.vat = vat;
    }

    public Prodotto() {
        Random r = new Random();
        this.code = r.nextInt(10000);
        this.name = "";
        this.brand = "";
        this.price = new BigDecimal(0);
        this.vat = new BigDecimal(0);
    }

    public int getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getVat() {
        return this.vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    public BigDecimal getFullPrice() {
        if (price != null && vat != null) {
            return this.price.add(this.price.multiply(this.vat).divide(new BigDecimal(100))).setScale(2,
                    RoundingMode.DOWN);
        }
        return null;
    }

    public BigDecimal getDiscountedPrice() {
        int discount = 2;

        return this.getFullPrice()
                .subtract(this.getFullPrice().multiply(new BigDecimal(discount)).divide(new BigDecimal(100)))
                .setScale(2, RoundingMode.DOWN);
    }

    public String getFullName() {
        if (this.name != null) {
            return String.format("%d - %s", this.code, this.name);
        }
        return null;
    }

    @Override
    public String toString() {
        if (this.name != null && this.brand != null && this.price != null) {
            return String.format("%d - %s %s - Prezzo: %s", this.code, this.brand, this.name,
                    this.getFullPrice().toString());
        }
        return null;
    }
}
