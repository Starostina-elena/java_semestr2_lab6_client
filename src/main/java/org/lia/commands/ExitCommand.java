package org.lia.commands;

import org.lia.managers.CommandManager;
import org.lia.models.Product;

import java.util.Scanner;

public class ExitCommand implements Command {
    public Product product;
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
