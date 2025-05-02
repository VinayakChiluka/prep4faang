package com.prep4faang.prep.dsa.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> solve(int[] nums){
        List<List<Integer>> result = new ArrayList<>();

        // Step 1: Sort the array to use two-pointer technique
        Arrays.sort(nums);

        // Step 2: Iterate through each element, considering it as the pivot (first element of the triplet)
        for(int pivot = 0; pivot < nums.length; pivot++){

            // Optimization: If the pivot is > 0, no further triplets can sum to zero (array is sorted)
            if(nums[pivot] > 0)
                break;

            // Skip duplicate values for the pivot to avoid repeated triplets
            if (pivot > 0 && nums[pivot] == nums[pivot - 1]) {
                continue;
            }

            // Step 3: Initialize two pointers
            int low = pivot + 1;
            int high = nums.length - 1;

            // Step 4: Use two-pointer technique to find valid triplets
            while(low < high){
                int total = nums[low] + nums[high] + nums[pivot];

                if(total == 0){
                    // Found a valid triplet
                    result.add(Arrays.asList(nums[pivot], nums[low], nums[high]));

                    // Move both pointers and skip duplicates
                    low++;
                    high--;

                    // Skip duplicates for low
                    while(low < high && nums[low] == nums[low - 1])
                        low++;

                    // Skip duplicates for high
                    while(low < high && nums[high] == nums[high + 1])
                        high--;
                }
                else if(total > 0){
                    // If sum is too large, move the high pointer to reduce the sum
                    high--;
                }
                else {
                    // If sum is too small, move the low pointer to increase the sum
                    low++;
                }
            }
        }

        // Return the list of all unique triplets that sum to zero
        return result;
    }
}
