package com.prep4faang.prep.dsa.fastandslow;

/**
 * Problem Statement: Happy Number
 *
 * Write a program to determine whether a given positive integer `n` is a "happy number".
 *
 * A happy number is defined by the following process:
 * - Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * - Repeat the process until:
 *    - The number equals 1 (where it will stay), which means it is a happy number.
 *    - The process loops endlessly in a cycle that does not include 1, which means it is not a happy number.
 *
 * Your task is to implement a function that returns true if `n` is a happy number, and false otherwise.
 *
 * Constraints:
 * - The input number `n` is a positive integer: 1 <= n <= 2^31 - 1
 *
 * Example 1:
 * Input: n = 19
 * Output: true
 *
 * Example 2:
 * Input: n = 2
 * Output: false
 *
 * Method Signature:
 * public boolean isHappy(int n)
 */

public class HappyNumber {

    /**
     * Determines if the given number is a happy number.
     *
     * @param n the number to check
     * @return true if n is a happy number, false otherwise
     */
    public boolean isHappy(int n) {
        int slow = n;
        int fast = sumOfDigits(n);
        while(fast != 1 && slow != fast){
            slow = sumOfDigits(slow);
            fast = sumOfDigits(sumOfDigits(fast));
        }
        return fast == 1;
    }

    private int sumOfDigits(int n){
        int sum = 0;
        while(n > 0){
            int digit = n%10;
            sum = sum + (digit * digit);
            n = n/10;
        }
        return sum;
    }

    public static void main(String[] args) {
        HappyNumber hn = new HappyNumber();

        // Sample test cases
        System.out.println("Is 19 a happy number? " + hn.isHappy(19)); // Expected: true
        System.out.println("Is 2 a happy number? " + hn.isHappy(2));   // Expected: false
    }
}
