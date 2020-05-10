package com.senla.courses.brest.task6.service;

import java.util.ArrayList;

/**
 * The class creates a matrix of possible sets of things,
 * in accordance with the number of things.
 *
 * Passing through the matrix allows to find the set of things with the highest cost
 */
public class Matrix {
    private ArrayList<String> matrix = new ArrayList<>();
    private String line = "";

    public Matrix(int length) {
        createMatrix(length);
    }

    public ArrayList<String> getMatrix() {
        return matrix;
    }

    public void createMatrix(int length) {
        if (length>1) {
            for (int i = 0; i < 2; i++) {
                line += i;
                createMatrix(length-1);
                line = line.substring(0, line.length()-1);
            }
        } else {
            for (int i = 0; i < 2; i++) {
                line+= i;
                matrix.add(line);
                line = line.substring(0, line.length()-1);
            }
        }
    }
}
