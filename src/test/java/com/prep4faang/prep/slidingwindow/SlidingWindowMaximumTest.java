package com.prep4faang.prep.slidingwindow;

import com.prep4faang.prep.dsa.slidingwindow.SlidingWindowMaximum;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SlidingWindowMaximumTest {

    @Test
    public void testBasicCase() {
        int[] nums = {-4, 2, -5, 3, 6};
        int w = 3;
        int[] expected = {2, 3, 6};
        assertArrayEquals(expected, SlidingWindowMaximum.findMaxInSlidingWindow(nums, w));
    }

    @Test
    public void testAllPositive() {
        int[] nums = {1, 3, 5, 7, 9};
        int w = 2;
        int[] expected = {3, 5, 7, 9};
        assertArrayEquals(expected, SlidingWindowMaximum.findMaxInSlidingWindow(nums, w));
    }

    @Test
    public void testAllNegative() {
        int[] nums = {-8, -6, -4, -2};
        int w = 2;
        int[] expected = {-6, -4, -2};
        assertArrayEquals(expected, SlidingWindowMaximum.findMaxInSlidingWindow(nums, w));
    }

    @Test
    public void testWindowSizeOne() {
        int[] nums = {1, 2, 3, 4};
        int w = 1;
        int[] expected = {1, 2, 3, 4};
        assertArrayEquals(expected, SlidingWindowMaximum.findMaxInSlidingWindow(nums, w));
    }

    @Test
    public void testWindowEqualsArrayLength() {
        int[] nums = {4, 2, 12, 3};
        int w = 4;
        int[] expected = {12};
        assertArrayEquals(expected, SlidingWindowMaximum.findMaxInSlidingWindow(nums, w));
    }

    @Test
    public void testAllSameElements() {
        int[] nums = {5, 5, 5, 5};
        int w = 2;
        int[] expected = {5, 5, 5};
        assertArrayEquals(expected, SlidingWindowMaximum.findMaxInSlidingWindow(nums, w));
    }

    @Test
    public void testSingleElementArray() {
        int[] nums = {10};
        int w = 1;
        int[] expected = {10};
        assertArrayEquals(expected, SlidingWindowMaximum.findMaxInSlidingWindow(nums, w));
    }

    @Test
    public void testEmptyArray() {
        int[] nums = {};
        int w = 1;
        int[] expected = {};
        assertArrayEquals(expected, SlidingWindowMaximum.findMaxInSlidingWindow(nums, w));
    }

    @Test
    public void testWindowSizeLargerThanArray() {
        int[] nums = {1, 2};
        int w = 3;
        int[] expected = {}; // window can't fit
        assertArrayEquals(expected, SlidingWindowMaximum.findMaxInSlidingWindow(nums, w));
    }
}
