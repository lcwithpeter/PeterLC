/*
Source : https://leetcode.com/problems/find-peak-element/
Author : Jiayi Lei
Date   : Jun 3, 2015

Description:
    A peak element is an element that is greater than its neighbors.
    Given an input array where num[i] ≠ num[i+1], find a peak element and 
    return its index.
    The array may contain multiple peaks, in that case return the index to any 
    one of the peaks is fine.
    You may imagine that num[-1] = num[n] = -∞.
    For example, in array [1, 2, 3, 1], 3 is a peak element and your function 
    should return the index number 2.
Note:
    Your solution should be in logarithmic complexity.

Credits:
    Special thanks to @ts for adding this problem and creating all test cases.

Tags: Array, Binary Search
*/

// version 1
// comparing 3 consecutive elements every time. 
// Time: O(log n)
// Space: O(1)
public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        int len = nums.length;
        if(len == 2){
            if(nums[0] > nums[1]) return 0;
            return 1;
        }
        int start = 0, end = len - 1, mid;
        while(true){
            mid = start + (end - start) / 2;
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
            else if(mid - 1 == 0 && mid + 1 != len - 1){
            	if(nums[mid - 1] > nums[mid]) return mid - 1;
            	else start = mid;
            }
            else if(mid - 1 != 0 && mid + 1 == len - 1){
            	if(nums[mid + 1] > nums[mid]) return mid + 1;
            	else end = mid;
            }
            else if(mid - 1 == 0 && mid + 1 == len - 1){
            	if(nums[mid] < nums[mid - 1]) return mid - 1;
            	else return mid + 1;
            }
            else{
            	if(nums[mid] < nums[mid - 1]) end = mid;
            	else start = mid;
            }
        }
    }
}

// version 2
// comparing 2 consecutive elements every time, more concise version.
// Just find the maximum element. It will always be peak wherever it is
// Time: O(log n)
// Space: O(1)
public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length <= 1) return 0;
        int start = 0, end = nums.length - 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] < nums[mid + 1]) start = mid + 1;
            else end = mid;
        }
        return start;
    }
}
