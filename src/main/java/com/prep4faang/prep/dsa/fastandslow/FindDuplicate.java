package com.prep4faang.prep.dsa.fastandslow; /**
 * Problem: Find the Duplicate Number
 *
 * Given an array of positive numbers, nums, such that the values lie in the range [1, n], inclusive, and that there are n + 1 numbers in the array,
 * find and return the duplicate number present in nums. There is only one repeated number in nums, but it may appear more than once in the array.
 *
 * Note:
 * - You cannot modify the given array nums.
 * - You have to solve the problem using only constant extra space.
 *
 * Constraints:
 * 1 <= n <= 1000
 * nums.length = n + 1
 * 1 <= nums[i] <= n
 * All the integers in nums are unique, except for one integer that will appear more than once.
 *
 * Example:
 * Input: nums = [1, 3, 4, 2, 2]
 * Output: 2
 *
 * Input: nums = [3, 1, 3, 4, 2]
 * Output: 3
 */

import java.util.*;

public class FindDuplicate {
    
    /**
     * Finds the duplicate number in the array using Floyd’s Tortoise and Hare (Cycle Detection) algorithm.
     *
     * @param nums - An array containing n + 1 integers where each integer is in the range [1, n]
     * @return The duplicated number
     */
    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: Detect intersection point in cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find the entrance to the cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow; // or fast, both are equal here
    }

    // Example usage
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4, 2, 2};
        int[] nums2 = {3, 1, 3, 4, 2};

        System.out.println("Duplicate in nums1: " + findDuplicate(nums1)); // Output: 2
        System.out.println("Duplicate in nums2: " + findDuplicate(nums2)); // Output: 3
    }
}
