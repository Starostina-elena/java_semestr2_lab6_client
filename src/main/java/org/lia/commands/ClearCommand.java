package org.lia.commands;

import org.lia.models.Product;

import java.io.Serializable;
import java.util.ArrayDeque;

public class ClearCommand implements Command {
    public Product product;

    private static final long serialVersionUID = 1785464768755190753L;

    public String description() {
        return "clears collection";
    }

    public void execute(String[] arguments) {}

}
