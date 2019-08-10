package com.ifmo.lesson4.animals;

public class Cat extends Animal implements Run {  // в классе обязательно должен быть реализован метод, описанный в интерфейсе

    @Override
    public void run () {
        System.out.println("Run");
    }

}
