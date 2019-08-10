package com.ifmo.lesson2;

import java.util.Arrays;

public class ex1_SortVariables {
    public static void main(String[] args) {

        int a = 5;
        int b = -4;
        int c = 23;
        int p;

        int[] arr = {a, b ,c};

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    p = arr[i];
                    arr[i] = arr[j];
                    arr[j] = p;
                }

            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
