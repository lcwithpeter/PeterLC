/*
Source : https://leetcode.com/problems/house-robber/
Author : Jiayi Lei
Date   : Jul 9, 2015

Description:
    You are a professional robber planning to rob houses along a street. Each 
    house has a certain amount of money stashed, the only constraint stopping 
    you from robbing each of them is that adjacent houses have security system 
    connected and it will automatically contact the police if two adjacent 
    houses were broken into on the same night.

    Given a list of non-negative integers representing the amount of money of 
    each house, determine the maximum amount of money you can rob tonight 
    without alerting the police.

Credits:
    Special thanks to @ifanchu for adding this problem and creating all test 
    cases. Also thanks to @ts for adding additional test cases.
    
Tags: Dynamic Programming
*/

// version 1
public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] val = new int[nums.length];
        val[0] = nums[0];
        val[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
        	val[i] = Math.max(nums[i] + val[i - 2], val[i - 1]);
        }
        return val[nums.length - 1];
    }
}

// version 2
public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] value = new int[nums.length];
        value[0] = nums[0];
        value[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            value[i] = Math.max(value[i - 1], nums[i] + value[i- 2]);
        }
        return value[nums.length - 1];
    }
}
