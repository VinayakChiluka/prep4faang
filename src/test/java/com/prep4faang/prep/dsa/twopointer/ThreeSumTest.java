package com.prep4faang.prep.dsa.twopointer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ThreeSumTest {

    private  ThreeSum threeSum;

    @BeforeEach
    public void setUp(){
        threeSum = new ThreeSum();
    }
    @Test
    public void testBasicCase() {
        int[] input = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(-1, -1, 2),
                Arrays.asList(-1, 0, 1)
        );
        List<List<Integer>> actual = threeSum.solve(input);
        assertTrue(listsAreEqualIgnoringOrder(expected, actual));
    }

    @Test
    public void testNoValidTriplets() {
        int[] input = {1, 2, 3, 4, 5};
        List<List<Integer>> expected = Collections.emptyList();
        List<List<Integer>> actual = threeSum.solve(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testAllZeros() {
        int[] input = {0, 0, 0, 0};
        List<List<Integer>> expected = Collections.singletonList(
                Arrays.asList(0, 0, 0)
        );
        List<List<Integer>> actual = threeSum.solve(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testMixedWithDuplicates() {
        int[] input = {-4, -1, -1, 0, 1, 2, 2};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(-1, -1, 2),
                Arrays.asList(-1, 0, 1),
                Arrays.asList(-4, 2, 2)

        );
        List<List<Integer>> actual = threeSum.solve(input);

        assertTrue(listsAreEqualIgnoringOrder(expected, actual));
    }

    @Test
    public void testLargeRange() {
        int[] input = {-10, -7, -3, -1, 0, 3, 7, 10};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(-10, 0, 10),
                Arrays.asList(-10, 3, 7),
                Arrays.asList(-7, -3, 10),
                Arrays.asList(-7, 0, 7),
                Arrays.asList(-3, 0, 3)
        );
        List<List<Integer>> actual = threeSum.solve(input);
        System.out.println(actual);
        System.out.println(expected);
        assertTrue(listsAreEqualIgnoringOrder(expected, actual));
    }

    @Test
    public void testAllNegative() {
        int[] input = {-3, -5, -7, -9};
        List<List<Integer>> expected = Collections.emptyList();
        List<List<Integer>> actual = threeSum.solve(input);
        assertEquals(expected, actual);
    }

    // Helper to compare two list-of-lists ignoring order
    private boolean listsAreEqualIgnoringOrder(List<List<Integer>> expected, List<List<Integer>> actual) {
        Set<Set<Integer>> set1 = new HashSet<>();
        for (List<Integer> list : expected) {
            set1.add(new HashSet<>(list));
        }

        Set<Set<Integer>> set2 = new HashSet<>();
        for (List<Integer> list : actual) {
            set2.add(new HashSet<>(list));
        }

        return set1.equals(set2);
    }
}
