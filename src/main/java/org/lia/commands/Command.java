package org.lia.commands;

import java.io.Serializable;

public interface Command extends Serializable {
    void execute(String[] arguments);
    String description();
}
