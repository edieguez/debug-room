package com.artemisa.codechallenges.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimplifyPathTest {

    /**
     * <a href="https://leetcode.com/problems/simplify-path/">71. Simplify Path</a>
     */
    @Test
    void simplifyPathTest() {
        assertEquals("/home", simplifyPath("/home/"));
        assertEquals("/", simplifyPath("/../"));
        assertEquals("/.../home/dev", simplifyPath("/../../.././../.../home/dev///"));
    }

    private String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] pathArray = path.replaceAll("/$", "").split("/");

        for (String s : pathArray) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!s.equals(".") && !s.equals("")) {
                stack.push(s);
            }
        }

        StringBuilder builder = new StringBuilder();

        for (String s : stack) {
            builder.append("/").append(s);
        }

        return builder.length() == 0 ? "/" : builder.toString();
    }
}
