package com.prep4faang.prep.dsa.fastandslow;

/**
 * Problem: Split a Circular Linked List
 *
 * Given a circular singly linked list of positive integers, split it into two separate circular linked lists.
 *
 * - The first list should contain the first ⌈n / 2⌉ nodes.
 * - The second list should contain the remaining nodes.
 * - Both lists should maintain the original order of the nodes.
 *
 * Return an array of two heads:
 *   answer[0] -> head of the first circular list
 *   answer[1] -> head of the second circular list
 *
 * Constraints:
 * - 2 ≤ n ≤ 10^3
 * - 0 ≤ Node.value ≤ 10^5
 * - LastNode.next = FirstNode
 *
 * Example:
 * Input: 1 -> 2 -> 3 -> 4 -> 5 -> (back to 1)
 * Output:
 *   First Half: 1 -> 2 -> 3 -> (back to 1)
 *   Second Half: 4 -> 5 -> (back to 4)
 */


public class SplitCircularLinkedList {

    /**
     * Splits a circular singly linked list into two halves.
     *
     * @param head The head of the circular linked list
     * @return An array containing two heads of the split circular lists
     */
    public static ListNode[] splitCircularLinkedList(ListNode head) {
       if(head == null || head.next == head){
           return new ListNode[]{head, null};
       }
       ListNode slow = head, fast = head;
       while(fast.next != head && fast.next.next != head){
           slow = slow.next;
           fast = fast.next.next;
       }

       ListNode head1 = head;
       ListNode head2= slow.next;
       slow.next = head1;

       fast = head2;
       while(fast.next != head){
           fast = fast.next;
       }
       fast.next = head2;



       return new ListNode[]{head1, head2};
    }

    // Helper method to create a circular linked list from an array

}
