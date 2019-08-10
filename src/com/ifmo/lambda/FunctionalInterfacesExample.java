package com.ifmo.lambda;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfacesExample {

    public static void main(String[] args) {
        /////////////////////// встроенные функциональные интерфесы ////////////////////////////////////
        //
        // Predicate<T> - method: boolean test (T t)
        //
        // методы по умолчанию:
        // and (Predicate p) - логическое и
        // or(Predicate p) - логическое или
        // negative () - противоположное значение

        Predicate<Integer> pos = (num) -> num > 0;

        Predicate<Integer> four = (num) -> num == 4;

        System.out.println(pos.test(45));
        System.out.println(four.test(5));

        // проверяем 2 условия (можно сколько угодно условий добавить)
        System.out.println(pos.and(four).test(43));

        // то же самое, но с или
        System.out.println(pos.or(four).test(4));

        // Function<T, R> - принимает один тип, возвращает другой
        //
        // method: R apply(T t)
        //  default: andThen (Function after);
        //  default: compose (Function before);

        Function<Integer, String> convert = a -> a + "$";
        System.out.println(convert.apply(10));

        Function<Integer, Integer> plus = a -> a + 10;
        Function<Integer, Integer> minus = a -> a - 5;

        // используем несколькл выражений
        double resAndThen = plus.andThen(minus).andThen(plus).apply(20);

        // тут сначала компос, а потом уже andThen
        double resCompose = plus.compose(minus).compose(plus).apply(20);

        Predicate<Integer> condition = num -> num > 0;
        Function<Integer, Integer> ifTrue = a -> a + 10;
        Function<Integer, Integer> ifFalse = a -> a - 10;

        Function<Integer, Integer> func = getFunction(condition, ifTrue, ifFalse);

        // Consumer<T> - принимает значение и ничего не возвращает
        //
        // method: void accept(T t); - метод просто меняет объект
        // default: andThen(Consumer<T> after);

        // BinaryOperator<T> - принимает на вход два значения одного типа и возвращает значение того же типа
        // бинарные операции

        // UnaryOperator<T> - унарные операции

    }

    public static Function<Integer, Integer> getFunction (
            Predicate<Integer> condition,
            Function<Integer, Integer> ifTrue,
            Function<Integer, Integer> ifFalse
    ) {
        return a -> condition.test(a) ? ifTrue.apply(a) : ifFalse.apply(a);
    }

}


// задачка: дан предикат condition и 2 Function ifTrue and ifFalse
// написать метод который вкрнет новую функцию , возвращающую значение функции ifTrue,
// если кондитион - true и наоборот
// попробовать через дженерики