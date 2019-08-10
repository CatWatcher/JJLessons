//package com.ifmo.lesson5;
//
//public class StaticMain {
//    public static void main(String[] args) {
//        String Name = "file.json";
//        Handler handler = Handler.getInstanse(Name); // возвращает объект
//        handler.read();
//
//        System.out.println(CalcUtils.sum(3, 5)); // обращаемся к методу по имени класса
//
//        // обращаемся к вложенному классу
//        Food apple = new Food.Builder(4)
//                .calories(45)
//                .fat(4)
//                .build(); // билд уже возвращает объект класса фуд
//
//        // пока метод возвращает объект, то можно к нему обращаться сколько угодно раз
//
//
//    }
//}
