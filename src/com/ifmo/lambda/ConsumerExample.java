package com.ifmo.lambda;

import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {

        // ссылка на конструктор через нотацию
        // ClassName :: new - имя класса не может быть абстрактным
        // или интерфейсом
        ButtonFactory<Button> factory = Button :: new;
        Button button = factory.set("Blue", "Ok");

        Consumer<Button> makaBtn = (button1 -> {
            button1.setColor("Blue");
            button1.setValue("Ok");
        });

        makaBtn.accept(button);
    }
}


class Button {
    private String color;
    private String value;

    public Button(String color, String value) {
        this.color = color;
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Button{" +
                "color='" + color + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}


interface ButtonFactory<T extends Button> {
    T set(String color, String value);
}