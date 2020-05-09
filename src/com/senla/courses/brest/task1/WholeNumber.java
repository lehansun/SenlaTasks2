package com.senla.courses.brest.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WholeNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        System.out.println("Enter whole number or \"Q\" for exit");

        while (!(line = reader.readLine()).equalsIgnoreCase("q")) {
            if (isWholeNumber(line)) {
                try {
                    int number = Integer.parseInt(line);
                    System.out.println(line + " is " +
                            (isEven(number) ? "even and " : "odd and ") +
                            (isPrime(number) ? "prime." : "composite."));
                } catch (NumberFormatException e) {
                    System.out.println("Exception: too big value");
                }
            } else {
                System.out.println("Exception: entered line is not whole number!");
            }
        }
    }


    public static boolean isEven(int number) {
        return number%2 == 0;
    }

    public static boolean isPrime(int number) {
        if (number<2) return false;
        if (number == 2 || number == 3) {
            return true;
        } else {
            if (isEven(number)) {
                return false;
            }
            for (int i = 3; i <= Math.sqrt(number); i = i+2) {
                if (number%i==0) return false;
            }
        }
        return true;
    }

    public static boolean isWholeNumber(String line) {
        Pattern wholeNumber = Pattern.compile("-?\\d+");
        Matcher matcher = wholeNumber.matcher(line);
        return matcher.matches();
    }
}
