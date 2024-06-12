package com.artemisa.top10algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeTest {

    @Test
    void palindromeTest() {
        assertTrue(isPalindrome("racecar"));
        assertTrue(isPalindrome("aeea"));

        assertFalse(isPalindrome("hello"));
        assertFalse(isPalindrome("hola"));
    }

    private boolean isPalindrome(String string) {
        int left = 0;
        int right = string.length() - 1;

        while (left < right) {
            if (string.charAt(left) != string.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
