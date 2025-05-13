package com.prep4faang.prep.fastandslowpointer;

import com.prep4faang.prep.dsa.fastandslow.CircularArrayLoop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CircularArrayLoopTest {

    @Test
    public void testCycleExistsPositiveLoop() {
        int[] nums = {2, -1, 1, 2, 2};
        assertTrue(CircularArrayLoop.circularArrayLoop(nums));
    }

    @Test
    public void testCycleExistsNegativeLoop() {
        int[] nums = {-1, -2, -3, -4, -5};
        assertFalse(CircularArrayLoop.circularArrayLoop(nums));
    }

    @Test
    public void testNoCycleDueToDirectionChange() {
        int[] nums = {-2, 1, -1, -2, -2};
        assertFalse(CircularArrayLoop.circularArrayLoop(nums));
    }

    @Test
    public void testNoCycleSingleLengthCycle() {
        int[] nums = {1, 1, 1, 1, -4};
        assertFalse(CircularArrayLoop.circularArrayLoop(nums));
    }

    @Test
    public void testCycleWithWrapAround() {
        int[] nums = {1, 2, 3, 4, 5, 6, -2, 1};
        assertTrue(CircularArrayLoop.circularArrayLoop(nums));
    }

    @Test
    public void testSingleElementArray() {
        int[] nums = {1};
        assertFalse(CircularArrayLoop.circularArrayLoop(nums));
    }

    @Test
    public void testZeroShouldNotBePresent() {
        int[] nums = {3, 0, 2};
        assertFalse(CircularArrayLoop.circularArrayLoop(nums)); // input is invalid, as per constraints, all nums[i] ≠ 0
    }

    @Test
    public void testCycleExistsComplexPattern() {
        int[] nums = {1, 2, -3, 3, 4, 7, 1};
        assertTrue(CircularArrayLoop.circularArrayLoop(nums));
    }
}
