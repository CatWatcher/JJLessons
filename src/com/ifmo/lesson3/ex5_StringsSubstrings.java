package com.ifmo.lesson3;

import java.util.Arrays;
import java.util.Scanner;

public class ex5_StringsSubstrings {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter string: ");
        String str = in.nextLine();

        System.out.println("Enter substring for search: ");
        String substrSearch = in.nextLine();

        System.out.println("Enter substring for change: ");
        String substrChange = in.nextLine();

        System.out.println(str.replaceAll(substrSearch, substrChange));

    }
}
