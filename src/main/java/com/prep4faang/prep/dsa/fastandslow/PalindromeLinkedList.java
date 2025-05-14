package com.prep4faang.prep.dsa.fastandslow;

/**
 * Problem: Palindrome Linked List
 *
 * Given the head of a singly linked list, check whether it is a palindrome.
 * Return true if it is, otherwise return false.
 *
 * Note: You must not modify the original linked list structure after checking.
 *
 * Constraints:
 * - The number of nodes in the list is between 1 and 500.
 * - Each node contains an integer value between 0 and 9.
 */

public class PalindromeLinkedList {

    /**
     * Checks whether a singly linked list is a palindrome.
     *
     * @param head The head of the singly linked list.
     * @return true if the linked list is a palindrome, false otherwise.
     */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = reverse(slow);
        ListNode copySecondHalf = secondHalf;
        ListNode firstHalf = head;
        while(firstHalf != null && secondHalf != null){
            if(firstHalf.val != secondHalf.val)
                return false;
            firstHalf=firstHalf.next;
            secondHalf=secondHalf.next;
        }
        return true; // Placeholder return
    }
    public ListNode reverse(ListNode head){
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
