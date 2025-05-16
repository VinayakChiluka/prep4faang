package com.prep4faang.prep.fastandslowpointer;

import com.prep4faang.prep.dsa.fastandslow.LinkedListCycleRemover;
import com.prep4faang.prep.dsa.fastandslow.ListNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListCycleRemoverTest {

    private boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    private int countNodes(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    @Test
    public void testCycleInMiddle() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3; // Cycle from 5 -> 3

        ListNode result = LinkedListCycleRemover.detectAndRemoveCycle(head);
        assertFalse(hasCycle(result));
        assertEquals(5, countNodes(result));
    }

    @Test
    public void testLongListNoCycle() {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        for (int i = 1; i <= 50; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }

        ListNode result = LinkedListCycleRemover.detectAndRemoveCycle(head);
        assertFalse(hasCycle(result));
        assertEquals(51, countNodes(result));
    }

    @Test
    public void testTwoNodeCycle() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;  // Cycle from 2 -> 1

        ListNode result = LinkedListCycleRemover.detectAndRemoveCycle(head);
        assertFalse(hasCycle(result));
        assertEquals(2, countNodes(result));
    }

    @Test
    public void testMultipleNodesNoCycle() {
        ListNode head = new ListNode(5);
        ListNode curr = head;
        for (int i = 6; i <= 10; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }

        ListNode result = LinkedListCycleRemover.detectAndRemoveCycle(head);
        assertFalse(hasCycle(result));
        assertEquals(6, countNodes(result));
    }

    @Test
    public void testLargeCycle() {
        ListNode head = new ListNode(100);
        ListNode curr = head;
        ListNode cycleStart = null;

        for (int i = 101; i <= 200; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
            if (i == 150) {
                cycleStart = curr;
            }
        }

        curr.next = cycleStart; // Cycle from node 200 -> 150

        ListNode result = LinkedListCycleRemover.detectAndRemoveCycle(head);
        assertFalse(hasCycle(result));
        assertEquals(101, countNodes(result));
    }
}
