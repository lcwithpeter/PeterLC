/*
Source : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
Author : Jiayi Lei
Date   : Jun 2, 2015

Description:
    Suppose a sorted array is rotated at some pivot unknown to you beforehand.
    (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
    Find the minimum element.
    You may assume no duplicate exists in the array.
Tags: Array, Binary Search
*/

// version 1
public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        if(len == 1) return nums[0];
        if(nums[0] < nums[len - 1]) return nums[0];
        for(int i = 0; i < len - 1; i++){
            if(nums[i] > nums[i + 1]) return nums[i + 1];
        }
        return 0;
    }
}

// version 2: two pointers, binary search
public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        if(len == 1) return nums[0];
        if(nums[0] < nums[len - 1]) return nums[0];
        
        int start = 0;
        int end = len - 1;
        int mid;
        int sm = nums[end];
        while(true){
            mid = start + (end - start) / 2;
            if(nums[mid] > sm && mid < end) start = mid + 1;
            else if(nums[mid] < sm && mid > start){
                end = mid - 1;
                sm = nums[mid];
            }
            else if(nums[mid] <= sm) return nums[mid];
            else{
                return nums[mid + 1];
            }
        }
    }
}

// version 3
public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int len = nums.length;
        if(len == 1) return nums[0];
        
        int start = 0;
        int end = len - 1;
        if(nums[start] < nums[end]) return nums[start];
        
        int min = nums[end];
        int mid;
        while(start < end - 1){
            mid = start + (end - start) / 2;
            if(nums[mid] < min){
                end = mid - 1;
                min = nums[mid];
            }
            else if(nums[mid] > min){
                start = mid + 1;
            }
        }
        return Math.min(min, Math.min(nums[start], nums[end]));
    }
}