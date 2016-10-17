/*
Source : https://leetcode.com/problems/missing-number/
Author : Jiayi Lei
Date   : Aug 31, 2015

Description:
    Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
	find the one that is missing from the array.

For example,
	Given nums = [0, 1, 3] return 2.

Note:
	Your algorithm should run in linear runtime complexity. Could you implement 
	it using only constant extra space complexity?

Credits:
	Special thanks to @jianchao.li.fighter for adding this problem and creating 
	all test cases.
	
Tags: Array; Math; Bit Manipulation

Similiar Problems:
	https://leetcode.com/problems/first-missing-positive/
	https://leetcode.com/problems/single-number/
*/

public class Solution {
    public int missingNumber(int[] nums) {
        if(nums.length > 0){
            double n = (double) nums.length;
            int sum = (int) (n * (n / 2 + 0.5));
            for(int x : nums) sum -= x;
            return sum;
        }
        return 0;
    }
}
