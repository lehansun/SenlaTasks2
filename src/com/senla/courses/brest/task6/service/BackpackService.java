package com.senla.courses.brest.task6.service;

import com.senla.courses.brest.task6.exceptions.CapacityException;
import com.senla.courses.brest.task6.model.Backpack;
import com.senla.courses.brest.task6.model.Thing;

import java.util.ArrayList;

public interface BackpackService {

    void setThingToBackpack(Thing thing, Backpack bag) throws CapacityException;

    ArrayList<Thing> getListOfThingsWithHighestCost(ArrayList<Thing> things, Backpack backpack);
}
