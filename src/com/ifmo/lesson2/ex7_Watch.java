package com.ifmo.lesson2;

public class ex7_Watch {
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        int count = 0;

        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 60; j++) {
                if (i % 10 == j % 100 && i % 100 == j % 10)
                    count += 1;
            }
        }

        System.out.println(count);
    }
}
