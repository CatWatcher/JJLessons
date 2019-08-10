package com.ifmo.pattern.comand;

public class ProcessCommand extends Command {

    @Override
    String name() {
        return "ProcessCommand";
    }

    @Override
    boolean execute() {
        System.out.println("execute Process Command");
        return true;
    }

    public ProcessCommand(TextProcessor processor) {
        super(processor);
    }
}
