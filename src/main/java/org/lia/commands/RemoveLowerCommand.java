package org.lia.commands;

import java.io.Serializable;

public class RemoveLowerCommand implements Command {
    private static final long serialVersionUID = 1785464768755190753L;
    private long id;


    public String description() {
        return "delete from collection all elements lower that selected. Pattern: remove_lower (long)id";
    }

    public void execute(String[] arguments) {
        id = Integer.parseInt(arguments[1]);
    }

}
