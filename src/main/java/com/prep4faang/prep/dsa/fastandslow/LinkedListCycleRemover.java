package com.prep4faang.prep.dsa.fastandslow;

/**
 * Problem: Linked List Cycle IV
 *
 * Statement:
 * Given the head of a singly linked list, implement a function to detect and remove any cycle present in the list.
 * A cycle occurs when a node's next pointer links back to a previous node, forming a loop within the list.
 *
 * The function must modify the linked list in place, ensuring it remains acyclic while preserving the original node order.
 * If no cycle is found, return the linked list as is.
 *
 * Constraints:
 * - The number of nodes in the list is in the range [0, 10^4]
 * - Node values are in the range [-10^5, 10^5]
 */


public class LinkedListCycleRemover {

    /**
     * Detects and removes a cycle in the linked list, if any.
     *
     * @param head Head of the singly linked list
     * @return Head of the modified list with the cycle removed
     */
    public static ListNode detectAndRemoveCycle(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;

        // Step 1: Detect cycle using Floyd’s Tortoise and Hare algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if(fast == null || fast.next == null)
            return head;

        slow = head;
        while(slow != fast){
            fast = fast.next;
            slow = slow.next;
        }

        while(fast.next != slow){
            fast = fast.next;
        }
        fast.next = null;

        return head;
    }
}
