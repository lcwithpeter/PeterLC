/*
Source : https://leetcode.com/problems/kth-largest-element-in-an-array/
Author : Jiayi Lei
Date   : Jul 22, 2015

Description:
    Find the k-th largest element in an unsorted array. Note that it is the k-
    th largest element in the sorted order, not the k-th distinct element.

For example,
    Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
    You may assume k is always valid, 1 ≤ k ≤ array's length.

Credits:
    Special thanks to @mithmatt for adding this problem and creating all test 
    cases.
    
Tags: Heap; Divide and Conquer
*/

public class Solution {
    public int findKthLargest(int[] nums, int k) {		
        if(nums == null || nums.length == 0) return 0;
        int p = Partition(nums, 0, nums.length - 1);
        
        while(p != nums.length - k){
        	if(p < nums.length - k){
        		p = Partition(nums, p + 1, nums.length - 1);
        	}else{
        		p = Partition(nums, 0, p - 1);
        	}
        }
        return nums[p];
    }	
	private int Partition(int A[], int start, int end){
        int pivot = A[end];
        int pIndex = start;
        for(int i = start; i < end; i++){
        	if(A[i] <= pivot )
        		Swap(A, i, pIndex++);        	
        }
        Swap(A, pIndex, end);
       
        return pIndex ;
	}
	private void Swap(int Arr[], int a, int b){
		if(a == b) return;
        int temp = Arr[a];
        Arr[a] = Arr[b];
        Arr[b] = temp;
	}
}
