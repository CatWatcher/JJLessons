package com.ifmo.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.ConcurrentMap;

public class ComparatorLambda {
    public static void main(String[] args) {
        Manager alice = new Manager("Alice", 19, "Cheshir company");
        Manager slavik = new Manager("Slavik", 19, "Padik");
        Manager jhon = new Manager("Jhon", 23, "Mierin");
        Manager vasya = new Manager("Vasya", 40, "Petrovich");

        ArrayList<Manager> managers = new ArrayList<>();
        managers.add(alice);
        managers.add(slavik);
        managers.add(jhon);
        managers.add(vasya);

        Comparator<Manager> byName = (manager1, manager2) -> manager1.getName().compareTo(manager2.getName());

        // cортировка по имени
        Comparator<Manager> byName2 = Comparator.comparing(Manager::getName);
        managers.sort(byName2);

        // сортировка по возрасту
        Comparator<Manager> byAge = Comparator.comparing(Manager::getAge);
        managers.sort(byAge);

        // и по компании
        Comparator<Manager> byCompany = Comparator.comparing(Manager::getCompany);
        managers.sort(byCompany);
    }

}

class Manager {
    private String name;
    private int age;
    private String company;

    public Manager(String name, int age, String company) {
        this.name = name;
        this.age = age;
        this.company = company;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", company='" + company + '\'' +
                '}';
    }
}
