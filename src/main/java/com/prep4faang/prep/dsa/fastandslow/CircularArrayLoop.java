package com.prep4faang.prep.dsa.fastandslow;

import java.util.*;

public class CircularArrayLoop {

    /**
     * Problem Statement:
     * 
     * There is a circular list of non-zero integers called nums. Each number in the list tells you how many steps 
     * to move forward or backward from your current position:
     *
     * - If nums[i] is positive, move nums[i] steps forward.
     * - If nums[i] is negative, move nums[i] steps backward.
     *
     * The list is circular:
     * - Moving forward from the last element takes you back to the first element.
     * - Moving backward from the first element takes you to the last element.
     *
     * A cycle in this list means:
     * - You keep moving according to the numbers, and you end up repeating a sequence of indexes.
     * - All numbers in the cycle have the same sign (either all positive or all negative).
     * - The cycle length is greater than 1 (it involves at least two indexes).
     *
     * Return true if such a cycle exists in the list or false otherwise.
     *
     * Constraints:
     * 1 <= nums.length <= 10^3
     * -5000 <= nums[i] <= 5000
     * nums[i] != 0
     */

    public static boolean circularArrayLoop(int[] nums) {
        int size = nums.length;
        for(int i=0;i<size;i++){
            int slow = i, fast = i;
            boolean forward = nums[i] > 0;
            while(true){
                slow = next(slow,nums[slow],size);
                if(hasNoCycle(slow, forward, nums))
                    break;
                fast = next(fast, nums[fast],size);
                if(hasNoCycle(fast, forward, nums))
                    break;
                fast = next(fast, nums[fast], size);
                if(hasNoCycle(fast,forward,nums))
                    break;
                if(fast == slow)
                    return true;
            }
        }

        return false;
    }

    public static boolean hasNoCycle(int pos, boolean prevDirection, int[] nums){
        boolean curDirection = nums[pos] >= 0;
        if(curDirection != prevDirection || (nums[pos] % nums.length == 0))
            return true;
        return false;
    }

    public static int next(int pos, int pointer, int size){
        int next = (pos + pointer)%size;
        if(next < 0)
            next = next + size;

        return next;
    }

    // Driver code to test your implementation
    public static void main(String[] args) {
        int[] nums = {2, -1, 1, 2, 2}; // Expected: true (valid cycle)
        System.out.println("Cycle exists: " + circularArrayLoop(nums));
    }
}
