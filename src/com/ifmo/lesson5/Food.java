package com.ifmo.lesson5;

public class Food {
    private final int portion; // обязательное свойство

    // тут дополнительные свойства
    private final int fat;
    private final int calories;

    // если у объекта много свойств, чтобы не создавать множество конструкторов и сетьтеров
    // делаем вложенный класс
    static class Builder {

        //
        private final int portion;
        private int fat = 0;
        private int calories = 0;

        // для обязательного свойства нужен конструктор
        public Builder (int portion) {
            this.portion = portion;
        }

        public Builder calories (int calories) {
            this.calories = calories;
            return this; // возвращает объект класса Builder (себя)
        }
        public Builder fat (int fat) {
            this.fat = fat;
            return this;
        }

        public Food build(){
            return new Food(this);
        }

    }

    @Override
    public String toString() {
        return "Food{" +
                "portion=" + portion +
                ", fat=" + fat +
                ", calories=" + calories +
                '}';
    }

    private Food(Builder builder){
        portion = builder.portion;
        calories = builder.calories;
        fat = builder.fat;
    }
}
