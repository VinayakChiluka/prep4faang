package com.prep4faang.prep.dsa.slidingwindow;

import java.util.*;

/**
 * Problem: Repeated DNA Sequences
 *
 * A DNA sequence consists of nucleotides represented by the letters 'A', 'C', 'G', and 'T' only.
 * For example, "ACGAATTCCG" is a valid DNA sequence.
 *
 * Given a string s that represents a DNA sequence, return all the 10-letter-long sequences
 * (continuous substrings of exactly 10 characters) that appear more than once in s.
 *
 * You can return the output in any order.
 *
 * Constraints:
 * - 1 <= s.length <= 10^3
 * - s[i] is either 'A', 'C', 'G', or 'T'.
 */
public class RepeatedDNASequences {

    /**
     * Finds all 10-letter-long DNA sequences that appear more than once in the given string.
     *
     * @param s The DNA sequence string.
     * @return A list of all repeated 10-letter substrings.
     */
    public static List<String> findRepeatedDnaSequences(String s) {
        Map<Character, Integer> charMap = new HashMap<>(){{
            put('A', 0);
            put('C', 1);
            put('G', 2);
            put('T', 3);
        }};

        ArrayList<Integer> encode = new ArrayList<>();
        for (char c : s.toCharArray()) {
            encode.add(charMap.get(c));
        }

        int n = s.length();
        int k = 10;
        int a = 4;
        int a_k = 1;
        if(n <= k) return new ArrayList<>();

        int h = 0;

        for(int i=0;i<k;i++){
           h = (h * a) + encode.get(i);
           a_k = a_k * a;
        }

        HashSet<Integer> seen = new HashSet<>();
        HashSet<String> output = new HashSet<>();
        seen.add(h);
        for(int start = 1; start <= n - k ; start++){
            h = (h * a) - (a_k * encode.get(start-1)) + (encode.get(k+start-1));
            if(seen.contains(h)){
                output.add(s.substring(start, k+start));
            }
            else{
                seen.add(h);
            }
        }


        return new ArrayList<>(output);
    }

    // Example test
    public static void main(String[] args) {
        String input = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> result = findRepeatedDnaSequences(input);
        System.out.println("Repeated Sequences: " + result);
    }
}
