/*
Source : https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
Author : Jiayi Lei
Date   : Jun 3, 2015

Description:
    Suppose a sorted array is rotated at some pivot unknown to you beforehand.
    (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
    You are given a target value to search. If found in the array return its 
    index, otherwise return -1.
    
    Follow up for "Search in Rotated Sorted Array":
    What if duplicates are allowed?
    Would this affect the run-time complexity? How and why?
    Write a function to determine if a given target is in the array.

Tags: Array, Binary Search
*/

public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(nums[i] == target) return true;
        }
        return false;
    }
}
