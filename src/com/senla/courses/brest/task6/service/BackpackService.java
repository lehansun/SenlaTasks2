package com.senla.courses.brest.task6.service;

import com.senla.courses.brest.task6.exceptions.CapacityException;
import com.senla.courses.brest.task6.model.Backpack;
import com.senla.courses.brest.task6.model.Thing;

import java.util.ArrayList;
import java.util.List;

public class BackpackService {
    public static void main(String[] args) {
        for (int i19 = 0; i19 < 2; i19++) {
            for (int i18 = 0; i18 < 2; i18++) {
                for (int i = 0; i < 2; i++) {
                    System.out.println("" + i19 + i18 + i);
                }
            }
        }
    }

    public void setThingToBackpack(Thing thing, Backpack bag) throws CapacityException {
        if (bag.getCarryingСapacity() > thing.getWeight()) {
            List<Thing> things = bag.getThings();
            if (things.size()>0) {
                int emptyCapacity = 0;
                for (Thing t : things) {
                    emptyCapacity-= t.getWeight();
                }
                if (emptyCapacity>=thing.getWeight()) {
                    things.add(thing);
                } else {
                    throw  new CapacityException("Too many things");
                }
            } else {
                things.add(thing);
            }
        } else {
            throw  new CapacityException("Too heavy thing");
        }
    }

//  method for selecting things suitable by weight
    public ArrayList<Thing> getSuitableListThing(List<Thing> things, int capacity) {
        ArrayList<Thing> result = new ArrayList<>();
        for (Thing thing : things) {
            if (thing.getWeight() < capacity) {
                result.add(thing);
            }
        }
        return result;
    }

    
}
