package com.ifmo.lesson4;

public class JSONManager extends MainClassXMLJson implements MainInterface{
    @Override
    public void read () {
        System.out.println("Readed Json");
    }

    @Override
    public void write () {
        System.out.println("Writed some Json");
    }
}
