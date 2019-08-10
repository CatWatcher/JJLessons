package com.ifmo.lesson4.animals;

public interface Eat {
    default  public void stop () {
        System.out.println("stop");
    }

    public void eat ();
}
