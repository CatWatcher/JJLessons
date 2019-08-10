package com.ifmo.lesson2;

public class ex9_Tanks {
    public static void main(String[] args) {

        int count = 0;
        int tanks;

        for (int i = 1; i < 100000; i++) {
            tanks = i;
            while(tanks > 0) {
                if (tanks % 10 == 0 || tanks % 10 == 3 && tanks % 100 == 1)
                    count++;
             tanks /= 10;
            }
        }
        System.out.println(count);
    }
}
