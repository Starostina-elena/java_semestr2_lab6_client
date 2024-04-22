package org.lia.commands;

import org.lia.models.Product;

import java.io.Serializable;

public interface Command extends Serializable {
    void execute(String[] arguments);
    String description();
    public Product product = null;
}
