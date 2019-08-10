package com.ifmo.lesson2;

public class ex8_NCity {
    public static void main(String[] args) {

        int count = 0;

        for (int i = 1; i < 50001; i++){
            if (i%10 == 2 || (i/10)%10 == 2 || (i/100) % 10 == 2 || (i/1000) == 2 || (i/10000)%10 == 2)
                count++;
        }

        System.out.println(count);
    }
}
