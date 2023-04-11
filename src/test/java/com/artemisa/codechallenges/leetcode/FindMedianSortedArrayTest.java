package com.artemisa.codechallenges.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class FindMedianSortedArrayTest {

    /**
     * <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/">4. Median of Two Sorted Arrays</a>
     */
    @Test
    void findMedianSortedArrayTest() {
        assertEquals(0.0, findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0}));
        assertEquals(1.0, findMedianSortedArrays(new int[]{}, new int[]{1}));
        assertEquals(2.0, findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        assertEquals(4.0, findMedianSortedArrays(new int[]{1, 6, 10}, new int[]{3, 4}));
    }

    private double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = new int[nums1.length + nums2.length];

        System.arraycopy(nums1, 0, mergedArray, 0, nums1.length);
        System.arraycopy(nums2, 0, mergedArray, nums1.length, nums2.length);

        Arrays.sort(mergedArray);

        if (mergedArray.length % 2 == 0) {
            return (mergedArray[mergedArray.length / 2] + mergedArray[(mergedArray.length / 2) - 1]) / 2.0;
        } else {
            return mergedArray[mergedArray.length / 2];
        }
    }
}
