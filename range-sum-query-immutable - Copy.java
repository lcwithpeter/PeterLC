/*
Source : https://leetcode.com/problems/range-sum-query-immutable/
Author : Jiayi Lei
Date   : Nov 12, 2015

Description:
	Given an integer array nums, find the sum of the elements between indices i 
	and j (i ≤ j), inclusive.

Example:
	Given nums = [-2, 0, 3, -5, 2, -1]

	sumRange(0, 2) -> 1
	sumRange(2, 5) -> -1
	sumRange(0, 5) -> -3
Note:
	You may assume that the array does not change.
	There are many calls to sumRange function.
*/

// version 1
// 3 ms
public class NumArray {    
    int[] dp;    
    public NumArray(int[] nums) {
        dp = new int[nums.length];
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            dp[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        if(dp.length == 0) return 0;
        int ret = dp[j];
        if(i - 1 >= 0) ret -= dp[i-1];
        
        return ret;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);


// version 2
// 3 ms
// more concise
public class NumArray {
    private int[] dp;
    public NumArray(int[] nums) {
        dp = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            dp[i+1] = dp[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return dp[j+1] - dp[i];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
