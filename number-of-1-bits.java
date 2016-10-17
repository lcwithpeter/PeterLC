/*
Source : https://leetcode.com/problems/number-of-1-bits/
Author : Jiayi Lei
Date   : Jul 5, 2015

Description:
    Write a function that takes an unsigned integer and returns the number of 
    ’1' bits it has (also known as the Hamming weight).
    For example, the 32-bit integer ’11' has binary representation 
    00000000000000000000000000001011, so the function should return 3.

Credits:
    Special thanks to @ts for adding this problem and creating all test cases.
    
Tags: Bit Manipulation
*/

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
