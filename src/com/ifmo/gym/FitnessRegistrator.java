package com.ifmo.gym;

import java.util.ArrayList;

public class FitnessRegistrator {

    ArrayList<Human> inGym = new ArrayList<>();
    ArrayList<Human> inPool = new ArrayList<>();
    ArrayList<Human> inYoga = new ArrayList<>();

    // делить на разные методы
    public void add(Human human, FitnessServiceEnumeration type) {
        if (FitnessServiceEnumeration.GYM.equals(type)) {
            inGym.add(human);
        }
    }
}
