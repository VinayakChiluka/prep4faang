package com.prep4faang.prep.fastandslowpointer;

import com.prep4faang.prep.dsa.fastandslow.ListNode;
import com.prep4faang.prep.dsa.fastandslow.SplitCircularLinkedList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class SplitCircularLinkedListTest {

    // Helper to collect values from circular list
    private List<Integer> toList(ListNode head, int limit) {
        List<Integer> result = new ArrayList<>();
        ListNode current = head;
        int count = 0;
        while (current != null && count < limit) {
            result.add(current.val);
            current = current.next;
            if (current == head) break; // Stop if we circle back
            count++;
        }
        return result;
    }

    @Test
    public void testTwoNodeList() {
        ListNode head = createCircularList(new int[]{9, 10});
        ListNode[] result = SplitCircularLinkedList.splitCircularLinkedList(head);

        assertEquals(List.of(9), toList(result[0], 2));
        assertEquals(List.of(10), toList(result[1], 2));
    }

    @Test
    public void testOddLengthList() {
        ListNode head = createCircularList(new int[]{1, 2, 3, 4, 5});
        ListNode[] result = SplitCircularLinkedList.splitCircularLinkedList(head);

        assertEquals(List.of(1, 2, 3), toList(result[0], 5));
        assertEquals(List.of(4, 5), toList(result[1], 5));
    }

    @Test
    public void testEvenLengthList() {
        ListNode head = createCircularList(new int[]{1, 2, 3, 4});
        ListNode[] result = SplitCircularLinkedList.splitCircularLinkedList(head);

        assertEquals(List.of(1, 2), toList(result[0], 4));
        assertEquals(List.of(3, 4), toList(result[1], 4));
    }

    // Helper method to create a circular linked list from an array
    public static ListNode createCircularList(int[] values) {
        if (values == null || values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        current.next = head; // Make it circular
        return head;
    }

    @Test
    public void testAllSameValues() {
        ListNode head = createCircularList(new int[]{5, 5, 5, 5});
        ListNode[] result = SplitCircularLinkedList.splitCircularLinkedList(head);

        assertEquals(List.of(5, 5), toList(result[0], 4));
        assertEquals(List.of(5, 5), toList(result[1], 4));
    }

    @Test
    public void testMinimumValidLength() {
        ListNode head = createCircularList(new int[]{1, 2});
        ListNode[] result = SplitCircularLinkedList.splitCircularLinkedList(head);

        assertEquals(List.of(1), toList(result[0], 2));
        assertEquals(List.of(2), toList(result[1], 2));
    }



}
