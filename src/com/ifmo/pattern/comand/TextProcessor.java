package com.ifmo.pattern.comand;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class TextProcessor {

    public static void main(String[] args) {
        TextProcessor processor = new TextProcessor();
        processor.start();
    }
    private CommandHistory history = new CommandHistory();

    public void executeCommand (Command command) {
        if (command.execute()) {
            history.add(command);
        }
    }

    public void start () {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Command command = getInstance(scanner.nextLine());
            if (command != null) {
                command.execute();
            }
//            switch (scanner.nextLine()) {
//                case "process":
//                    executeCommand(new ProcessCommand(this));
//                    break;
//                case "exit":
//                    executeCommand(new ExitCommand(this));
//                    break;
//
//            }
        }
    }

    // фабричный метод
    private Command getInstance(String command) {
        Command command1 = null;
        if (command.equalsIgnoreCase("process")) {
            command1 = new ProcessCommand();
        } else if (command.equalsIgnoreCase("exit")) {
            command1 = new ExitCommand();
        }
        return command1;
    }

}

class CommandHistory {
    private Stack<Command> history = new Stack<>();

    public void add(Command command) {
        history.push(command);
    }

    public Command delete () {
        return history.pop();
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }
}

// просим у пользователя данные
// потом он пишет одну из команд
// в зависимости от комманды данные либо сохраняются
// либо удаляются из хранилища
// отменяем последнее действие
// повтор последнего дейтсвия
// попробовать вместо свитч применить фабричный метод
