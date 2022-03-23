package com.artemisa.codechallenges;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class StepsToZeroTest {

    @Test
    void stepsToZeroTest() {
        assertThat(stepsToZero("1")).isEqualTo(1);
        assertThat(stepsToZero("10")).isEqualTo(2);
        assertThat(stepsToZero("101")).isEqualTo(4);
        assertThat(stepsToZero("11111")).isEqualTo(9);
        assertThat(stepsToZero("1111111111")).isEqualTo(19);
        assertThat(stepsToZero("0101010101")).isEqualTo(14);
        assertThat(stepsToZero("11100011100011100011")).isEqualTo(30);
        assertThat(stepsToZero("11100000000000000011")).isEqualTo(24);
    }

    private int stepsToZero(String input) {
        StringBuilder binary = new StringBuilder(input);
        int steps = 0;

        while (binary.length() > 0) {
            if (binary.charAt(binary.length() - 1) == '0') {
                binary.deleteCharAt(binary.length() - 1);
            } else {
                binary.replace(binary.length() - 1, binary.length(), "0");
            }

            steps++;
        }

        return steps - 1;
    }
}
