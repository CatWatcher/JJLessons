//package com.ifmo.lesson5;
//
//public class Handler {
//
//    // метод или свойство со статик будет пренадлежать не объекту, а классу
//    // к ним можно обращаться через имя класса
//    // нужны для утилитарных классов (что-то расчитывают)
//    // либо методы, которые возвращают объекты
//
//    public void read();
//    public void write();
//}
//
//class XMLHandler implements Handler{
//    @Override
//    public void read() {
//        System.out.println("read");
//    }
//    @Override
//    public void write() {
//        System.out.println("write");
//    }
//}
//
//class JSHandler implements Handler{
//    @Override
//    public void read() {
//        System.out.println("read");
//    }
//    @Override
//    public void write() {
//        System.out.println("write");
//    }
//}
//
//public interface Handler {
//    public void read();
//
//    public void write();
//
//    // для вызова таких методов не нужны объекты
//    public static Handler getInstance(String Name) {
//        Handler handler = null;
//
//        if (Name.endsWith(".xml")) {
//            handler = new XMLHandler();
//        } else if (Name.endsWith("json")) {
//            handler = new JSHandler();
//        }
//        return handler;
//
//    }
//}