package com.ifmo.lesson4;

public class Knight extends BattleUnit {

    int armour;

    public Knight(int health, int attackScore, int armour) {
        super(health, attackScore);
        this.armour = armour;
    }

    // переопределение родительского метода
    // должен выглядеть так же, как метод родителя
    // в том числе коли-во аргументов
    // другая только реализация
    @Override // аннотация, чтобы увидеть ошибку при переопределении родительского метода
                // если есть оверрайд, а метод прописан неправильно, то программа не соберется
    public void attack (BattleUnit enemy) { // обращение идет через родительский класс
                                            //

        super.attack(enemy); // вызываем метод родительского класса (необязательно)
        //   тут расширение функционала

        // например
        enemy.health -= 10;
    }
}
