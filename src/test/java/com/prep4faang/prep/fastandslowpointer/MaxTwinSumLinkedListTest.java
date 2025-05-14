package com.prep4faang.prep.fastandslowpointer;

import com.prep4faang.prep.dsa.fastandslow.ListNode;
import com.prep4faang.prep.dsa.fastandslow.MaxTwinSumLinkedList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MaxTwinSumLinkedListTest {

    // Helper to create linked list from array
    private ListNode buildList(int[] values) {
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
    public void testBasicCase() {
        int[] input = {1, 2, 3, 4};
        ListNode head = buildList(input);
        assertEquals(5, MaxTwinSumLinkedList.pairSum(head));
    }

    @Test
    public void testAllSameValues() {
        int[] input = {5, 5, 5, 5};
        ListNode head = buildList(input);
        assertEquals(10, MaxTwinSumLinkedList.pairSum(head));
    }

    @Test
    public void testIncreasingValues() {
        int[] input = {1, 2, 3, 4, 5, 6};
        ListNode head = buildList(input);
        assertEquals(7, MaxTwinSumLinkedList.pairSum(head)); // pairs: 1+6=7, 2+5=7, 3+4=7
    }

    @Test
    public void testDecreasingValues() {
        int[] input = {10, 9, 8, 7, 6, 5};
        ListNode head = buildList(input);
        assertEquals(15, MaxTwinSumLinkedList.pairSum(head)); // pairs: 10+5=15, 9+6=15, 8+7=15
    }

    @Test
    public void testMinimumSize() {
        int[] input = {2, 4};
        ListNode head = buildList(input);
        assertEquals(6, MaxTwinSumLinkedList.pairSum(head));
    }

    @Test
    public void testLargeValues() {
        int[] input = {1000, 1, 1, 1000};
        ListNode head = buildList(input);
        assertEquals(2000, MaxTwinSumLinkedList.pairSum(head)); // 1000+1000
    }
}
