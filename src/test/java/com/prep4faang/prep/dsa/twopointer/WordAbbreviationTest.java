package com.prep4faang.prep.dsa.twopointer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WordAbbreviationTest {

    private WordAbbreviation wordAbbreviation;

    @BeforeEach
    void setUp(){
        wordAbbreviation = new WordAbbreviation();
    }
    @Test
    void testValidAbbreviations() {
        assertTrue(wordAbbreviation.validWordAbbreviation("calendar", "cal3ar"));
        assertTrue(wordAbbreviation.validWordAbbreviation("calendar", "c6r"));
        assertTrue(wordAbbreviation.validWordAbbreviation("internationalization", "i18n"));
        assertTrue(wordAbbreviation.validWordAbbreviation("word", "w2d"));
        assertTrue(wordAbbreviation.validWordAbbreviation("apple", "a4"));
    }

    @Test
    void testInvalidAbbreviations() {
        assertFalse(wordAbbreviation.validWordAbbreviation("calendar", "c06r"));       // leading zero
        assertFalse(wordAbbreviation.validWordAbbreviation("calendar", "cale0ndar"));  // zero replaces nothing
        assertFalse(wordAbbreviation.validWordAbbreviation("calendar", "c24r"));       // too long
        assertFalse(wordAbbreviation.validWordAbbreviation("apple", "a5"));            // skips too much
        assertFalse(wordAbbreviation.validWordAbbreviation("apple", "ap3le"));         // invalid skip
        assertFalse(wordAbbreviation.validWordAbbreviation("apple", "applee"));        // too many characters
    }

    @Test
    void testEdgeCases() {
        assertTrue(wordAbbreviation.validWordAbbreviation("a", "1"));                  // valid skip of one character
        assertFalse(wordAbbreviation.validWordAbbreviation("a", "2"));                 // skip beyond length
        assertFalse(wordAbbreviation.validWordAbbreviation("a", "01"));                // leading zero
        assertTrue(wordAbbreviation.validWordAbbreviation("ab", "a1"));                // skip last character
        assertFalse(wordAbbreviation.validWordAbbreviation("ab", "1a"));               // order mismatch
    }
}
