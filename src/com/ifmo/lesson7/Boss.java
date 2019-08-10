package com.ifmo.lesson7;


import java.util.Arrays;

public class Boss extends Hospital{

    public static void getList () {
        System.out.println(Arrays.toString(patient_list));
    }


    public static void getEntries () {
        System.out.println(Arrays.toString(doctors_appointments));
    }


}