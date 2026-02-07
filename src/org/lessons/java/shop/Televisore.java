package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Televisore extends Prodotto {
    private int size;
    private boolean isSmart;

    public Televisore(String name, String brand, BigDecimal price, BigDecimal vat, int size, boolean isSmart) {
        super(name, brand, price, vat);
        this.size = size;
        this.isSmart = isSmart;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isSmart() {
        return this.isSmart;
    }

    public void setIsSmart(boolean isSmart) {
        this.isSmart = isSmart;
    }

    @Override
    public BigDecimal getDiscountedPrice() {
        int discount = 2;
        if (!this.isSmart()) {
            discount = 10;
        }

        return this.getFullPrice()
                .subtract(this.getFullPrice().multiply(new BigDecimal(discount)).divide(new BigDecimal(100)))
                .setScale(2, RoundingMode.DOWN);
    }

    @Override
    public String toString() {
        return String.format("%s - Pollici: %d - Smart: %b", super.toString(), this.size, this.isSmart);
    }

}
