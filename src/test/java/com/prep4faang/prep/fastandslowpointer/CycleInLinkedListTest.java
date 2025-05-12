package com.prep4faang.prep.fastandslowpointer;

import com.prep4faang.prep.dsa.fastandslow.CycleInLinkedList;
import com.prep4faang.prep.dsa.fastandslow.ListNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CycleInLinkedListTest {

    private ListNode createCyclicList(int[] values, int pos) {
        ListNode head = new ListNode(values[0]);
        ListNode curr = head;
        ListNode cycleNode = head;

        for (int i = 1; i < values.length; i++) {
            curr.next = new ListNode(values[i]);
            curr = curr.next;
            if (i == pos) {
                cycleNode = curr;
            }
        }

        if (pos >= 0) {
            curr.next = cycleNode; // Create the cycle
        }

        return head;
    }


    @Test
    public void testEmptyList() {
        CycleInLinkedList solution = new CycleInLinkedList();
        assertFalse(solution.hasCycle(null));
    }

    @Test
    public void testSingleNode_NoCycle() {
        CycleInLinkedList solution = new CycleInLinkedList();
        ListNode node = new ListNode(1);
        assertFalse(solution.hasCycle(node));
    }

    @Test
    public void testTwoNodes_NoCycle() {
        CycleInLinkedList solution = new CycleInLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        assertFalse(solution.hasCycle(head));
    }

    @Test
    public void testCycleAtBeginning() {
        CycleInLinkedList solution = new CycleInLinkedList();
        int[] values = {3, 2, 0, -4};
        ListNode head = createCyclicList(values, 0);
        assertTrue(solution.hasCycle(head));
    }

    @Test
    public void testCycleInMiddle() {
        CycleInLinkedList solution = new CycleInLinkedList();
        int[] values = {1, 2, 3, 4, 5};
        ListNode head = createCyclicList(values, 2);
        assertTrue(solution.hasCycle(head));
    }

    @Test
    public void testNoCycle() {
        CycleInLinkedList solution = new CycleInLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        assertFalse(solution.hasCycle(head));
    }
}
