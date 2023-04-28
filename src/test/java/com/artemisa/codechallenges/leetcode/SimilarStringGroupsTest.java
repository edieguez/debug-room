package com.artemisa.codechallenges.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimilarStringGroupsTest {

    /**
     * <a href="https://leetcode.com/problems/similar-string-groups/">839. Similar String Groups</a>
     */
    @Test
    void similarStringGroupsTest() {
        assertEquals(1, numSimilarGroups(new String[]{"omv", "ovm"}));
        assertEquals(2, numSimilarGroups(new String[]{"tars", "rats", "arts", "star"}));
    }

    private int numSimilarGroups(String[] strs) {
        int result = 0;

        for (int i = 0; i < strs.length; i++) {
            if (strs[i] != null) {
                result++;
                String str = strs[i];
                strs[i] = null;
                dfs(strs, str);
            }
        }

        return result;
    }

    private void dfs(String[] array, String str) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                if (isSimilar(str, array[i])) {
                    String s = array[i];
                    array[i] = null;
                    dfs(array, s);
                }
            }
        }
    }

    private boolean isSimilar(String strA, String strB) {
        int count = 0;

        for (int i = 0; i < strA.length(); i++) {
            if (strA.charAt(i) != strB.charAt(i)) {
                count++;
            }

            if (count > 2) {
                return false;
            }
        }

        return true;
    }
}
