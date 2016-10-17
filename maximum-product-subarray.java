/*
Source : https://leetcode.com/problems/maximum-product-subarray/
Author : Jiayi Lei
Date   : Jul 18, 2015

Description:
    Find the contiguous subarray within an array (containing at least one 
    number) which has the largest product.

    For example, given the array [2,3,-2,4],
    the contiguous subarray [2,3] has the largest product = 6.
    
Tags: Dynamic Programming; Array
*/

// solution 1
public class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;        
        
        int maxPdct = nums[0];
        int minPdct = nums[0];
        int max = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] >= 0){
            	maxPdct = Math.max(nums[i] * maxPdct, nums[i]);
            	minPdct = Math.min(nums[i] * minPdct, nums[i]);
            }else{
            	int temp = maxPdct;
            	maxPdct = Math.max(nums[i] * minPdct, nums[i]);
            	minPdct = Math.min(nums[i] * temp, nums[i]);
            }
            max = Math.max(max, maxPdct);
        }
        return max;
    }
}

// solution 2
public class Solution {
    int max = 0, min = 0;
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;        
        
        int result = nums[0];
        max = result;
        min = result;
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < 0) swap();
            
            max = Math.max(nums[i], nums[i] * max);
            min = Math.min(nums[i], nums[i] * min);
            
            result = Math.max(result, max);
        }
        return result;
    }
    private void swap(){
        int temp = max;
        max = min;
        min = temp;
    }
}
