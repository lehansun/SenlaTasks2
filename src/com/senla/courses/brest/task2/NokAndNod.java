package com.senla.courses.brest.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NokAndNod {
    private static int a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter two positive numbers: ");
        try {
            a = Integer.parseInt(reader.readLine());
            b = Integer.parseInt(reader.readLine());
        }
        catch (NumberFormatException e) {
            System.out.println("Not a numbers entered! Please try again: ");
            a = Integer.parseInt(reader.readLine());
            b = Integer.parseInt(reader.readLine());
        }

        if (a<=0 || b<=0) {
            System.out.println("The entered numbers nave to be greater than zero!");
        } else {
            swap(a, b);
            System.out.println("Least common multiple = " + lcm(a, b));
            System.out.println("Largest common factor = " + lcf(a, b));
        }
    }

    // Least common multiple
    private static int lcm(int max, int min) {
        if (max%a==0 && max%b==0) return max;
        else return lcm(max+a, min);
    }

    // Largest common factor
    public static int lcf(int max, int min) {
        if (max%min==0 && b%min==0) return min;
        else return lcf(max, min - 1);
    }

    public static void swap(int x, int y) {
        if (y>x) {
            a = y;
            b = x;
        }
    }
}