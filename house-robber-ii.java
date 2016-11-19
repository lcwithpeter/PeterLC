/*
Source : https://leetcode.com/problems/house-robber-ii/
Author : Jiayi Lei
Date   : Jul 15, 2015

Description:
Note: This is an extension of House Robber.
    After robbing those houses on that street, the thief has found himself a 
    new place for his thievery so that he will not get too much attention. This
    time, all houses at this place are arranged in a circle. That means the 
    first house is the neighbor of the last one. Meanwhile, the security system
    for these houses remain the same as for those in the previous street.
    Given a list of non-negative integers representing the amount of money of 
    each house, determine the maximum amount of money you can rob tonight 
    without alerting the police.

Credits:
    Special thanks to @Freezen for adding this problem and creating all test 
    cases.
    
Tags: Dynamic Programming
*/

// version 1
public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        if(nums.length == 3) return Math.max(nums[0], Math.max(nums[1], nums[2]));
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }
    private int helper(int[] nums, int start, int end){
        int[] val = new int[end - start + 1];
        val[0] = nums[start];
        val[1] = Math.max(nums[start], nums[start + 1]);
        for(int i = start + 2, j = 2; i <= end; i++, j++){
            val[j] = Math.max(val[j - 1], nums[i] + val[j - 2]);
        }
        return val[end - start];
    }
}

// version 2
// more concise
public class Solution {
    private int[] houses;
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        houses = nums;
        return Math.max(helper(0, houses.length - 2),
                        helper(1, houses.length - 1));
    }
    private int helper(int start, int end){
        if(start == end) return houses[start];
        int[] dp = new int[(end - start + 1) + 2];
        for(int i = 2; i < dp.length && start <= end; i++, start++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + houses[start]);
        }
        return dp[dp.length - 1];
    }
}
