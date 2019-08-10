package com.ifmo.lambda;

import java.util.concurrent.ConcurrentSkipListMap;

public class LambdaStrategy {
    public static void main(String[] args) {
        Order order = new Order(700);
        order.payOrder("card");
        order.payOrder("payPal");



    }

}

// класс для хранения стратегии
class StrategyRegister<T> {

    public ConcurrentSkipListMap<String, T> map = new ConcurrentSkipListMap<>();

    public void add (String actionName, T action) {
        map.putIfAbsent(actionName, action);
    }

    public T get (String actionName) {
        return this.map.get(actionName);
    }

    public void remove(String actionName) {
        this.map.remove(actionName);
    }

}

class Order {
    private StrategyRegister<Runnable> payActions = new StrategyRegister<>();



    private int sum;

    public Order(int sum) {
        this.sum = sum;
        // метод раннбл через лямбду
        payActions.add("card", () -> System.out.println("Card payment: " + sum));
        payActions.add("payPal", () -> System.out.println("PayPal payment: " + sum));
    }

    public int getSum() {
        return sum;
    }

    public void payOrder (String payName) {
        payActions.get(payName).run();
    }
}

enum PayActions {
    CARD, PAY_PAL, MONEY,
    // тут методы для стратегий
    // пользоваться ссылками на метод из аннотации при добавлении
}

// для каждого объекта добавляем энумы в пэйэкшнс
// сделать порт и библиотеку
// стрим апи и мио (или нио?) пакет
//
//
