package com.artemisa.codechallenges.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestSubstringTest {

    /**
     * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">3. Longest Substring Without Repeating Characters</a>
     * Given s string s, find the length of the longest substring without repeating characters.
     */
    @Test
    void longestSubstring() {
        assertEquals(3, longestSubstring("abcabcbb"));
        assertEquals(1, longestSubstring("bbbbb"));
        assertEquals(3, longestSubstring("pwwkew"));
        assertEquals(1, longestSubstring(" "));
        assertEquals(2, longestSubstring("au"));
        assertEquals(3, longestSubstring("dvdf"));
    }

    int longestSubstring(String s) {
        int maxLength = 0;

        Map<Character, Integer> visitedCharacters = new HashMap<>();

        for (int right = 0, left = 0; right < s.length(); right++) {
            char currentCharacter = s.charAt(right);

            if (visitedCharacters.containsKey(currentCharacter) &&
                    visitedCharacters.get(currentCharacter) >= left) {
                left = Math.max(left, visitedCharacters.get(currentCharacter) + 1);
            }

            maxLength = Math.max(maxLength, right - left + 1);
            visitedCharacters.put(currentCharacter, right);
        }

        return maxLength;
    }
}
