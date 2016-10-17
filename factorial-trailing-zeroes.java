/*
Source : https://leetcode.com/problems/factorial-trailing-zeroes/
Author : Jiayi Lei
Date   : Sep 24, 2015

Description:
    Given an integer n, return the number of trailing zeroes in n!.

Note: 
	Your solution should be in logarithmic time complexity.

Credits:
	Special thanks to @ts for adding this problem and creating all test cases.
	
Tags:
	Math

Similar Problems:
	https://leetcode.com/problems/number-of-digit-one/
*/

public class Solution {
    public int trailingZeroes(int n) {
        int sum = 0;
        while(n >= 5){
            n /= 5;
            sum += n;
        }
        return sum;
    }
}
