package com.ifmo.lambda;

import java.util.Calendar;

// лямбда - можно сохранить реализацию в переменную
public class Calculator {
    public double calculate (int a, int b, Operation operation) {
        return operation.execute(a, b);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        // это лямбда выражение
        Operation add = (a, b) -> a + b;
        Operation div = (a, b) -> {
            if (b == 0) {
                throw new IllegalArgumentException("Division on zero");
            }
            return a / b;
        };

        // если нет аргументов
        // () -> sout("Hello");

        // если 1 аргумент
        // a -> a + 10;

        // если реализация в песколько строчек
        // (a, b) -> {
        //      действие
        //      действие
        //      return result;
        // }
        calculator.calculate(3,5, add);
    }
}

// интерфейс должен иметь аннотацию функционального
// т.е имеет только один абстрактный метод
// но могут быть статические методы и методы по умолчанию
@FunctionalInterface
interface Operation {
    double execute (double a, double b);
}