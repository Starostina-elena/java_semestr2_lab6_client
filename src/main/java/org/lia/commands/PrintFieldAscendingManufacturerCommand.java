package org.lia.commands;

import org.lia.models.Organization;
import org.lia.models.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintFieldAscendingManufacturerCommand implements Command, Serializable {

    public String description() {
        return "shows all manufacturers in ascending orders";
    }

    public void execute(String[] arguments) {}

}
