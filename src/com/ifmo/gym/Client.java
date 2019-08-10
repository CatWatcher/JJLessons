package com.ifmo.gym;

import java.time.LocalDate;
import java.util.Date;


@AccessMode(yoga = "0")
public class Client extends Human{

    private boolean visited = false;

    public Client(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Client(String name, String surname, int year, String regDate) {
        super(name, surname, year, regDate);
    }

}
