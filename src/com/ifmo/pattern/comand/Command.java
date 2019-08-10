package com.ifmo.pattern.comand;

public abstract class Command {
    abstract String name();
    abstract boolean execute();

    // связывание команд
    protected TextProcessor processor;
    public Command(TextProcessor processor) {
        this.processor = processor;
    }
}
