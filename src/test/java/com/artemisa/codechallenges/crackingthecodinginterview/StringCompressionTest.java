package com.artemisa.codechallenges.crackingthecodinginterview;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class StringCompressionTest {

    @Test
    void stringCompressionTest() {
        assertEquals("a1b2c3d4", stringCompression("abbcccdddd"));
        assertEquals("a1b3c1d3e1f3", stringCompression("a1b3c1d3e1f3"));
        assertEquals("abccc", stringCompression("abccc"));
    }

    private String stringCompression(String string) {
        StringBuilder compressedString = new StringBuilder();
        char currentChar = string.charAt(0);
        int charCount = 0;

        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);

            if (character == currentChar) {
                charCount++;
            } else {
                compressedString.append(currentChar).append(charCount);
                currentChar = character;
                charCount = 1;
            }
        }

        compressedString.append(currentChar).append(charCount);

        return compressedString.length() < string.length() ? compressedString.toString() : string;
    }
}
