package com.artemisa.codechallenges.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RotateImageTest {

    /**
     * <a href="https://leetcode.com/problems/rotate-image">48. Rotate Image</a>
     */
    @Test
    void rotateImageTest() {
        int[][] array = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // The rotation is done in-situ
        rotate(array);

        assertArrayEquals(array, new int[][]{
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        });
    }

    private void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][j];

                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }
}
