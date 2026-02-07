package org.lessons.java.shop;

import java.math.BigDecimal;
import java.util.Scanner;

public class Carrello {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Prodotto[] products = new Prodotto[4];

        System.out.println("Inserisci " + products.length + " prodotti");

        for (int i = 0; i < products.length; i++) {
            System.out.println("Inserisci il nome del prodotto: ");
            String productName = in.nextLine();

            System.out.println("Inserisci il brand del prodotto: ");
            String productBrand = in.nextLine();

            System.out.println("Inserisci il prezzo del prodotto: ");
            double productPrice = Double.parseDouble(in.nextLine());

            System.out.println("Inserisci l'iva del prodotto: ");
            double productVat = Double.parseDouble(in.nextLine());

            System.out.println("Di che prodotto si tratta? ");
            String productCategory = in.nextLine();
            System.out.println(productCategory);

            switch (productCategory.toLowerCase()) {
                case "televisore":
                    System.out.println("Inserisci i pollici del televisore: ");
                    int productSize = Integer.parseInt(in.nextLine());

                    System.out.println("Il televisore è smart? (true/false)");
                    boolean isSmart = Boolean.parseBoolean(in.nextLine());

                    Televisore tv = new Televisore(productName, productBrand, new BigDecimal(productPrice),
                            new BigDecimal(productVat), productSize, isSmart);

                    products[i] = tv;
                    break;

                case "cuffie":
                    System.out.println("Inserisci il colore delle cuffie: ");
                    String productColor = in.nextLine();

                    System.out.println("Le cuffie sono wireless? (true/false)");
                    boolean isWireless = Boolean.parseBoolean(in.nextLine());

                    Cuffie headphones = new Cuffie(productName, productBrand, new BigDecimal(productPrice),
                            new BigDecimal(productVat), productColor, isWireless);

                    products[i] = headphones;
                    break;

                case "smartphone":
                    System.out.println("Inserisci il codice IMEI: ");
                    String productImeiCode = in.nextLine();

                    System.out.println("Inserisci la memoria dello smartphone: ");
                    int productMemory = Integer.parseInt(in.nextLine());

                    Smartphone smartphone = new Smartphone(productName, productBrand, new BigDecimal(productPrice),
                            new BigDecimal(productVat), productImeiCode, productMemory);

                    products[i] = smartphone;
                    break;
            }
        }

        in.close();

        System.out.println("Carrello: ");

        for (Prodotto p : products) {
            System.out.println(p);
        }
    }
}
