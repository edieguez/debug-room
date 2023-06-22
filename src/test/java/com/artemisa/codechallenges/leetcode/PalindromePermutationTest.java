package com.artemisa.codechallenges.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromePermutationTest {

    /**
     * <a href="https://leetcode.com/problems/palindrome-permutation">266. Palindrome Permutation</a>
     */
    @Test
    void palindromePermutationTest() {
        assertTrue(palindromePermutation("tactcoa"));
        assertTrue(palindromePermutation("tactcoapapa"));
        assertTrue(palindromePermutation("tacoztcoapapapz"));

        assertFalse(palindromePermutation("tactcoapapapb"));
        assertFalse(palindromePermutation("tactcoapapapbb"));
        assertFalse(palindromePermutation("tactcoapapapbbb"));
    }

    /**
     * Given a String, determine if it is a permutation of a palindrome
     */
    private boolean palindromePermutation(String input) {
        int[] charCount = new int[128];

        for (int i = 0; i < input.length(); i++) {
            charCount[input.charAt(i)]++;
        }

        int oddsCount = 0;

        for (int j : charCount) {
            oddsCount += j % 2;
        }

        return oddsCount <= 1;
    }
}
