package com.artemisa.top10algorithms;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ArrayChunkTest {

    @Test
    void chunkTest() {
        assertNull(chunk(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8}, 0));

        Integer[][] chunks = chunk(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8}, 3);
        assertEquals("[[1, 2, 3], [4, 5, 6], [7, 8, null]]", Arrays.deepToString(chunks));

        chunks = chunk(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8}, 7);
        assertEquals("[[1, 2, 3, 4, 5, 6, 7], [8, null, null, null, null, null, null]]", Arrays.deepToString(chunks));

        chunks = chunk(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8}, 10);
        assertEquals("[[1, 2, 3, 4, 5, 6, 7, 8, null, null]]", Arrays.deepToString(chunks));

        chunks = chunk(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8}, 1);
        assertEquals("[[1], [2], [3], [4], [5], [6], [7], [8]]", Arrays.deepToString(chunks));

        chunks = chunk(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8}, 8);
        assertEquals("[[1, 2, 3, 4, 5, 6, 7, 8]]", Arrays.deepToString(chunks));
    }

    /**
     * Given an array and a size, divide the array into many subarrays where each subarray is of length size.
     *
     * @param array
     * @param size
     * @return
     */
    private Integer[][] chunk(Integer[] array, int size) {
        int arraySize;

        if (size == 0) {
            return null;
        } else if (array.length == size || array.length < size) {
            arraySize = 1;
        } else if (array.length % size == 0) {
            arraySize = array.length / size;
        } else {
            arraySize = array.length / size + 1;
        }

        Integer[][] chunks = new Integer[arraySize][size];
        int index = 0;

        for (Integer[] row : chunks) {
            for (int i = 0; i < row.length; i++) {
                if (index < array.length) {
                    row[i] = array[index];
                    index++;
                }
            }
        }

        return chunks;
    }
}
