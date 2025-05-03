package com.prep4faang.prep.dsa.twopointer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReverseWordsTest {

    ReverseWords rw = new ReverseWords();

    @Test
    public void testBasicCase() {
        String input = "the sky is blue";
        String expected = "blue is sky the";
        assertEquals(expected, rw.reverseWords(input));
    }

    @Test
    public void testWithExtraSpaces() {
        String input = "  hello   world!  ";
        String expected = "world! hello";
        assertEquals(expected, rw.reverseWords(input));
    }

    @Test
    public void testSingleWord() {
        String input = "hello";
        String expected = "hello";
        assertEquals(expected, rw.reverseWords(input));
    }

    @Test
    public void testWithMultipleSpaces() {
        String input = "a good   example";
        String expected = "example good a";
        assertEquals(expected, rw.reverseWords(input));
    }

    @Test
    public void testEmptyString() {
        String input = "   ";
        String expected = "";
        assertEquals(expected, rw.reverseWords(input));
    }

    @Test
    public void testSpecialCharacters() {
        String input = "code@ GPT is# cool";
        String expected = "cool is# GPT code@";
        assertEquals(expected, rw.reverseWords(input));
    }

    @Test
    public void testWithDigits() {
        String input = "123 test 456";
        String expected = "456 test 123";
        assertEquals(expected, rw.reverseWords(input));
    }
}
