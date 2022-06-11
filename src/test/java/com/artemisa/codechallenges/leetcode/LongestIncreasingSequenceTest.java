package com.artemisa.codechallenges.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LongestIncreasingSequenceTest {

    /**
     * <a href="https://leetcode.com/problems/longest-increasing-subsequence">300. Longest Increasing Subsequence</a>
     * <p>
     * Given an integer array nums, return the length of the longest strictly increasing subsequence.
     * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing
     * the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
     * <p>
     * Example 1:
     * Input: nums = [10,9,2,5,3,7,101,18]
     * Output: 4
     * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
     * <p>
     * Example 2:
     * Input: nums = [0,1,0,3,2,3]
     * Output: 4
     * <p>
     * Example 3:
     * Input: nums = [7,7,7,7,7,7,7]
     * Output: 1
     */
    @Test
    void longestIncreasingSequence() {
        Assertions.assertEquals(4, lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        Assertions.assertEquals(4, lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        Assertions.assertEquals(1, lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
    }

    /**
     * Solution using dynamic programming
     */
    private int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    lis[i] = Math.max(lis[i], 1 + lis[j]);
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for (int xd : lis) {
            max = Math.max(xd, max);
        }

        return max;
    }
}
