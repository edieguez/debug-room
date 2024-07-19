package com.artemisa.top10algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CapitalizeTest {

    @Test
    void capitalizeTest() {
        assertEquals("Hello World", capitalize("hello world"));
        assertEquals("I Love Java", capitalize("I love java"));
    }

    private String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        String[] words = str.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            sb.append(Character.toUpperCase(word.charAt(0)))
              .append(word.substring(1))
              .append(" ");
        }

        return sb.toString().strip();
    }
}
