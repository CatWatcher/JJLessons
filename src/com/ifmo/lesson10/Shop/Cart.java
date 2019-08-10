package com.ifmo.lesson10.Shop;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Good> goods = new ArrayList<>();

    public void addGood (Good good) {
        goods.add(good);
    }

    public void removFromCart (Good good) {
        goods.remove(good);
    }

    public double getSumm () {
        double summ = 0;
        for (Good good: goods) {
            summ += good.getPrice();
        }
        return summ;
    }
}
