package com.ifmo.gym;

public class Human {
    private String name;
    private String surname;
    private int year;
    private String regDate;


    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.regDate = "12.03.2019";
    }

    public Human(String name, String surname, int year, String regDate) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.regDate = regDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }
}
