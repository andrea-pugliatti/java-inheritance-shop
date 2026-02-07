package org.lessons.java.shop;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Prodotto prod = new Prodotto("iPhone", "Apple", new BigDecimal(1200), new BigDecimal(22));

        System.out.println(prod.toString());

        Smartphone smart = new Smartphone("Pixel", "Google", new BigDecimal(800), new BigDecimal(22), "KDFJJE23124", 8);

        System.out.println(smart.toString());
    }
}
