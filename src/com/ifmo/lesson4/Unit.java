package com.ifmo.lesson4;

public class Unit {
    protected int health;


    public Unit(int health) {
        this.health = health;
    }

    public boolean deadOrAlive () {
        return health > 0;
    }

    public int getHealth() {
        return health;
    }



}
