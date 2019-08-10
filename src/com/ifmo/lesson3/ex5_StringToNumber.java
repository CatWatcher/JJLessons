package com.ifmo.lesson3;

import java.util.Arrays;
import java.util.Scanner;

public class ex5_StringToNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter string with numbers: ");
        String str = in.nextLine();

        int[] intArr;

        String str2 = str.replaceAll("\\D+", " ");

        String[] strArr = str2.trim().replaceAll(" ", ",").split(" ");

        System.out.println(Arrays.toString(strArr));

        
    }
}
