package com.artemisa.codechallenges.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidateStackSequencesTest {

    /**
     * <a href="https://leetcode.com/problems/validate-stack-sequences/">946. Validate Stack Sequences</a>
     */
    @Test
    void validateStackSequencesTest() {
        assertTrue(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        assertFalse(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }

    private boolean validateStackSequences(int[] pushed, int[] popped) {
        int[] stack = new int[pushed.length];
        int top = -1;
        int i = 0;
        int j = 0;

        while (i < pushed.length) {
            stack[++top] = pushed[i++];

            while (top >= 0 && stack[top] == popped[j]) {
                top--;
                j++;
            }
        }

        return top == -1;
    }
}
