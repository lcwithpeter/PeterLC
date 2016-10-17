/*
Source : https://leetcode.com/problems/search-insert-position/
Author : Jiayi Lei
Date   : Jun 2, 2015

Description:
    Given a sorted array and a target value, return the index if the target is 
    found. If not, return the index where it would be if it were inserted in 
    order.
    
    You may assume no duplicates in the array.

    Here are few examples.
    [1,3,5,6], 5 -> 2
    [1,3,5,6], 2 -> 1
    [1,3,5,6], 7 -> 4
    [1,3,5,6], 0 -> 0

Tags:
    Array; Binary Search
*/

// version 1
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int i = 0;
        for(i = 0; i < len; i++){
            if(target <= nums[i]) return i;
        }
        return i;
    }
}

// version 2
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        return binSearch(nums, 0, nums.length - 1, target);
    }
    
	public static int binSearch(int[] n, int start, int end, int target){
		int mid = start + (end - start) / 2;
		if(target < n[mid] && start < mid) 
			return binSearch(n, start, mid - 1, target);
		else if(target > n[mid] && mid < end) 
			return binSearch(n, mid + 1, end, target);
		else if(target == n[mid]) return mid;
		else{
			if(target > n[mid]) return mid + 1;
			return mid;
		}
	}
}

// version 3
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length > 0){
            int start = 0, end = nums.length - 1;
            while(start <= end){
                int mid = start + (end - start) / 2;
                if(nums[mid] == target) return mid;
                else if(nums[mid] < target) start = mid + 1;
                else end = mid - 1;
            }
            return start;
        }
        return 0;
    }
}
