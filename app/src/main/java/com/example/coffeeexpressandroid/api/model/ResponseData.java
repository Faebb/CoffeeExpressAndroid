package com.example.coffeeexpressandroid.api.model;

import java.util.List;

public class ResponseData {
    private List<Coffee> coffees;

    // Getter y Setter
    public List<Coffee> getCoffees() {
        return coffees;
    }

    public void setCoffees(List<Coffee> coffees) {
        this.coffees = coffees;
    }
}
