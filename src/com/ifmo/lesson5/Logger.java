package com.ifmo.lesson5;

public interface Logger {
    public void log();
}


//
class Some {
    public void some() {
        // анонимный класс
        // создаются либо на основе абстрактных классов, либо на основе интерфейса
        // тут описывается реализация метода без создания объекта
        Logger logger = new Logger() {
            @Override
            public void log() {
                System.out.println("log");
            }
        };

        logger.log();
    }

}