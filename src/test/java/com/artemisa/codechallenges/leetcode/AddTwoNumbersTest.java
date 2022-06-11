package com.artemisa.codechallenges.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class AddTwoNumbersTest {

    /**
     * <a href="https://leetcode.com/problems/add-two-numbers/">2. Add Two Numbers</a>
     * <p>
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and
     * return the sum as a linked list.
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     * <p>
     * Example 1:
     * 2 -> 4 -> 3
     * 5 -> 6 -> 4
     * -----------
     * 7 -> 0 -> 8
     * <p>
     * Input: l1 = [2,4,3], l2 = [5,6,4]
     * Output: [7,0,8]
     * Explanation: 342 + 465 = 807.
     * <p>
     * Example 2:
     * Input: l1 = [0], l2 = [0]
     * Output: [0]
     * <p>
     * Example 3:
     * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * Output: [8,9,9,9,0,0,0,1]
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in each linked list is in the range [1, 100].
     * 0 <= Node.val <= 9
     * It is guaranteed that the list represents a number that does not have leading zeros.
     */
    @Test
    void addTwoNumbers() {
        ListNode l1 = new ListNode(3, new ListNode(4, new ListNode(2)));
        ListNode l2 = new ListNode(4, new ListNode(6));

        assertEquals("703", addTwoNumbers(l1, l2).toString());
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode currentNode = result;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int operand1 = l1 != null ? l1.val : 0;
            int operand2 = l2 != null ? l2.val : 0;
            int value = operand1 + operand2 + carry;
            carry = value / 10;

            currentNode.val = value % 10;

            if ((l1 != null && l1.next != null) || (l2 != null && l2.next != null) || carry != 0) {
                currentNode.next = new ListNode();
                currentNode = currentNode.next;
            }

            l1 = l1 != null && l1.next != null ? l1.next : null;
            l2 = l2 != null && l2.next != null ? l2.next : null;
        }

        return result;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return String.format("%s%s", val, next != null ? next.toString() : "");
        }
    }
}
