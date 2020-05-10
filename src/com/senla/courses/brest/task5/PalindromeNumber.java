package com.senla.courses.brest.task5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PalindromeNumber {
    private ArrayList<Integer> palindromes = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        System.out.println("Please enter a number from 0 to 100");

        try ( BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            int n = Integer.parseInt(reader.readLine());
            PalindromeNumber palindromeNumber = new PalindromeNumber();
            palindromeNumber.findPalindromes(n);
            System.out.println("Palindromes found: ");
            palindromeNumber.getPalindromes().forEach(System.out::println);
        } catch (NumberFormatException e) {
            System.out.println("Invalid value entered");
        }

    }

    public void findPalindromes(int N) {
        if (N <= 100 && N >= 0) {
            int palindrome;
            int tenDegree = 0;
            Degree degree = new Degree();

            for (int i = 0; i < 11; i++) {
                if (i == 10) {
                    tenDegree++;
                    i = 0;
                } else {
                    palindrome = (int) degree.pow(10, tenDegree)*i + i;
                    if (palindrome > N) {
                        return;
                    } else {
                        palindromes.add(palindrome);
                    }
                }
            }

        } else {
            System.out.println("Invalid value entered");
        }
    }

    public ArrayList<Integer> getPalindromes() {
        return palindromes;
    }
}
