package com.ifmo.lesson2;

public class ex6_LuckyTickets {
    public static void main(String[] args) {

        int ticket = 0;

        for (int i = 1; i <1000000; i++) {
            if ((i%10 + i%10 + i%1000 == i%10000 + i%100000 + i%1000000)) {
                ticket += 1;
            }
        }

        System.out.println("Quantity of tickets: " + ticket);
    }
}
