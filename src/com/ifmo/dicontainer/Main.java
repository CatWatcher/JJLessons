package com.ifmo.dicontainer;

import com.ifmo.dicontainer.pakety.Container;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Class> classes = new ArrayList<>();
        classes.add(Cat.class);
        classes.add(Dog.class);
        classes.add(Human.class);

        try {
            new Container(classes).start();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

// все это чтобы объекты поля и методы создавались автоматически
// в мэйне создания объектов не происходит