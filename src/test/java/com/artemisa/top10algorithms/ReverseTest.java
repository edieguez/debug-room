package com.artemisa.top10algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseTest {

    @Test
    void reverseStringTest() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String reversedAlphabet = "zyxwvutsrqponmlkjihgfedcba";

        assertEquals(reverseStringA(alphabet), reversedAlphabet);
        assertEquals(reverseStringB(alphabet), reversedAlphabet);
    }

    @Test
    void reverseNumberTest() {
        int number = 123456789;
        int reversedNumber = 987654321;

        assertEquals(reverseNumber(number), reversedNumber);

        int negativeNumber = -123456789;
        int reversedNegativeNumber = -987654321;

        assertEquals(reverseNumber(negativeNumber), reversedNegativeNumber);
    }

    private String reverseStringA(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    private String reverseStringB(String string) {
        StringBuilder builder = new StringBuilder();

        for (int i = string.length() - 1; i >= 0; i--) {
            builder.append(string.charAt(i));
        }

        return builder.toString();
    }

    private int reverseNumber(int number) {
        int reversed = 0;

        while (number != 0) {
            reversed = reversed * 10 + number % 10;
            number /= 10;
        }

        return reversed;
    }
}
