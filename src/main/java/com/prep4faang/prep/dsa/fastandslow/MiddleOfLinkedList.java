package com.prep4faang.prep.dsa.fastandslow;/*
 * Problem: Middle of the Linked List
 *
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If the number of nodes in the linked list is even, return the second middle node.
 *
 * Constraints:
 * - 1 <= n <= 100 (where n is the number of nodes in the linked list)
 * - 1 <= Node.val <= 100
 * - The linked list is non-empty (head != null)
 *
 * Example 1:
 * Input: 1 -> 2 -> 3 -> 4 -> 5
 * Output: Node with value 3
 *
 * Example 2:
 * Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6
 * Output: Node with value 4
 *
 * Approach:
 * Use two pointers: a slow pointer that moves one step at a time,
 * and a fast pointer that moves two steps at a time.
 * When the fast pointer reaches the end, the slow pointer will be at the middle.
 */


public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Move 'fast' by 2 steps and 'slow' by 1 step
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 'slow' now points to the middle node
        return slow;
    }

    // Optional: Helper method to print the list from a node
    public void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

}
