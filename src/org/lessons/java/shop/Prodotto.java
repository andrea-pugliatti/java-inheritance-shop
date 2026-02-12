package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.InvalidParameterException;
import java.util.Random;

public class Prodotto {
    private int code;
    private String name;
    private String brand;
    private BigDecimal price;
    private BigDecimal vat;

    public Prodotto(String name, String brand, BigDecimal price, BigDecimal vat) {
        if (name == null || brand == null || price == null || vat == null) {
            throw new InvalidParameterException();
        }

        Random r = new Random();
        this.code = r.nextInt(10000);
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.vat = vat;
    }

    public int getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new InvalidParameterException();
        }
        this.name = name;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        if (brand == null) {
            throw new InvalidParameterException();
        }
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        if (price == null) {
            throw new InvalidParameterException();
        }

        this.price = price;
    }

    public BigDecimal getVat() {
        return this.vat;
    }

    public void setVat(BigDecimal vat) {
        if (price == null) {
            throw new InvalidParameterException();
        }
        this.vat = vat;
    }

    public BigDecimal getFullPrice() {
        return this.price.add(this.price.multiply(this.vat).divide(new BigDecimal(100))).setScale(2,
                RoundingMode.DOWN);

    }

    public BigDecimal getDiscountedPrice() {
        int discount = 2;

        return this.getFullPrice()
                .subtract(this.getFullPrice().multiply(new BigDecimal(discount)).divide(new BigDecimal(100)))
                .setScale(2, RoundingMode.DOWN);
    }

    public String getFullName() {
        return String.format("%d - %s", this.code, this.name);
    }

    @Override
    public String toString() {
        return String.format("%d - %s %s - Prezzo: %s", this.code, this.brand, this.name,
                this.getFullPrice().toString());

    }
}
