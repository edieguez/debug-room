package com.artemisa.codechallenges.crackingthecodinginterview;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckPermutationTest {
    @Test
    void checkPermutationTest() {
        assertTrue(checkPermutation("abc", "cba"));
        assertTrue(checkPermutation("abc", "abc"));

        assertFalse(checkPermutation("xyz", "zyw"));
        assertFalse(checkPermutation("zyx", "xy"));
    }

    private boolean checkPermutation(String str1, String str2) {
        return sortString(str1).equals(sortString(str2));
    }

    private String sortString(String string) {
        char[] characters = string.toCharArray();
        Arrays.sort(characters);

        return new String(characters);
    }
}
