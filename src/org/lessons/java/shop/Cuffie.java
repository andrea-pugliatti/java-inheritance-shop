package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Cuffie extends Prodotto {
    private String color;
    private boolean isWireless;

    public Cuffie(String name, String brand, BigDecimal price, BigDecimal vat, String color, boolean isWireless) {
        super(name, brand, price, vat);
        this.color = color;
        this.isWireless = isWireless;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isWireless() {
        return this.isWireless;
    }

    public void setIsWireless(boolean isWireless) {
        this.isWireless = isWireless;
    }

    @Override
    public BigDecimal getDiscountedPrice() {
        int discount = 2;
        if (!this.isWireless()) {
            discount = 7;
        }

        return this.getFullPrice()
                .subtract(this.getFullPrice().multiply(new BigDecimal(discount)).divide(new BigDecimal(100)))
                .setScale(2, RoundingMode.DOWN);
    }

    @Override
    public String toString() {
        return String.format("%s - Colore: %s - Wireless: %b", super.toString(), this.color, this.isWireless);
    }

}
