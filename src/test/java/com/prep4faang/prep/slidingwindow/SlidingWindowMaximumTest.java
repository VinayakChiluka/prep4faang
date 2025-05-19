package com.prep4faang.prep.slidingwindow;

import com.prep4faang.prep.dsa.slidingwindow.SlidingWindowMaximum;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SlidingWindowMaximumTest {

    @Test
    void testExampleCase() {
        int[] nums = {-4, 2, -5, 3, 6};
        int w = 3;
        int[] expected = {2, 3, 6};
        assertArrayEquals(expected, SlidingWindowMaximum.findMaxSlidingWindow(nums, w));
    }

    @Test
    void testWindowSizeOne() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int w = 1;
        int[] expected = {1, 3, -1, -3, 5, 3, 6, 7};
        assertArrayEquals(expected, SlidingWindowMaximum.findMaxSlidingWindow(nums, w));
    }

    @Test
    void testWindowSizeEqualsArrayLength() {
        int[] nums = {2, 1, 3};
        int w = 3;
        int[] expected = {3};
        assertArrayEquals(expected, SlidingWindowMaximum.findMaxSlidingWindow(nums, w));
    }

    @Test
    void testWindowSizeTooLarge() {
        int[] nums = {1, 2};
        int w = 3;
        int[] expected = {};
        assertArrayEquals(expected, SlidingWindowMaximum.findMaxSlidingWindow(nums, w));
    }

    @Test
    void testAllNegativeNumbers() {
        int[] nums = {-10, -20, -30, -5, -1};
        int w = 2;
        int[] expected = {-10, -20, -5, -1};
        assertArrayEquals(expected, SlidingWindowMaximum.findMaxSlidingWindow(nums, w));
    }

    @Test
    void testAllSameNumbers() {
        int[] nums = {5, 5, 5, 5};
        int w = 2;
        int[] expected = {5, 5, 5};
        assertArrayEquals(expected, SlidingWindowMaximum.findMaxSlidingWindow(nums, w));
    }
}
