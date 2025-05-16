package com.prep4faang.prep.dsa.fastandslow;

/**
 * Problem Statement:
 * Given the head of a linked list, determine the length of the cycle present in the linked list.
 * If there is no cycle, return 0.
 * 
 * A cycle exists in a linked list if there is some node in the list that can be reached again 
 * by continuously following the next pointer.
 * 
 * Constraints:
 * - The number of nodes in the list is in the range [0, 10^4].
 * - Node.value is in the range [-10^5, 10^5].
 */

public class CycleLengthInLinkedList {


    /**
     * Returns the length of the cycle in the linked list, or 0 if no cycle exists.
     *
     * @param head the head of the linked list
     * @return the length of the cycle, or 0 if no cycle
     */
    public static int cycleLength(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                break;
        }
        int result = 0;
        if(fast == null || fast.next == null)
            return result;

        do{
            fast = fast.next;
            result++;
        }while(fast != slow);
        return result;
    }
}
