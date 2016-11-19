/*
Source : https://leetcode.com/problems/longest-increasing-subsequence/
Author : Jiayi Lei
Date   : Feb 3, 2016

Description:
    Given an unsorted array of integers, find the length of longest increasing 
	subsequence.

For example,
	Given [10, 9, 2, 5, 3, 7, 101, 18],
	The longest increasing subsequence is [2, 3, 7, 101], therefore the length 
	is 4. Note that there may be more than one LIS combination, it is only 
	necessary for you to return the length.

	Your algorithm should run in O(n2) complexity.

Follow up:
	Could you improve it to O(n log n) time complexity?

Credits:
	Special thanks to @pbrother for adding this problem and creating all test 
	cases.
	
Tag:
	Stack;
*/

// O(n^2)
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0 || nums.length == 1)
            return nums.length;
        
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLength = 0;
        
        for(int i = 1; i < dp.length; i++){
            int max = 0;
            for(int j = i - 1; j >= 0; j--){
                if(nums[j] < nums[i]){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = Math.max(1, max + 1);
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}

// O(nlogn)
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int size = 0;
        for(int target: nums){
            int start = 0, end = size;
            while(start < end){
                int mid = start + (end - start) / 2;
                if(dp[mid] < target) start = mid + 1;
                else end = mid;
            }
            dp[start] = target;
            if(start == size) size++;
        }
        return size;
    }
}
