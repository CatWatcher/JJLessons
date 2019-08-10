package com.ifmo.lesson3;

import java.util.Arrays;

public class ex2_ReversArray {
    public static void main(String[] args) {
        int[] arr = new int[50];
        int num = 1;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = num;
            num += 2;
        }

        System.out.println(Arrays.toString(arr));

        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}
