package com.prep4faang.prep.dsa.twopointer;

/**
 * Problem: Reverse Words in a String
 *
 * Given a sentence, reverse the order of its words without affecting the characters within each word.
 *
 * A word is defined as a sequence of non-space characters. The input string may contain leading,
 * trailing, or multiple spaces between words, but these should be handled cleanly (trimmed and
 * single spaced) in the output.
 *
 * Constraints:
 * - The sentence contains English uppercase and lowercase letters, digits, and spaces.
 * - 1 ≤ sentence.length ≤ 10^4
 * - The order of the letters within each word should **not** be reversed.
 *
 * Example 1:
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 *
 * Example 2:
 * Input: "  hello   world!  "
 * Output: "world! hello"
 *
 * Example 3:
 * Input: "a good   example"
 * Output: "example good a"
 *
 * You may assume the input string does not contain any non-printable characters.
 */
public class ReverseWords {
    public String reverseWords(String sentence) {
        String[] words = sentence.trim().split("\\s+");
        int start = 0;
        int end = words.length-1;
        while(start < end){
            swap(words,start,end);
            start++;
            end--;
        }

        return String.join(" ", words);
    }
    private void swap(String[] words, int i, int j){
        String temp = words[i];
        words[i] = words[j];
        words[j] = temp;
    }
}
