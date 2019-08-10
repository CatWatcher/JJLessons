package com.ifmo.lesson3;

import java.lang.Math;
import java.util.Arrays;

public class ex3_RandomArray {
    public static void main(String[] args) {
        int[] arr = new int[15];
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*10);
        }

        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0 && arr[i] != 0)
                count += 1;
        }

        System.out.println(count);
    }
}
