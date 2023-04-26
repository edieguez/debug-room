package com.artemisa.codechallenges.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddDigitsTest {

    /**
     * <a href="https://leetcode.com/problems/add-digits">258. Add Digits</a>
     */
    @Test
    void addDigitsTest() {
        assertEquals(2, addDigits(38));
        assertEquals(2, addDigits(11));
        assertEquals(2, addDigits(101));
    }

    private int addDigits(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;

            if (sum > 9) {
                sum = addDigits(sum);
            }

            num /= 10;
        }

        return sum;
    }
}
