package com.prep4faang.prep.fastandslowpointer;

import com.prep4faang.prep.dsa.fastandslow.ListNode;
import org.junit.jupiter.api.Test;

import static com.prep4faang.prep.dsa.fastandslow.CycleLengthInLinkedList.cycleLength;
import static org.junit.jupiter.api.Assertions.*;

public class CycleLengthInLinkedListTest {

    // Utility method to create a linked list with a cycle
    private ListNode createListWithCycle(int[] values, int pos) {
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        ListNode cycleEntry = null;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
            if (i == pos) {
                cycleEntry = current;
            }
        }

        if (pos == 0) {
            cycleEntry = head;
        }

        // Create the cycle
        if (cycleEntry != null) {
            current.next = cycleEntry;
        }

        return head;
    }

    @Test
    public void testCycleLengthZeroWhenListIsNull() {
        assertEquals(0, cycleLength(null));
    }

    @Test
    public void testCycleLengthZeroWhenNoCycle() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        assertEquals(0, cycleLength(head));
    }

    @Test
    public void testCycleLengthWithCycleOf3() {
        int[] values = {1, 2, 3, 4, 5};
        ListNode head = createListWithCycle(values, 2); // Cycle at node with value 3
        assertEquals(3, cycleLength(head));
    }

    @Test
    public void testCycleLengthWithFullCycle() {
        int[] values = {10, 20, 30};
        ListNode head = createListWithCycle(values, 0); // Full cycle
        assertEquals(3, cycleLength(head));
    }

    @Test
    public void testCycleLengthWithSingleElementCycle() {
        ListNode head = new ListNode(1);
        head.next = head; // Self-loop
        assertEquals(1, cycleLength(head));
    }
}
