/*
Source : https://leetcode.com/problems/search-for-a-range/
Author : Jiayi Lei
Date   : Jun 3, 2015

Description:
    Given a sorted array of integers, find the starting and ending position of 
    a given target value.
    Your algorithm's runtime complexity must be in the order of O(log n).
    If the target is not found in the array, return [-1, -1].
For example,
    Given [5, 7, 7, 8, 8, 10] and target value 8,
    return [3, 4].
Tags:
    Array; Binary Search
*/

// version 1: O(n)
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            int ret[] = {-1, -1};
            return ret;
        }
        int len = nums.length;
        int start = -1, end = -1;
        for(int i = 0; i < len; i++){
            if(nums[i] == target){
                if(start == -1){
                    start = i;
                    end = i;
                }
                else end = i;
            }
        }
        int ret[] = {start, end};
        return ret;
    }
}

// version 2: O(log n)
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            int ret[] = {-1, -1};
            return ret;
        }
        int len = nums.length;
        int start = -1, end = -1;
        int flag = binSearch(nums, 0, len - 1, target);
        if(flag != -1){
            start = searchFromRight(nums, 0, flag, target) + 1;
            end = searchFromLeft(nums, flag, len - 1, target) - 1;
        }
        int ret[] = {start, end};
        return ret;
    }
    
    public int searchFromRight(int[] n, int start, int end, int t){
        int mid;
        while(true){
            mid = start + (end - start) / 2;
            if(n[mid] == t && mid > start) end = mid - 1;
            else if(n[mid] != t && mid < end) start = mid + 1;
            else{
                if(n[mid] != t) return mid;
                return mid - 1;
            }
        }
    }
    
    public int searchFromLeft(int[] n, int start, int end, int t){
        int mid;
        while(true){
            mid = start + (end - start) / 2;
            if(n[mid] == t && mid < end) start = mid + 1;
            else if(n[mid] != t && mid > start) end = mid - 1;
            else{
                if(n[mid] != t) return mid;
                return mid + 1;
            }
        }
    }
    
    public int binSearch(int[] n, int start, int end, int t){
        int mid;
        while(true){
            mid = start + (end - start) / 2;
            if(n[mid] == t) return mid;
            else if(n[mid] > t && mid > start) end = mid - 1;
            else if(n[mid] < t && mid < end) start = mid + 1;
            else return -1;
        }
    }
}
