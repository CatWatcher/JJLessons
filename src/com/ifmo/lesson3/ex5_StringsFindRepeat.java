package com.ifmo.lesson3;

import java.util.Arrays;
import java.util.Scanner;

public class ex5_StringsFindRepeat {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter string: ");
        String str = in.nextLine();

        int n = str.split("").length;

        String[] array = new String[n];

        for (int i = 0; i < n; i++) {
            array[i] = str.split("")[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i].equals(array[j])) {
                    array[j] = "";
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("")) {
                array[i] = array[i + 1];
                n--;
            }
        }

        System.out.println(Arrays.toString(array));

    }

    }
