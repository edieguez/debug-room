package com.artemisa.codechallenges.crackingthecodinginterview;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ZeroMatrixTest {

    @Test
    void zeroMatrixTest() {
        assertArrayEquals(new int[][]{
                {0, 0, 0, 0},
                {0, 1, 1, 1},
                {0, 1, 1, 1},
                {0, 1, 1, 1},
        }, zeroMatrix(new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
        }));

        assertArrayEquals(new int[][]{
                {1, 1, 1, 0},
                {1, 1, 1, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 0},
        }, zeroMatrix(new int[][]{
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 0},
        }));

        assertArrayEquals(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        }, zeroMatrix(new int[][]{
                {1, 1, 1, 1},
                {0, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
        }));

        assertArrayEquals(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        }, zeroMatrix(new int[][]{
                {1, 1, 0, 1},
                {1, 1, 0, 1},
                {1, 1, 0, 1},
                {1, 1, 0, 1},
        }));

        assertArrayEquals(new int[][]{
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
        }, zeroMatrix(new int[][]{
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
        }));

        assertArrayEquals(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        }, zeroMatrix(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        }));
    }

    private int[][] zeroMatrix(int[][] matrix) {
        Set<Integer> columns = new HashSet<>();

        for (int[] row : matrix) {
            boolean fillWithZeros = false;

            for (int column = 0; column < row.length; column++) {
                if (row[column] == 0) {
                    columns.add(column);
                    fillWithZeros = true;
                }
            }

            if (fillWithZeros) Arrays.fill(row, 0);
        }

        for (Integer column : columns) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][column] = 0;
            }
        }

        return matrix;
    }
}
