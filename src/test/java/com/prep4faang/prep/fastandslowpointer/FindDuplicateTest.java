package com.prep4faang.prep.fastandslowpointer;

import com.prep4faang.prep.dsa.fastandslow.FindDuplicate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FindDuplicateTest {

    @Test
    public void testDuplicateAtEnd() {
        int[] nums = {1, 3, 4, 2, 2};
        assertEquals(2, FindDuplicate.findDuplicate(nums));
    }

    @Test
    public void testDuplicateAtStart() {
        int[] nums = {3, 1, 3, 4, 2};
        assertEquals(3, FindDuplicate.findDuplicate(nums));
    }

    @Test
    public void testMinimumInputSize() {
        int[] nums = {1, 1};
        assertEquals(1, FindDuplicate.findDuplicate(nums));
    }

    @Test
    public void testAllSameExceptOne() {
        int[] nums = {2, 2, 2, 2, 2};
        assertEquals(2, FindDuplicate.findDuplicate(nums));
    }

    @Test
    public void testDuplicateInMiddle() {
        int[] nums = {1, 4, 6, 5, 3, 2, 6};
        assertEquals(6, FindDuplicate.findDuplicate(nums));
    }

    @Test
    public void testLargeN() {
        int[] nums = new int[1001];
        for (int i = 0; i < 1000; i++) {
            nums[i] = i + 1;
        }
        nums[1000] = 500; // duplicate
        assertEquals(500, FindDuplicate.findDuplicate(nums));
    }
}
