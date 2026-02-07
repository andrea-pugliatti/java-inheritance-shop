package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Smartphone extends Prodotto {
    private String imeiCode;
    private int memory;

    public Smartphone(String name, String brand, BigDecimal price, BigDecimal vat, String imeiCode, int memory) {
        super(name, brand, price, vat);
        this.imeiCode = imeiCode;
        this.memory = memory;
    }

    public String getImeiCode() {
        return this.imeiCode;
    }

    public void setImeiCode(String imeiCode) {
        this.imeiCode = imeiCode;
    }

    public int getMemory() {
        return this.memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    @Override
    public BigDecimal getDiscountedPrice() {
        int discount = 2;
        if (this.getMemory() < 32) {
            discount = 5;
        }

        return this.getFullPrice()
                .subtract(this.getFullPrice().multiply(new BigDecimal(discount)).divide(new BigDecimal(100)))
                .setScale(2, RoundingMode.DOWN);
    }

    @Override
    public String toString() {
        return String.format("%s - Codice IMEI: %s - Memoria: %d", super.toString(), this.imeiCode, this.memory);
    }

}
