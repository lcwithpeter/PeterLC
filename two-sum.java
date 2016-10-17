/*
Source : https://leetcode.com/problems/two-sum/
Author : Jiayi Lei
Date   : May 28, 2015
Description:
    Given an array of integers, find two numbers such that they add up to a 
    specific target number.
    The function twoSum should return indices of the two numbers such that they
    add up to the target, where index1 must be less than index2. Please note 
    that your returned answers (both index1 and index2) are not zero-based.
    
    You may assume that each input would have exactly one solution.

    Input: numbers={2, 7, 11, 15}, target=9
    Output: index1=1, index2=2
UPDATE (2016/2/13):
	The return format had been changed to zero-based indices. Please read the 
	above updated description carefully.
	
Note:
	HashMap
*/

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        
        int[] ret = new int[2];
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                int index = map.get(target - nums[i]);
                if(index != i){
                    ret[0] = Math.min(i, index);
                    ret[1] = Math.max(i, index);
                }
            }
        }
        return ret;
    }
}
