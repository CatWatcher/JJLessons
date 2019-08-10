package com.ifmo.lesson3;

import java.util.Arrays;

public class ex1_LineArray {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int j = 2;

        for (int i = 0; i < 10; i++) {
            arr[i] = j;
            j += 2;
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println(" ");

        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
    }
}
