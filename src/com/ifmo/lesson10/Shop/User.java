package com.ifmo.lesson10.Shop;

import com.ifmo.lesson8.Car;

import java.util.Objects;

public class User {
    private String login;
    private String pwd;
    private double balance;
    // привязываем корзину к пользователю
    Cart cart;

    public Cart getCart() {
        return cart;
    }

    public void regCart (Cart cart) {
        this.cart = cart;
    }

    public User(String login, String pwd, double balance) {
        this.login = login;
        this.pwd = pwd;
        this.balance = balance;
    }

    public String getLogin() {
        return login;
    }

    public String getPwd() {
        return pwd;
    }

    public double getBalance() {
        return balance;
    }


    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Double.compare(user.balance, balance) == 0 &&
                Objects.equals(login, user.login) &&
                Objects.equals(pwd, user.pwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, pwd, balance);
    }
}
