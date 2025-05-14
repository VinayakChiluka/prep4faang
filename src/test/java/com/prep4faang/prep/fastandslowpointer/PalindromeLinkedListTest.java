package com.prep4faang.prep.fastandslowpointer;

import static org.junit.jupiter.api.Assertions.*;

import com.prep4faang.prep.dsa.fastandslow.ListNode;
import com.prep4faang.prep.dsa.fastandslow.PalindromeLinkedList;
import org.junit.jupiter.api.Test;

public class PalindromeLinkedListTest {

    // Utility method to create a linked list from an array
    private ListNode createList(int[] values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    @Test
    public void testSingleElementList() {
        ListNode head = createList(new int[]{1});
        PalindromeLinkedList pll = new PalindromeLinkedList();
        assertTrue(pll.isPalindrome(head));
    }

    @Test
    public void testTwoElementPalindrome() {
        ListNode head = createList(new int[]{2, 2});
        PalindromeLinkedList pll = new PalindromeLinkedList();
        assertTrue(pll.isPalindrome(head));
    }

    @Test
    public void testTwoElementNonPalindrome() {
        ListNode head = createList(new int[]{1, 2});
        PalindromeLinkedList pll = new PalindromeLinkedList();
        assertFalse(pll.isPalindrome(head));
    }

    @Test
    public void testOddLengthPalindrome() {
        ListNode head = createList(new int[]{1, 2, 1});
        PalindromeLinkedList pll = new PalindromeLinkedList();
        assertTrue(pll.isPalindrome(head));
    }

    @Test
    public void testEvenLengthPalindrome() {
        ListNode head = createList(new int[]{1, 2, 2, 1});
        PalindromeLinkedList pll = new PalindromeLinkedList();
        assertTrue(pll.isPalindrome(head));
    }

    @Test
    public void testLongNonPalindrome() {
        ListNode head = createList(new int[]{1, 2, 3, 4, 5});
        PalindromeLinkedList pll = new PalindromeLinkedList();
        assertFalse(pll.isPalindrome(head));
    }

    @Test
    public void testLongPalindrome() {
        ListNode head = createList(new int[]{1, 2, 3, 2, 1});
        PalindromeLinkedList pll = new PalindromeLinkedList();
        assertTrue(pll.isPalindrome(head));
    }
}
