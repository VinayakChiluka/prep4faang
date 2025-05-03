package com.prep4faang.prep.dsa.twopointer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DutchNationalFlagSorterTest {
    private DutchNationalFlagSorter dutchNationalFlagSorter;

    @BeforeEach
    public void setup() {
        dutchNationalFlagSorter = new DutchNationalFlagSorter();
    }


    @Test
    public void testSortColors_AllZeros() {
        int[] input = {0, 0, 0};
        int[] expected = {0, 0, 0};
        assertArrayEquals(expected, dutchNationalFlagSorter.sortColors(input));
    }

    @Test
    public void testSortColors_AllOnes() {
        int[] input = {1, 1, 1};
        int[] expected = {1, 1, 1};
        assertArrayEquals(expected, dutchNationalFlagSorter.sortColors(input));
    }

    @Test
    public void testSortColors_AllTwos() {
        int[] input = {2, 2, 2};
        int[] expected = {2, 2, 2};
        assertArrayEquals(expected, dutchNationalFlagSorter.sortColors(input));
    }

    @Test
    public void testSortColors_MixedOrder() {
        int[] input = {2, 0, 2, 1, 1, 0};
        int[] expected = {0, 0, 1, 1, 2, 2};
        assertArrayEquals(expected, dutchNationalFlagSorter.sortColors(input));
    }

    @Test
    public void testSortColors_AlreadySorted() {
        int[] input = {0, 0, 1, 1, 2, 2};
        int[] expected = {0, 0, 1, 1, 2, 2};
        assertArrayEquals(expected, dutchNationalFlagSorter.sortColors(input));
    }

    @Test
    public void testSortColors_SingleElement() {
        int[] input = {1};
        int[] expected = {1};
        assertArrayEquals(expected, dutchNationalFlagSorter.sortColors(input));
    }

    @Test
    public void testSortColors_TwoElements() {
        int[] input = {2, 0};
        int[] expected = {0, 2};
        assertArrayEquals(expected, dutchNationalFlagSorter.sortColors(input));
    }

    @Test
    public void testSortColors_EmptyArray() {
        int[] input = {};
        int[] expected = {};
        assertArrayEquals(expected, dutchNationalFlagSorter.sortColors(input));
    }
}