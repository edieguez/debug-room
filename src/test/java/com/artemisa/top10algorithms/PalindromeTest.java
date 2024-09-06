package com.artemisa.top10algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeTest {

    @Test
    void palindromeTest() {
        assertTrue(isPalindrome("race car"));
        assertTrue(isPalindrome("Anita lava la tina"));
        assertTrue(isPalindrome("aeea"));

        assertFalse(isPalindrome("hello"));
        assertFalse(isPalindrome("hola"));
    }

    private boolean isPalindrome(String string) {
        String aux = string.replaceAll("\\s+", "").toLowerCase();

        for (int i = 0, j = aux.length() - 1; i <= j; i++, j--) {
            if (aux.charAt(i) != aux.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}
