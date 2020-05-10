package com.senla.courses.brest.task6;

import com.senla.courses.brest.task6.exceptions.CapacityException;
import com.senla.courses.brest.task6.model.Backpack;
import com.senla.courses.brest.task6.model.Thing;
import com.senla.courses.brest.task6.service.BackpackService;

public class Main {
    public static void main(String[] args) throws CapacityException {
        Backpack bag = new Backpack(16);
        Thing ax = new Thing(500, 2);
        BackpackService service = new BackpackService();
        service.setThingToBackpack(ax,bag);
        System.out.println(bag.getThings().size());
    }
}
