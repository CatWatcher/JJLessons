package com.ifmo.lesson10.Shop;

import java.util.HashMap;

public class Shop {

    // пользователи
    static HashMap<String, User> users = new HashMap<>();
    // товары
    static HashMap<String, Good> storage = new HashMap<>();

    public boolean doTransaction (User user) {
        double price = user.getCart().getSumm();
        if (user.getBalance() < price) {
            return false;
        }
        // оплата
        user.setBalance(user.getBalance() - price);
        return true;
    }

    public static void main(String[] args) {
        Cart cart = new Cart();

        User user = new User("Felix", "1234", 300);
        User user2 = new User("kjdn", "876", 2734);

        Good car = new Good("Car", 516000);
        Good phone = new Good("iPhone", 126000);
        Good book = new Good("Book", 360);

        users.put(user.getLogin(), user);
        users.put(user2.getLogin(), user2);

        storage.put(car.getTitle(), car);
        storage.put(phone.getTitle(), phone);
        storage.put(book.getTitle(), book);

        user.regCart(cart);
        cart.addGood(book);
        cart.addGood(phone);


    }
}

//
