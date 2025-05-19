package com.prep4faang.prep.slidingwindow;

import com.prep4faang.prep.dsa.slidingwindow.RepeatedDNASequences;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class RepeatedDNASequencesTest {

    @Test
    public void testExampleCase() {
        String input = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> expected = Arrays.asList("AAAAACCCCC", "CCCCCAAAAA");
        List<String> actual = RepeatedDNASequences.findRepeatedDnaSequences(input);

        // Convert both to sets to ignore order and duplicates
        assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    }

    @Test
    public void testNoRepeat() {
        String input = "ACGTACGTAC";
        List<String> expected = List.of();
        List<String> actual = RepeatedDNASequences.findRepeatedDnaSequences(input);

        assertEquals(expected, actual);
    }

    @Test
    public void testAllSameCharacter() {
        String input = "AAAAAAAAAAAAA";
        List<String> expected = List.of("AAAAAAAAAA");
        List<String> actual = RepeatedDNASequences.findRepeatedDnaSequences(input);

        assertEquals(expected, actual);
    }

    @Test
    public void testShortInput() {
        String input = "ACGTAC";
        List<String> expected = List.of();
        List<String> actual = RepeatedDNASequences.findRepeatedDnaSequences(input);

        assertEquals(expected, actual);
    }

    @Test
    public void testExact10NoRepeat() {
        String input = "ACGTACGTAC";
        List<String> expected = List.of();
        List<String> actual = RepeatedDNASequences.findRepeatedDnaSequences(input);

        assertEquals(expected, actual);
    }
}
