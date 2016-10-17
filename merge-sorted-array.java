/*
Source : https://leetcode.com/problems/merge-sorted-array/
Author : Jiayi Lei
Date   : May 31, 2015
Description:
    Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as 
    one sorted array.
Note:
    You may assume that nums1 has enough space (size that is greater or equal 
    to m + n) to hold additional elements from nums2. The number of elements 
    initialized in nums1 and nums2 are m and n respectively.
*/

// version 1
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int total = m + n;
        while(m > 0 && n > 0){
            if(nums1[m - 1] > nums2[n - 1]){
                nums1[--total] = nums1[--m];
            }
            else{
                nums1[--total] = nums2[--n];
            }
        }
        while(n > 0){
            nums1[--total] = nums2[--n];
        }
    }
}

// version 2
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0){
            for(int k = 0; k < n; k++){
                nums1[k] = nums2[k];
            }
            return;
        }
        if(n == 0) return;
        int i = m - 1, j = n - 1, k = m + n - 1;
        for(; i >=0 && j >= 0 && k >= 0; k--){
            if(nums1[i] > nums2[j]) nums1[k] = nums1[i--];
            else nums1[k] = nums2[j--];
        }
        if(i < 0){
            while(k >= 0){
                nums1[k--] = nums2[j--];
            }
        }
    }
}
