package com.prep4faang.prep.dsa.fastandslow;

import java.util.List;

public class CycleInLinkedList {

    /**
     * Determines whether the linked list has a cycle.
     *
     * A cycle occurs when a node in the list points back to a previous node,
     * creating an infinite loop. This method returns true if such a cycle exists,
     * otherwise returns false.
     *
     * @param head the head node of the singly linked list
     * @return true if there is a cycle in the list, false otherwise
     *
     * Constraints:
     * - 0 <= n <= 500  (n is the number of nodes in the linked list)
     * - -10^5 <= Node.val <= 10^5  (Each node's value range)
     */
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;

        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }
}
