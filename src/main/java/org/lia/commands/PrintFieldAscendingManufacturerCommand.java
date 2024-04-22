package org.lia.commands;

import org.lia.models.Organization;
import org.lia.models.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintFieldAscendingManufacturerCommand implements Command {
    public Product product;
    private static final long serialVersionUID = 1785464768755190753L;


    public String description() {
        return "shows all manufacturers in ascending orders";
    }

    public void execute(String[] arguments) {}

}
