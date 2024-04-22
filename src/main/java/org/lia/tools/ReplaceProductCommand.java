package org.lia.tools;

import org.lia.models.Coordinates;
import org.lia.models.Organization;
import org.lia.models.Product;
import org.lia.models.UnitOfMeasure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReplaceProductCommand implements Serializable {
    private static final long serialVersionUID = 1785464768755190753L;
    private Product old_product;
    private Product new_product;

    public ReplaceProductCommand(Product old_product, Product new_product) {
        this.old_product = old_product;
        this.new_product = new_product;
    }

}
