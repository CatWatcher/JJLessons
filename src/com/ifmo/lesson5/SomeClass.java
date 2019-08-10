package com.ifmo.lesson5;

public class SomeClass {

    private static final SomeClass obj = new SomeClass();
    //для создания объекта класса с приватным конструктором
    // делаем фабричный метод (каждый раз возвращает новый объект)
    // либо Singleton, возвращает ссылку на объект

    private SomeClass () {}

    static SomeClass getObj () { // если нужен 1 объект на всю программу, а остальное будет ссылками на тот же объект
        return obj;
    }

    public void print(String string) {
        System.out.println("some" + string);
    }
}

class SomeClass2 {
    SomeClass someClass = SomeClass.getObj();

}