/*
Source : https://leetcode.com/problems/minimum-size-subarray-sum/
Author : Jiayi Lei
Date   : Jun 4, 2015

Description:
    Given an array of n positive integers and a positive integer s, find the 
    minimal length of a subarray of which the sum ≥ s. If there isn't one, 
    return 0 instead.
    For example, given the array [2,3,1,2,4,3] and s = 7, 
    the subarray [4,3] has the minimal length under the problem constraint.
More practice:
    If you have figured out the O(n) solution, try coding another solution of 
    which the time complexity is O(n log n).
Credits:
    Special thanks to @Freezen for adding this problem and creating all test 
    cases.
Tags: Array, Two Pointers, Binary Search
*/

// O(n) version
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length, start = 0, end = 0;
        int sum = 0, minLen = len + 1;
        while(end < len){
            sum += nums[end++];
            while(sum >= s){
                minLen = (end - start < minLen) ? (end - start) : (minLen);
                sum -= nums[start++];
            }
        }
        return (minLen == len + 1) ? (0) : (minLen);
    }
}

// need to construct the O(n log n) version
