/*
Source : https://leetcode.com/problems/search-in-rotated-sorted-array/
Author : Jiayi Lei
Date   : Jun 3, 2015

Description:
    Suppose a sorted array is rotated at some pivot unknown to you beforehand.
    (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
    You are given a target value to search. If found in the array return its 
    index, otherwise return -1.
    You may assume no duplicate exists in the array.

Tags: Array, Binary Search
*/

public class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int len = nums.length;
        if(len == 1){
            if(nums[0] == target) return 0;
            return -1;
        }
        int start = 0;
        int end = len - 1;
        int mid;
        while(true){
            if(nums[start] < nums[end]){
               while(true){
                    mid = start + (end - start) / 2;
                    if(target < nums[mid] && start < mid) end = mid - 1;
                    else if(target > nums[mid] && mid < end) start = mid + 1;
                    else if(nums[mid] == target) return mid;
                    else return -1;
                }
            }
            mid = start + (end - start) / 2;
            if(target == nums[start]) return start;
            else if(target == nums[mid]) return mid;
            else if(target == nums[end]) return end;
            else if(target < nums[mid] && target < nums[end] && nums[mid] < nums[end] && mid > start) end = mid - 1;
            else if(target > nums[mid] && target > nums[start] && nums[mid] < nums[start] && mid > start) end = mid - 1;
            else if(target > nums[mid] && target < nums[end] && mid < end) start = mid + 1;
            else if(target < nums[mid] && target > nums[start] && mid > start) end = mid - 1;
            else if(target > nums[mid] && target > nums[start] && mid < end) start = mid + 1;
            else if(target < nums[mid] && target < nums[end] && mid < end) start = mid + 1;
            else return -1;
        }
    }
}
