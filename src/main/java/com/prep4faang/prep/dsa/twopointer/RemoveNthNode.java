package com.prep4faang.prep.dsa.twopointer;

/**
 * Problem: Remove Nth Node from End of List
 *
 * Given the head of a singly linked list, remove the nth node from the end of the list and return its head.
 *
 * Constraints:
 * - The number of nodes in the list is k.
 * - 1 <= k <= 10^3
 * - -10^3 <= Node.value <= 10^3
 * - 1 <= n <= k
 *
 * Example:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode left = head;
        ListNode right = head;
        for(int i=0;i<n;i++){
            right = right.next;
        }
        if(right == null)
            return head.next;

        ListNode prev = null;
        while(right != null){
            prev = left;
            left = left.next;
            right = right.next;
        }
        prev.next = left.next;

        return head;
    }
}
