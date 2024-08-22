package com.artemisa.top10algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CapitalizeTest {

    @Test
    void capitalizeTest() {
        assertNull(null, capitalize(null));
        assertEquals("", capitalize(""));
        assertEquals("   ", capitalize("   "));

        assertEquals("Hello World", capitalize("hello world"));
        assertEquals("  Hello World", capitalize("  hello world"));
        assertEquals("Hello World  ", capitalize("hello world  "));

        assertEquals("   I   Love   Java   ", capitalize("   I   love   java   "));
        assertEquals("""
                \n\r\t I
                Love
                Java
                """, capitalize("""
                \n\r\t I
                LOVE
                JAVA
                """));
    }

    private String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder token = new StringBuilder();
        StringBuilder capitalized = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            if (Character.isWhitespace(currentChar)) {
                capitalizeToken(token, capitalized);
                capitalized.append(currentChar);
            } else {
                token.append(currentChar);
            }
        }

        capitalizeToken(token, capitalized);

        return capitalized.toString();
    }

    private static void capitalizeToken(StringBuilder token, StringBuilder capitalized) {
        if (!token.isEmpty()) {
            capitalized.append(Character.toUpperCase(token.charAt(0)));
            capitalized.append(token.substring(1).toLowerCase());
            token.setLength(0);
        }
    }
}
