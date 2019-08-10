package com.ifmo.lesson4.animals;

public abstract class AbstractClass implements SomeInterface {  // объект абстрактного класса создать нельзя

    public abstract void abstractVoid();

    public void someVoid () {
        System.out.println("Void"); // в абстрактном не надо писать дефолт
    }

}

interface SomeInterface {
    public void iVoid();
        }

class SomeClass extends AbstractClass {

    @Override
    public void abstractVoid() {
        System.out.println("Realization");
    }

    public void iVoid () {
        System.out.println(" ");
    }
}

// абстрактный класс не обязан реализовывать методы интерфейса, но тогда их должен реализовать конечный класс

