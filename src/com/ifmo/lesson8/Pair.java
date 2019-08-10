package com.ifmo.lesson8;
//если несколько неизвестных типов
public class Pair <K, V>{

    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public Pair() {}

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public static void main(String[] args) {

        // вместо кей будет инт, вместо v будет стринг
        Pair<Integer, String> pair = new Pair<>(4, "purr");
        pair.setKey(12);
        pair.setValue("Hello!");




    }
}
