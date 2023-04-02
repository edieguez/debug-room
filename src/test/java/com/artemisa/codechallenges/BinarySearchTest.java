package com.artemisa.codechallenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTest {

    @Test
    void binarySearchTest() {
        assertEquals(0, binarySearch(new int[]{1, 2, 3, 4, 5}, 1));
        assertEquals(1, binarySearch(new int[]{1, 2, 3, 4, 5}, 2));
        assertEquals(2, binarySearch(new int[]{1, 2, 3, 4, 5}, 3));
        assertEquals(-1, binarySearch(new int[]{1, 2, 3, 4, 5}, 6));
    }

    private int binarySearch(int[] array, int value) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (array[middle] == value) {
                return middle;
            } else if (array[middle] < value) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }
}
