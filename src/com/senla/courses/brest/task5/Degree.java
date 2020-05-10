package com.senla.courses.brest.task5;


// Helper class for raising numbers to the pow
public class Degree {
    private long tempValue = 0;

    public long pow(long value, int degree) {
        long result = value;

        if (degree>1) {
            if (tempValue>0) {
                tempValue = tempValue * value;
                result = pow(value, degree-1);
            } else {
                tempValue = value*value;
                result = pow(value, degree-1);
            }
        } else {
            if (degree == 0) {
                return 0;
            }
            if (degree == 1) {
                if (tempValue>0) {
                    result = tempValue;
                    tempValue = 0;
                }
                return result;
            }
        }
        return result;
    }
}