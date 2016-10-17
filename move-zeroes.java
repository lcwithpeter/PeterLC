/*
Source : https://leetcode.com/problems/move-zeroes/
Author : Jiayi Lei
Date   : Sep 21, 2015
Description:
    Given an array nums, write a function to move all 0's to the end of it while
	maintaining the relative order of the non-zero elements.

For example:
	given nums = [0, 1, 0, 3, 12], after calling your function, nums should be 
	[1, 3, 12, 0, 0].

Note:
	You must do this in-place without making a copy of the array.
	Minimize the total number of operations.

Credits:
	Special thanks to @jianchao.li.fighter for adding this problem and creating 
	all test cases.
	
Tags: Array; Two Pointers

Similar Problems:
	https://leetcode.com/problems/remove-element/
*/

public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length > 0){
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == 0){
                    int next = findNextNonZero(nums, i);
                    if(next > 0){
                        swap(nums, i, next);
                    }else{
                        break;
                    }
                }
            }
        }
    }
    private int findNextNonZero(int[] nums, int cur){
        for(int i = cur + 1; i < nums.length; i++){
            if(nums[i] != 0) return i;
        }
        return -1;
    }    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
