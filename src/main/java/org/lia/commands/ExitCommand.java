package org.lia.commands;

import org.lia.managers.CommandManager;

import java.util.Scanner;

public class ExitCommand implements Command {

    CommandManager commandManager;

    public ExitCommand(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    public String description() {
        return "quits from program";
    }

    public void execute(String[] arguments) {
        System.out.println("goodbye");
        System.exit(0);
    }

}
