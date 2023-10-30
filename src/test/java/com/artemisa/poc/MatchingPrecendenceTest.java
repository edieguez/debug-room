package com.artemisa.poc;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatchingPrecendenceTest {

    @Test
    /*
    When a method is overloaded, Java tries to find the most suitable method using the 'least resistance path'.
    That means if a method matches exactly the parameter type, it will be used. If not, it will continue 'sclating'
    the parameter type until it finds a suitable method
     */
    void matchingPrecedenceTest() {
        assertEquals(glide("a"), "String match: a");
        assertEquals(glide("a", "b"), "Multiple args match: a, b");
        assertEquals(glide("a", "b", "c"), "Varargs match: [a, b, c]");
    }

    private String glide(String s) {
        return String.format("String match: %s", s);
    }

    private String glide(String... strings) {
        return String.format("Varargs match: %s", Arrays.toString(strings));
    }

    private String glide(Object o) {
        return String.format("Object match: %s", o);
    }

    private String glide(String s, String t) {
        return String.format("Multiple args match: %s, %s", s, t);
    }
}
