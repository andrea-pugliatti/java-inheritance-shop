package org.lessons.java.shop;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Prodotto prod = new Prodotto("iPhone", "Apple", new BigDecimal(1200), new BigDecimal(22));

        System.out.printf("%s %s %s", prod.getFullName(), prod.getBrand(), prod.getFullPrice().toString());
    }
}
