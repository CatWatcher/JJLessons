package com.ifmo.gym;


@AccessMode
public class FullDayClient extends Human{

    private Access group = new Access(8, 22, FitnessServiceEnumeration.YOGA);
    private Access gym = new Access(8, 22, FitnessServiceEnumeration.GYM);
    private Access pool = new Access(8, 22, FitnessServiceEnumeration.POOL);

    public FullDayClient(String name, String surname, int year) {
        super(name, surname, year);
    }

    public FullDayClient(String name, String surname, int year, String regDate) {
        super(name, surname, year, regDate);
    }
}
