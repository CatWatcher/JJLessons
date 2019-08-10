package com.ifmo.lesson7;

public class Lesson7 {
    public static void main(String[] args) {
        // обертка примитивных типов
        // используем для приминения методов классов примитивов
        int a = 5;
        Integer intVar = 5;
        Byte byteVar;
        Float floatVar;
        Double doubleVar;
        Character charVar;
        Short shortVar;
        Boolean boolVar;

        // каждый класс дает методы
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);
        System.out.println(Float.MAX_VALUE);

        // методы преобразующие сттроку в число

        Byte.parseByte("29458", 10); // возвращает примитив byte

        Byte.valueOf("123"); // возвращает обертку Byte

        // лучше не использовать new
        // число автоматически приводится к объекту
        Integer int1 = 2;
        Integer int2 = 2;
        // числа от -127 до 128 будет тру
        // т.к сравнивает примитивы
        // происходит хеширование
        if (int1 == int2)
            System.out.println("int1 == int2");

        Integer int3 = 300;
        Integer int4 = 300;
        // тут будет фолс
        // т.к сравниваются объекты
        if (int3 == int4)
            System.out.println("int3 = int4");

        Integer.compare(12, 9); // сравнение

        Integer.sum(3, 9);

        Integer.hashCode(123);

        System.out.println(Integer.parseInt("ad43"));
        // получим эксепшн

        int1.longValue(); // преобразование к типу лонг

        // на хранение булевых значений тратится огромное кол-во памяти



    }
}
