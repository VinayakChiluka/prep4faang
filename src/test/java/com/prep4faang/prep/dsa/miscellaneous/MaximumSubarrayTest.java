package com.prep4faang.prep.dsa.miscellaneous;

import com.prep4faang.prep.dsa.miscellaneous.MaximumSubarray;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MaximumSubarrayTest {

    @Test
    public void testMixedNumbers() {
        int[] nums = {1, -2, 3, 4, -1, 2, 1, -5, 4};
        assertEquals(9, MaximumSubarray.maxSubArray(nums));
    }

    @Test
    public void testAllNegativeNumbers() {
        int[] nums = {-2, -3, -1, -5};
        assertEquals(-1, MaximumSubarray.maxSubArray(nums));
    }

    @Test
    public void testAllPositiveNumbers() {
        int[] nums = {1, 2, 3, 4};
        assertEquals(10, MaximumSubarray.maxSubArray(nums));
    }

    @Test
    public void testSingleElementPositive() {
        int[] nums = {7};
        assertEquals(7, MaximumSubarray.maxSubArray(nums));
    }

    @Test
    public void testSingleElementNegative() {
        int[] nums = {-7};
        assertEquals(-7, MaximumSubarray.maxSubArray(nums));
    }

    @Test
    public void testLargePositiveAndNegativeAlternating() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assertEquals(6, MaximumSubarray.maxSubArray(nums));
    }
}
