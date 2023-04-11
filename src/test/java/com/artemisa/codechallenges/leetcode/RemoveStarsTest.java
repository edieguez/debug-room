package com.artemisa.codechallenges.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.com/problems/removing-stars-from-a-string/">2390. Removing Stars From a String</a>
 */
public class RemoveStarsTest {

    @Test
    void removeStarsStringBuilderTest() {
        assertEquals("lecoe", removeStarsStringBuilder("leet**cod*e"));
        assertEquals("", removeStarsStringBuilder("erase*****"));
    }

    @Test
    void removeStarsStackTest() {
        assertEquals("lecoe", removeStarsStack("leet**cod*e"));
        assertEquals("", removeStarsStack("erase*****"));
    }

    private String removeStarsStringBuilder(String input) {
        StringBuilder builder = new StringBuilder(input);

        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) == '*') {
                builder.delete(i - 1, i + 1);
                i = i - 2;
            }
        }

        return builder.toString();
    }

    private String removeStarsStack(String input) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == '*') {
                builder.deleteCharAt(builder.length() - 1);
            } else {
                builder.append(currentChar);
            }
        }

        return builder.toString();
    }
}
