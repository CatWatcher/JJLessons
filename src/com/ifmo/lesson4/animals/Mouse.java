package com.ifmo.lesson4.animals;

public class Mouse extends Animal implements Run {

    @Override
    public void run () {
        System.out.println("run");
    }


    @Override
    public void stop() {
        System.out.println("StopStop");
    }
}
