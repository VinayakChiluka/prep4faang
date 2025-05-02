package com.prep4faang.prep.dsa.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> solve(int[] nums){
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for(int pivot=0;pivot < nums.length; pivot++){
            // elements sorted first value if is positive value then it result is not possible
            if(nums[pivot] > 0)
                break;

            if (pivot > 0 && nums[pivot] == nums[pivot - 1]) {
                continue;
            }

            int low = pivot + 1;
            int high = nums.length-1;
            while(low < high){
                int total = nums[low] + nums[high] + nums[pivot];
                if(total == 0){
                    result.add(Arrays.asList(nums[pivot], nums[low], nums[high]));
                    low++;
                    high--;
                    while(low < high && nums[low] == nums[low-1])
                        low++;
                    while(low < high && nums[high] == nums[high+1])
                        high--;
                }
                else if(total > 0)
                    high--;
                else
                    low++;


            }

        }

        return result;
    }
}
