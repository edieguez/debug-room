package com.artemisa.codesignal;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C13ReverseInParenthesesTest {

    @Test
    void reverseInParenthesesTest() {
        // Write a function that reverses characters in (possibly nested) parentheses in the input string.
        // Input strings will always be well-formed with matching ()s.
        assertEquals("", this.solution(""));
        assertEquals("", this.solution("()"));
        assertEquals("cbadgfe", this.solution("(abc)d(efg)"));
        assertEquals("foorabbazmilb", this.solution("foo(bar)baz(blim)"));
        assertEquals("foobazrabblim", this.solution("foo(bar(baz))blim"));
    }

    String solution(String inputString) {
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder current = new StringBuilder();

        for (char c : inputString.toCharArray()) {
            if (c == '(') {
                stack.push(current);
                current = new StringBuilder();
            } else if (c == ')') {
                current.reverse();
                current = stack.pop().append(current);
            } else {
                current.append(c);
            }
        }

        return current.toString();
    }
}
