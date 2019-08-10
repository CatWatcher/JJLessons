package com.ifmo.lesson7;

import java.util.Arrays;
import java.util.Scanner;

public class Hospital {
    static String role;
    String time;

    static String[] patient_list = new String[20];
    static String[] doctors_list =  {"Surgeon", "Therapist", "Psychologist", "Boss"};

    static String[][] doctors_appointments = new String[20][3];

    public static void open () {
        Scanner in = new Scanner(System.in);
        System.out.println("Who are you?: ");
        role = in.nextLine();

        if (role.equals("Boss")) {
            // Главврач

            System.out.println("What do you want? ");
            String answer = in.nextLine();

            if (answer.equals("getList")) {
                Boss.getList();

            } else if (answer.equals("getEntries")) {
                Boss.getEntries();

            }

        } else if (role.equals("Surgeon") || role.equals("Therapist") || role.equals("Psychologist")) {
            // функционал простых врачей

        } else if (role.equals("Patient")) {
            // запись пациентов

           Admin admin = new Admin();
           admin.registerPatient();

        } else {

            System.out.println("You can't use this program");
            Hospital.exit();
        }
    }

    public static void exit () {
        Hospital.open();
    }

}
