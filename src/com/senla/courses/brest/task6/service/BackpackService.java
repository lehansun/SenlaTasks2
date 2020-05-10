package com.senla.courses.brest.task6.service;

import com.senla.courses.brest.task6.exceptions.CapacityException;
import com.senla.courses.brest.task6.model.Backpack;
import com.senla.courses.brest.task6.model.Thing;

import java.util.ArrayList;
import java.util.List;

public class BackpackService {
    private ArrayList<Thing>[] sets;


    public void setThingToBackpack(Thing thing, Backpack bag) throws CapacityException {
        if (bag.getCarryingСapacity() >= thing.getWeight()) {
            List<Thing> things = bag.getThings();
            if (things.size()>0) {
                int remainingCapacity = bag.getCarryingСapacity();
                for (Thing t : things) {
                    remainingCapacity-= t.getWeight();
                }
                if (remainingCapacity>=thing.getWeight()) {
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

    public ArrayList<Thing> getListOfThingsWithHighestCost(ArrayList<Thing> things, Backpack backpack) {
        things = getSuitableListOfThing(things, backpack.getCarryingСapacity());
        createSetsOfThings(things);

        int cost = 0;
        int setNumber = 0;

        for (int i = 0; i < sets.length; i++) {
            if (getWeightOfSet(sets[i]) <= backpack.getCarryingСapacity() ) {
                if (cost < getCostOfSet(sets[i])) {
                    cost = getCostOfSet(sets[i]);
                    setNumber = i;
                }
            }
        }

        return sets[setNumber];
    }

//  Method for selecting things suitable by weight
    public ArrayList<Thing> getSuitableListOfThing(List<Thing> things, int capacity) {
        ArrayList<Thing> result = new ArrayList<>();
        for (Thing thing : things) {
            if (thing.getWeight() <= capacity) {
                result.add(thing);
            }
        }
        return result;
    }

//  Method create sets of things passing through the matrix
    public void createSetsOfThings(ArrayList<Thing> things) {
        Matrix matrix = new Matrix(things.size());
        ArrayList<String> matrixSet = matrix.getMatrix();
        sets = new ArrayList[matrixSet.size()];
        for (int i = 0; i < sets.length; i++) {
            sets[i] = getThingsFromMatrix(things, matrixSet.get(i));
        }
    }

    private ArrayList<Thing> getThingsFromMatrix(ArrayList<Thing> things, String matrix) {
        char[] array = matrix.toCharArray();
        ArrayList<Thing> set = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '1') {
                set.add(things.get(i));
            }
        }
        return set;
    }

    public int getCostOfSet(ArrayList<Thing> things) {
        int cost = 0;
        for (Thing thing : things) {
            cost+= thing.getCost();
        }
        return cost;
    }

    public int getWeightOfSet(ArrayList<Thing> things) {
        int weight = 0;
        for (Thing thing : things) {
            weight+= thing.getWeight();
        }
        return weight;
    }


}
