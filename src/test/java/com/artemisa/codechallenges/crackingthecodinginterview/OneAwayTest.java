package com.artemisa.codechallenges.crackingthecodinginterview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OneAwayTest {
    @Test
    void oneAwayTest() {
        assertTrue(oneAway("pale", "ple"));
        assertTrue(oneAway("pales", "pale"));
        assertTrue(oneAway("pale", "pale"));

        assertFalse(oneAway("pale", "bake"));
        assertFalse(oneAway("pale", "palest"));
    }

    private boolean oneAway(String str1, String str2) {
        if (Math.abs(str1.length() - str2.length()) > 1) {
            return false;
        }

        String larger = str1.length() > str2.length() ? str1 : str2;
        String shorter = str1.length() > str2.length() ? str2 : str1;
        boolean differenceFound = false;

        for (int largerIndex = 0, smallerIndex = 0; largerIndex < larger.length() && smallerIndex < shorter.length(); largerIndex++) {
            if (larger.charAt(largerIndex) != shorter.charAt(smallerIndex)) {
                if (differenceFound) {
                    return false;
                }

                differenceFound = true;

                if (larger.length() == shorter.length()) {
                    smallerIndex++;
                }
            } else {
                smallerIndex++;
            }
        }

        return true;
    }
}
