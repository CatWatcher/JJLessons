package com.ifmo.lesson2;

import java.util.Scanner;

public class ex4_SimpleNumber {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter number: ");
        double number = in.nextDouble();

        for (int i = 2; i < number; i ++) {
            if (number % i == 0) {
                System.out.println("Number isn't simple");
                break;
            }
            if (i == number -  1)
                System.out.println("Number is simple");
        }
    }
}
