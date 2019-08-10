package com.ifmo.lesson10.Shop;

import java.util.Objects;

public class Good {
    private String title;
    private double price;

    public Good(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return Double.compare(good.price, price) == 0 &&
                Objects.equals(title, good.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price);
    }

    @Override
    public String toString() {
        return "Good{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
