package com.senla.courses.brest.task6;

import com.senla.courses.brest.task6.exceptions.CapacityException;
import com.senla.courses.brest.task6.model.Backpack;
import com.senla.courses.brest.task6.model.Thing;
import com.senla.courses.brest.task6.service.BackpackService;
import com.senla.courses.brest.task6.service.BackpackServiceImpl;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws CapacityException {

        Backpack bag = new Backpack(1500);

        ArrayList<Thing> things = new ArrayList<>();
        things.add(new Thing(50, 500));
        things.add(new Thing(90, 1000));
        things.add(new Thing(80, 300));
        things.add(new Thing(185, 1200));
        things.add(new Thing(50, 10));

        BackpackService service = new BackpackServiceImpl();
        things =  service.getListOfThingsWithHighestCost(things, bag);

//      Print result
        for (Thing thing : things) {
            service.setThingToBackpack(thing, bag);
            System.out.println("Cost = " + thing.getCost() + ", weight = " + thing.getWeight());
        }
    }
}
