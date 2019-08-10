package com.ifmo.lesson3;

import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

public class ex4_UserPlusArray {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int size;
        int left = 0;
        int right = 0;


        do {
            System.out.println("Enter array's size: ");
            size = in.nextInt();
            if (size % 2 != 0 || size <= 0)
                System.out.println("Wrong size");
        } while (size % 2 != 0 || size <= 0);

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random()* 10 - 5);
        }

        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < size / 2; i++) {
            left += Math.abs(arr[i]);
        }

        for (int i = size/2; i < size; i++) {
            right += Math.abs(arr[i]);
        }

        if (left > right) {
            System.out.println("Left > right");
        } else if (right > left) {
            System.out.println("Right > left");
        } else {
            System.out.println("left = right");
        }
    }
}
