package com.leetcode.problems;

public class PalindromeNumber {

    public static void main(String[] args) {
        PalindromeNumber number = new PalindromeNumber();
        number.isPalindrome(121);
    }

    /**
     * An integer is a palindrome when it reads the same backward as forward.
     * For example, 121 is a palindrome while 123 is not.
     * -2^31 <= x <= 2^31 - 1
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {

        boolean flag;

        if (x >= 0) {
            int original = x;
            int reverse = 0;
            while(x!=0){
                reverse = reverse * 10 + x % 10;
                x /= 10;
            }
         //   System.out.println(reverse);

            if (reverse == original) {
                flag = true;
            } else {
                flag = false;
            }

        } else {
            flag = false;
        }

        return flag;
    }
}
