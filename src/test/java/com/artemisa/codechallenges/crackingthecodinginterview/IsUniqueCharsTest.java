package com.artemisa.codechallenges.crackingthecodinginterview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsUniqueCharsTest {
    @Test
    public void isUniqueCharsTest() {
        assertTrue(isUniqueChars("erlang"));
        assertTrue(isUniqueChars("kotlin"));

        assertFalse(isUniqueChars("java"));
        assertFalse(isUniqueChars("groovy"));
    }

    private boolean isUniqueChars(String string) {
        boolean[] characters = new boolean[128];

        for (int i = 0; i < string.length(); i++) {
            // string.charAt(i) can be used instead of string.codePointAt(i). Both lead to the same result
            int index = string.codePointAt(i);

            if (characters[index]) {
                return false;
            }

            characters[index] = true;
        }

        return true;
    }
}
