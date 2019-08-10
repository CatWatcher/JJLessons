package com.ifmo.lesson4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Knight tomas = new Knight(300, 10, 23);
        Archer elf = new Archer(100, 70);

        tomas.attack(elf);

        Scanner in = new Scanner(System.in);
        System.out.println("Choose");

        String heroType = in.nextLine();

        BattleUnit unit;
        // выбираем как определить unit:
        if (heroType.equals("elf")) {
            unit = new Archer(100, 70);
        }
        else {
            unit = new Knight(300, 10, 23);
        }

        unit.attack(elf);

    }
}
