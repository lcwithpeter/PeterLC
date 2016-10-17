/*
Source : https://leetcode.com/problems/single-number-ii/
Author : Jiayi Lei
Date   : Jul 5, 2015

Description:
    Given an array of integers, every element appears three times except for 
    one. Find that single one.

Note:
    Your algorithm should have a linear runtime complexity. Could you implement
    it without using extra memory?
    
Tags: Bit Manipulation
*/

public class Solution {
    public int singleNumber(int[] nums) {
        int k = 3; // every element appears k times
        int s = 1; // except one appears s times
        int t;
        int[] x = new int[k];
        x[0] = ~0;
        for(int i : nums){
            t = x[k - 1];
            for(int j = k - 1; j > 0; j--){
                x[j] = (x[j - 1] & i) | (x[j] & ~i);
            }
            x[0] = (t & i) | (x[0] & ~i);
        }
        return x[s];
    }
}
