package com.ifmo.lesson2;

public class ex5_Fibonachi {
    public static void main(String[] args) {

        int f1 = 1;
        int f2 = f1;
        int p;

        System.out.println(f1);
        System.out.println(f2);
        for (int i = 1; i < 11; i++) {
            p = f2;
            f2 += f1;
            f1 = p;
            System.out.println(f2);

        }
    }
}
