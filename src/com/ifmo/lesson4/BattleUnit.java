package com.ifmo.lesson4;

public class BattleUnit extends Unit {

    private int attackScore;

    public BattleUnit (int health, int attackScore) {
        super(health); // обращаемся к конструктору родителя
        this.attackScore = attackScore;
    }

    public void attack (BattleUnit enemy) {
        if (!this.deadOrAlive()) {
            System.out.println("Enemy dead");
            return;
        }
        enemy.health -= this.attackScore;
    }

}


// при наследовании дочерний класс наследует все публичные свойства и методы родителя
// дочерний класс дополняет функционал родителя

// protected - свойства и методы будут доступны и в дочернем классе