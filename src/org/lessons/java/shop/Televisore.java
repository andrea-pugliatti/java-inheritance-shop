package org.lessons.java.shop;

import java.math.BigDecimal;

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
    public String toString() {
        return String.format("%s - Pollici: %d - Smart: %b", super.toString(), this.size, this.isSmart);
    }

}
