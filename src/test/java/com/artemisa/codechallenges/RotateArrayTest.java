package com.artemisa.codechallenges;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class RotateArrayTest {

    /**
     * Given a 3x3 matrix, rotate it by 90 degrees in clockwise direction.
     *
     * Example:
     * Before rotation:
     * {1, 2, 3},
     * {4, 5, 6},
     * {7, 8, 9}
     *
     * After rotation:
     * {7, 4, 1},
     * {8, 5, 2},
     * {9, 6, 3}
     */
    @Test
    void rotateArrayTest() {
        int[][] array = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        assertThat(rotateArray(array)).isEqualTo(new int[][]{
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        });
    }

    private int[][] rotateArray(int[][] array) {
        int[][] rotatedArray = new int[array[0].length][array.length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                rotatedArray[j][array.length - 1 - i] = array[i][j];
            }
        }

        return rotatedArray;
    }
}
