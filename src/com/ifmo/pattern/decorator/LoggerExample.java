package com.ifmo.pattern.decorator;

import java.io.*;
import java.util.Date;

public class LoggerExample {
    public static void main(String[] args) {
        ILogger logger = new Logger();
        logger.write("log message");

        // создаем объект даталогера
        // в конструктор передаем объект класса логгер
        ILogger logger1 = new DateLogger(new Logger());
        logger1.write("log message");

        // используем 2 сразу
        ILogger logger2 = new AuthorLogger(new DateLogger(new Logger()));
        logger2.write("log message");
    }
}

//////// если невозможно наследование, а расширить функционал нужно, тогда используются декораторы /////
/////// или когда нужно разнообразное расширение функционала //////////////////////////////////////////
//////  должны расширять один и тот же интерфейс /////////////////////////////////////////////////////

interface ILogger {
    public void write (String message);
}

// базовый класс
// где описан непосредствено основной функционал

class Logger implements ILogger {

    // основной функционал
    // почитать про паттерн декоратор
    @Override
    public void write(String message) {
        System.out.println("Console: " + message);
    }
}

// классы с доп функционалом
// расширяет тот же интерфейс что и основной класс
// это родительский декоратор
class LoggerDecorator implements ILogger{

    // но у него есть свойство
    ILogger iLogger;

    public LoggerDecorator(ILogger iLogger) {
        this.iLogger = iLogger;
    }

    // метод базового декоратора
    // обычно тут просто вызов метода
    @Override
    public void write(String message) {
        iLogger.write(message);
    }
}

// расширяем функционал
// это декоратор
// дополняет функционал, а потом вызывает метод родителя
class DateLogger extends LoggerDecorator {

    public DateLogger(ILogger iLogger) {
        super(iLogger);
    }

    @Override
    public void write(String message) {
        // тут дописываем что должен делать ещё
        // в данном случае еще выводит и дату
        // это и есть декорирование
        String newMessage = message + ", date: " + new Date();
        super.write(message);
    }
}

// еще один декоратор
// все следующие декораторы наследуются от родительского
class AuthorLogger extends  LoggerDecorator{

    public AuthorLogger(ILogger iLogger) {
        super(iLogger);
    }

    @Override
    public void write(String message) {
        String newMessage = message + ", author: " + System.getProperty("user.name");
        super.write(message);
    }
}

////// на базе фильтринпутстрима и оутпут стрима можно создать свои методы
// можно сделать шифрующие потоки
class MyInStream extends FilterInputStream {
    public MyInStream(InputStream in) {
        super(in);
    }

    // тут сделать дешифровку данных
    @Override
    public int read(byte[] b) throws IOException {
        return super.read(b);
    }
}

class MyOutStream extends FilterOutputStream {
    public MyOutStream(OutputStream out) {
        super(out);
    }

    // сделатиь шифровку данных
    @Override
    public void write(int b) throws IOException {
        super.write(b);
    }
}