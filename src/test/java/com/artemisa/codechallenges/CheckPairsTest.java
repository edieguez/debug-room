package com.artemisa.codechallenges;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckPairsTest {

    /**
     * Given a String with the following possible characters `[]{}()`.
     * Determine if all opening characters have a closing character and if they are closed in the right order.
     *
     * If the String has all the pairs closed and in the right order return true. Otherwise return false.
     * Assume that the input String is always != null and only has valid.characters.
     * An empty String is also a valid scenario.
     *
     * Examples:
     *  "()" => true
     *  "(())" => true
     *  "{[()]}" => true
     *  "(]" => false
     *  "[{]}" => false
     *  "][" => false
     *  "([{" => false
     *  "()[]" => true
     */
    @Test
    void checkPairsTest() {
        assertThat(checkPairs("()")).isTrue();
        assertThat(checkPairs("(())")).isTrue();
        assertThat(checkPairs("{[()]}")).isTrue();
        assertThat(checkPairs("(]")).isFalse();
        assertThat(checkPairs("[{]}")).isFalse();
        assertThat(checkPairs("][")).isFalse();
        assertThat(checkPairs("([{")).isFalse();
        assertThat(checkPairs("()[]")).isTrue();
    }

    private boolean checkPairs(String input) {
        if (input.length() == 0) {
            return false;
        }

        char currentCharacter = input.charAt(0);

        if (!isOpeningCharacter(currentCharacter)) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        stack.push(currentCharacter);

        Map<Character, Character> closingCharacters = new HashMap<>();
        closingCharacters.put('{', '}');
        closingCharacters.put('[', ']');
        closingCharacters.put('(', ')');

        for (int i = 1; i < input.length(); i++) {
            currentCharacter = input.charAt(i);

            if (isOpeningCharacter(currentCharacter)) {
                stack.push(currentCharacter);
            } else if (closingCharacters.get(stack.peek()) == currentCharacter) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean isOpeningCharacter(char character) {
        return "{[(".contains(String.valueOf(character));
    }
}
