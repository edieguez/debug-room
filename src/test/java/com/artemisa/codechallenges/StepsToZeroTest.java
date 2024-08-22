package com.artemisa.codechallenges;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class StepsToZeroTest {
    /*
    * Given a binary number, return the number of steps to reduce it to zero.
    *  1. If the current number is even, you have to divide it by 2.
    *  2. If the current number is odd, you have to subtract 1 from it.
    *
    * Example:
    *  16 | 8 | 4 | 2 | 1 |
    * ----+---+---+---+---|
    *   1 | 1 | 1 | 1 | 1 |  Step 1: 31 is odd,  subtract 1
    *   1 | 1 | 1 | 1 | 0 |  Step 2: 30 is even, divide by 2
    *     | 1 | 1 | 1 | 1 |  Step 3: 15 is odd,  subtract 1
    *     | 1 | 1 | 1 | 0 |  Step 4: 14 is even, divide by 2
    *     |   | 1 | 1 | 1 |  Step 5:  7 is odd,  subtract 1
    *     |   | 1 | 1 | 0 |  Step 6:  6 is even, divide by 2
    *     |   |   | 1 | 1 |  Step 7:  3 is odd,  subtract 1
    *     |   |   | 1 | 0 |  Step 8:  2 is even, divide by 2
    *     |   |   |   | 1 |  Step 9:  1 is odd,  subtract 1
    *     |   |   |   | 0 |  Zero reached. No more steps.
    * */

    @Test
    void stepsToZeroTest() {
        assertThat(stepsToZero("0")).isEqualTo(0);
        assertThat(stepsToZero("1")).isEqualTo(1);
        assertThat(stepsToZero("10")).isEqualTo(2);
        assertThat(stepsToZero("101")).isEqualTo(4);
        assertThat(stepsToZero("11111")).isEqualTo(9);
        assertThat(stepsToZero("1111111111")).isEqualTo(19);
        assertThat(stepsToZero("0101010101")).isEqualTo(13);
        assertThat(stepsToZero("11100011100011100011")).isEqualTo(30);
        assertThat(stepsToZero("11100000000000000011")).isEqualTo(24);
        assertThat(stepsToZero("00000000000000000001")).isEqualTo(1);
    }

    private int stepsToZero(String input) {
        if (input.matches("^0+$")) {
            return 0;
        }

        StringBuilder binary = new StringBuilder(input.replaceAll("^0+", ""));
        int steps = 0;

        while (binary.indexOf("1") != -1) {
            if (binary.charAt(binary.length() - 1) == '0') {
                binary.deleteCharAt(binary.length() - 1);
            } else {
                binary.setCharAt(binary.length() - 1, '0');
            }

            steps++;
        }

        return steps;
    }
}
