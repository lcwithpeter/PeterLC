/*
Source : https://leetcode.com/problems/3sum-closest/
Author : Jiayi Lei
Date   : Jun 2, 2015
Description:
    Given an array S of n integers, find three integers in S such that the sum 
    is closest to a given number, target. Return the sum of the three integers. 
    You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.
    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) return 0;
        int len = nums.length;
        if(len == 3) return nums[0] + nums[1] + nums[2];
        
        Arrays.sort(nums);
        
        int result = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < len; i++){
        	int j = i + 1;
        	int k = len - 1;
        	while(j < k){
        		int sum = nums[i] + nums[j] + nums[k];
        		if(sum == target) return sum;        		
        		if(Math.abs(sum - target) < Math.abs(result - target)) result = sum;        		
        		if(sum < target) j++;
        		else if(sum > target) k--;        		
        	}
        }
        return result;
    }
}
