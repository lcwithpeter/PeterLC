/*
Source : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
Author : Jiayi Lei
Date   : Jun 2, 2015

Description:
    Follow up for "Find Minimum in Rotated Sorted Array":
    What if duplicates are allowed?
    Would this affect the run-time complexity? How and why?    
    Suppose a sorted array is rotated at some pivot unknown to you beforehand.
    (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
    Find the minimum element.
    The array may contain duplicates.

Tags: Array, Binary Search
*/

public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        if(len == 1) return nums[0];
        int start = 0;
        int end = len - 1;
        if(nums[start] < nums[end]) return nums[0];
        if(nums[start] == nums[end]){
            for(int i = 0; i < len - 1; i++){
                if(nums[i] > nums[i + 1]) return nums[i + 1];
            }
            return nums[0];
        }
        int min = nums[end];
        int mid;
        while(start < end - 1){
            mid = start + (end - start) / 2;
            if(nums[mid] <= min){
                min = nums[mid];
                end = mid - 1;
            }
            else if(nums[mid] > min) start = mid + 1;
        }
        return Math.min(min, Math.min(nums[start], nums[end]));
    }
}
