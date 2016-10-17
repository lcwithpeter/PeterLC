/*
Source : https://leetcode.com/problems/power-of-two/
Author : Jiayi Lei
Date   : Sep 22, 2015

Description:
    Given an integer, write a function to determine if it is a power of two.

Credits:
	Special thanks to @jianchao.li.fighter for adding this problem and creating 
	all test cases.
	
Tags: Math, Bit Manipulation

Similar Problems:
	https://leetcode.com/problems/number-of-1-bits/
*/

public class Solution {
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && (n & (n - 1)) == 0;
    }
}
