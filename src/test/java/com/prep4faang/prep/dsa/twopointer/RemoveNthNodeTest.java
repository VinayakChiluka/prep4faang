package com.prep4faang.prep.dsa.twopointer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeTest {

    // Helper method to convert array to linked list
    private ListNode toLinkedList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper method to convert linked list to array
    private int[] toArray(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    @Test
    public void testRemove2ndFromEnd() {
        ListNode head = toLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode result = new RemoveNthNode().removeNthFromEnd(head, 2);
        assertArrayEquals(new int[]{1, 2, 3, 5}, toArray(result));
    }

    @Test
    public void testRemoveOnlyNode() {
        ListNode head = toLinkedList(new int[]{1});
        ListNode result = new RemoveNthNode().removeNthFromEnd(head, 1);
        assertArrayEquals(new int[]{}, toArray(result));
    }

    @Test
    public void testRemoveLastOfTwo() {
        ListNode head = toLinkedList(new int[]{1, 2});
        ListNode result = new RemoveNthNode().removeNthFromEnd(head, 1);
        assertArrayEquals(new int[]{1}, toArray(result));
    }

    @Test
    public void testRemoveFirstOfTwo() {
        ListNode head = toLinkedList(new int[]{1, 2});
        ListNode result = new RemoveNthNode().removeNthFromEnd(head, 2);
        assertArrayEquals(new int[]{2}, toArray(result));
    }
}
