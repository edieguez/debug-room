package com.artemisa.codechallenges.crackingthecodinginterview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringRotationTest {

    @Test
    public void stringRotationTest() {
        assertTrue(isSubstring("abc", "bca"));
        assertTrue(isSubstring("waterbottle", "erbottlewat"));

        assertFalse(isSubstring("abc", "cba"));
        assertFalse(isSubstring("waterbottle", "erbottlewta"));
    }

    private boolean isSubstring(String originalString, String rotatedString) {
        String aux = rotatedString + rotatedString;
        return aux.contains(originalString);
    }
}
