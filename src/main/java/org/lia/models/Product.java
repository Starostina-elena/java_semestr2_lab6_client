package org.lia.models;

import java.io.Serializable;
import java.util.Objects;

/**Product class*/
public class Product implements Comparable<Product>, Serializable {
    private static final long serialVersionUID = 17854647755190753L;

    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer price; //Поле может быть null, Значение поля должно быть больше 0
    private String partNumber; //Строка не может быть пустой, Поле может быть null
    private Integer manufactureCost; //Поле не может быть null
    private UnitOfMeasure unitOfMeasure; //Поле не может быть null
    private Organization manufacturer; //Поле не может быть null

    private static long currentId = 1;

    public Product(String name, Coordinates coordinates, Integer price, String partNumber,
                   Integer manufactureCost, UnitOfMeasure unitOfMeasure, Organization manufacturer) {
        this.setName(name);
        this.setCoordinates(coordinates);
        this.setPrice(price);
        this.setPartNumber(partNumber);
        this.setManufactureCost(manufactureCost);
        this.setUnitOfMeasure(unitOfMeasure);
        this.setManufacturer(manufacturer);
    }

    /**Returns id of the element*/
    public long getId() {
        return id;
    }

    /**Returns a name of the element */
    public String getName() {
        return name;
    }

    /**Sets a name to the element. Name shouldn't be null or empty*/
    public void setName(String name) throws IllegalArgumentException {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("name cannot be empty");
        } else if (name.length() > 500) {
            throw new IllegalArgumentException("name is too long");
        }
        this.name = name;
    }

    /**Returns coordinates of the element*/
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**Sets coordinates to the element. Coordinates cannot be null*/
    public void setCoordinates(Coordinates coordinates) throws IllegalArgumentException {
        if (coordinates == null) {
            throw new IllegalArgumentException("coordinates cannot be null");
        }
        this.coordinates = coordinates;
    }

    /**Return creationDate of the element*/
    public java.time.LocalDate getCreationDate() {
        return creationDate;
    }

    /**Returns price of the element*/
    public Integer getPrice() {
        return price;
    }

    /**Set price to the element. Price can be null but it should be greater than 0*/
    public void setPrice(Integer price) throws IllegalArgumentException {
        if (price == null || price > 0) {
            this.price = price;
        }
        else {
            throw new IllegalArgumentException("price should be more than 0");
        }
    }

    /**Returns partNumber of the element*/
    public String getPartNumber() {
        return partNumber;
    }

    /**Set partNumber to the element. Part number cannot be null or empty*/
    public void setPartNumber(String partNumber) throws IllegalArgumentException {
        if (partNumber == null || !partNumber.isEmpty()) {
            this.partNumber = partNumber;
        }
        else if (partNumber.length() > 100) {
            throw new IllegalArgumentException("partNumber is too long");
        }
        else {
            throw new IllegalArgumentException("partNumber should not be empty");
        }
    }

    /**returns a manufactureCost of the element*/
    public Integer getManufactureCost() {
        return manufactureCost;
    }

    /**sets manufactureCost to the element. ManufactureCost cannot be null*/
    public void setManufactureCost(Integer manufactureCost) throws IllegalArgumentException {
        if (manufactureCost == null) {
            throw new IllegalArgumentException("manufactureCost cannot be null");
        }
        this.manufactureCost = manufactureCost;
    }

    /**return unitOfMeasure of the element*/
    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    /**sets unitOfMeasure to the element. This field can be null*/
    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) throws IllegalArgumentException {
        this.unitOfMeasure = unitOfMeasure;
    }

    /**returns manufacturer of the element*/
    public Organization getManufacturer() {
        return manufacturer;
    }

    /**sets manufacturer to the element. This field cannot be null*/
    public void setManufacturer(Organization manufacturer) throws IllegalArgumentException {
        if (manufacturer == null) {
            throw new IllegalArgumentException("manufacturer cannot be null");
        }
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return id == product.id && Float.compare(price, product.price) == 0 && Float.compare(manufactureCost, product.manufactureCost) == 0 && Objects.equals(name, product.name) && Objects.equals(coordinates, product.coordinates) && Objects.equals(creationDate, product.creationDate) && Objects.equals(partNumber, product.partNumber) && unitOfMeasure == product.unitOfMeasure && Objects.equals(manufacturer, product.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, price, partNumber, manufactureCost, unitOfMeasure, manufacturer);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", price=" + price +
                ", partNumber='" + partNumber + '\'' +
                ", manufactureCost=" + manufactureCost +
                ", unitOfMeasure=" + unitOfMeasure +
                ", manufacturer=" + manufacturer +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        if (o == null) return 1;
        return this.price - o.getPrice();
    }

    /**Updates currentId after adding elements from the file*/
    public static void updateId(long newId) {
        currentId = newId + 1;
    }
}
