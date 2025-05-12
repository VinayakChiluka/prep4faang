package com.prep4faang.prep.fastandslowpointer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MiddleOfLinkedListTest {

    private ListNode createLinkedList(int... values) {
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
    public void testOddLengthList() {
        MiddleOfLinkedList solution = new MiddleOfLinkedList();
        ListNode head = createLinkedList(1, 2, 3, 4, 5);
        ListNode middle = solution.middleNode(head);
        assertEquals(3, middle.val);
    }

    @Test
    public void testEvenLengthList() {
        MiddleOfLinkedList solution = new MiddleOfLinkedList();
        ListNode head = createLinkedList(1, 2, 3, 4, 5, 6);
        ListNode middle = solution.middleNode(head);
        assertEquals(4, middle.val);
    }

    @Test
    public void testSingleElementList() {
        MiddleOfLinkedList solution = new MiddleOfLinkedList();
        ListNode head = createLinkedList(10);
        ListNode middle = solution.middleNode(head);
        assertEquals(10, middle.val);
    }

    @Test
    public void testTwoElementList() {
        MiddleOfLinkedList solution = new MiddleOfLinkedList();
        ListNode head = createLinkedList(10, 20);
        ListNode middle = solution.middleNode(head);
        assertEquals(20, middle.val); // second middle
    }

    @Test
    public void testThreeElementList() {
        MiddleOfLinkedList solution = new MiddleOfLinkedList();
        ListNode head = createLinkedList(1, 2, 3);
        ListNode middle = solution.middleNode(head);
        assertEquals(2, middle.val);
    }
}
