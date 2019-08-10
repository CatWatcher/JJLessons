package com.ifmo.lesson7;

import java.util.Arrays;
import java.util.Scanner;

public class Admin extends Hospital{
    String patient_name;
    String doctor;

    public void registerPatient () {
        // регистрация пациента

        Scanner in = new Scanner(System.in);
        System.out.println("Enter your name: ");
        patient_name = in.nextLine();
        for (int i = 0; i < patient_list.length; i++) {
            if (!(Arrays.asList(patient_list).contains(patient_name)) && patient_list[i] == null) {
                patient_list[i] = patient_name;
                System.out.println("Choose a doctor: " + Arrays.toString(doctors_list));
                doctor = in.nextLine();

                Admin.entryPatient();
            }
        }
    }

    public static void entryPatient () {
        // запись к врачу


    }
}
