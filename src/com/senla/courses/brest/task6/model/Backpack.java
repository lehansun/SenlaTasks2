package com.senla.courses.brest.task6.model;

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    private int carryingСapacity;
    private List<Thing> things = new ArrayList<>();

    public Backpack(int carryingСapacity) {
        this.carryingСapacity = carryingСapacity;
    }

    public int getCarryingСapacity() {
        return carryingСapacity;
    }

    public List<Thing> getThings() {
        return things;
    }

}
