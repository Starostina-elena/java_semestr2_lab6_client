package org.lia.commands;

import org.lia.models.Product;

import java.io.Serializable;

public class MinByIdCommand implements Command {
    public Product product;
    private static final long serialVersionUID = 1785464768755190753L;


    public String description() {
        return "shows element with min id";
    }

    public void execute(String[] arguments) {}

}
