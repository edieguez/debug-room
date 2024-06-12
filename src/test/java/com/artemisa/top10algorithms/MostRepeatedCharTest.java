package com.artemisa.top10algorithms;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MostRepeatedCharTest {

    @Test
    void mostRepeatedCharTest() {
        assertEquals('A', getMostRepeatedChar("ABCDEA"));
        assertEquals('I', getMostRepeatedChar("ITANIMULLI"));
        assertEquals('A', getMostRepeatedChar("ABCDEFGHI"));
        assertNull(getMostRepeatedChar(null));
    }

    private Character getMostRepeatedChar(String string) {
        if (string == null || string.isEmpty()) {
            return null;
        }

        Map<Character, Integer> characters = new HashMap<>();

        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);

            if (characters.containsKey(character)) {
                characters.put(character, characters.get(character) + 1);
            } else {
                characters.put(character, 1);
            }
        }

        Optional<Map.Entry<Character, Integer>> mostCommonEntry = characters.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        return mostCommonEntry.map(Map.Entry::getKey).orElse(null);
    }
}
