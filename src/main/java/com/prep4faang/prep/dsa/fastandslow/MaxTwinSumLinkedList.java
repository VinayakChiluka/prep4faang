package com.prep4faang.prep.dsa.fastandslow;// Problem: Maximum Twin Sum of a Linked List
//
// In a linked list with an even number of nodes (n),
// each node at position i (0-based indexing) is paired with the node at position (n - 1 - i).
// These pairs are called "twins".
// The twin sum is the sum of the values of a node and its twin.
//
// Given the head of a linked list with an even number of nodes, 
// return the maximum twin sum among all twin pairs.
//
// Constraints:
// - The number of nodes is even and in the range [2, 1000].
// - Each node’s value is in the range [1, 1000].

public class MaxTwinSumLinkedList {

    // Method stub to implement the logic
    public  static int pairSum(ListNode head) {

        ListNode secondHalfHead = getMiddle(head);
        ListNode secondHalf = secondHalfHead.next;
        secondHalfHead.next = reverse(secondHalf);
        ListNode firstHalf = head;
        secondHalf = secondHalfHead.next;
        int max = Integer.MIN_VALUE;
        while(firstHalf != null && secondHalf != null){
            int sum = firstHalf.val + secondHalf.val;
            max = Math.max(sum, max);
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        secondHalfHead.next = reverse(secondHalf);
        return max;
    }
    private static void print(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    private static ListNode getMiddle(ListNode head){
        ListNode slow = head, fast = head, prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev;
    }
    private static ListNode reverse(ListNode head){
        ListNode current = head, prev = null, next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }


}
