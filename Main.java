package org.example;

import org.example.Burger;

public class Main {
    public static void main(String[] args) {
        Burger myBurger = new Burger.Builder()
                .setBread("Whole Wheat")
                .setPatty("Veg")
                .setCheese(true)
                .setLettuce(true)
                .build();

        System.out.println(myBurger);
    }
}
