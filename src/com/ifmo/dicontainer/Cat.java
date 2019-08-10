package com.ifmo.dicontainer;

import com.ifmo.dicontainer.pakety.Config;

@Config
public class Cat {

    public Cat() {
        System.out.println("cat init");
    }

    private String catName;

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "catName='" + catName + '\'' +
                '}';
    }
}
