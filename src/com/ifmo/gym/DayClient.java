package com.ifmo.gym;


@AccessMode(gym = "16", yoga = "16", pool = "0")
public class DayClient extends Human {

    private String endOfReg;

    private Access group = new Access(8, 16, FitnessServiceEnumeration.YOGA);
    private Access gym = new Access(8, 16, FitnessServiceEnumeration.GYM);

    public Access getGroup() {
        return group;
    }

    public void setGroup(Access group) {
        this.group = group;
    }


    public DayClient(String name, String surname, int year) {
        super(name, surname, year);

        //TODO: посмотреть методы строк чтобы дата автоматически записывалась
        this.endOfReg = "2020";
    }

    public DayClient(String name, String surname, int year, String regDate,
                     //TODO: в энд оф рег передаем через сколько месяцев кончится регистрация
                     // сделать чтобы высчитывала программа
                     String endOfReg) {
        super(name, surname, year, regDate);
        this.endOfReg = endOfReg;
    }
}
