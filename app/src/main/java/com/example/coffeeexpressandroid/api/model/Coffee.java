package com.example.coffeeexpressandroid.api.model;

public class Coffee {
    private int idCoffee;
    private String name;
    private String description;
    private String type;
    private double price;
    private String origin;
    private String roast;
    private int salesCount;
    private String url;

    // Getters y Setters
    public int getIdCoffee() {
        return idCoffee;
    }

    public void setIdCoffee(int idCoffee) {
        this.idCoffee = idCoffee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getRoast() {
        return roast;
    }

    public void setRoast(String roast) {
        this.roast = roast;
    }

    public int getSalesCount() {
        return salesCount;
    }

    public void setSalesCount(int salesCount) {
        this.salesCount = salesCount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
