package com.ifmo.pattern.comand;

public class ExitCommand extends Command{

    @Override
    String name() {
        return null;
    }

    @Override
    boolean execute() {
        // реализация выхода из программы
        System.out.println("execute ExitCommand");
        return true;
    }

    public ExitCommand(TextProcessor processor) {
        super(processor);
    }
}
