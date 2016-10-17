/*
Source : https://leetcode.com/problems/remove-duplicates-from-sorted-array/
Author : Jiayi Lei
Date   : May 30, 2015
Description:
    Given a sorted array, remove the duplicates in place such that each element
    appear only once and return the new length.
    Do not allocate extra space for another array, you must do this in place 
    with constant memory.
    
    For example,
    Given input array nums = [1,1,2],
    Your function should return length = 2, with the first two elements of nums
    being 1 and 2 respectively. It doesn't matter what you leave beyond the new
    length.
*/

// version 1
public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len > 1){
            int i = 0;
            int j = 1;
            while(j < len){
                if(nums[i] == nums[j]){
                    j++;
                    continue;
                }
                i++;
                if(i != j) nums[i] = nums[j];
                j++;
            }
            return i + 1;
        }
        else return len;
    }
}

// version 2
public class Solution {
    public int removeDuplicates(int[] nums) {
        int curIndex = 0;
        for(int x : nums){
            if(curIndex == 0 || x > nums[curIndex - 1])
                nums[curIndex++] = x;
        }
        return curIndex;
    }
}
