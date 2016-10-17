/*
Source : https://leetcode.com/problems/remove-element/
Author : Jiayi Lei
Date   : May 30, 2015
Description:
    Given an array and a value, remove all instances of that value in place and
    return the new length.
    The order of elements can be changed. It doesn't matter what you leave 
    beyond the new length.
*/

// version 1
public class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if(len > 0){
            int index = len - 1;
            int count = 0;
            int i = 0;
            while(i <= index){
                if(nums[index] == val){
                    index--;
                    count++;
                    continue;
                }
                if(nums[i] == val){
                    nums[i] = nums[index];
                    nums[index] = val;
                    index--;
                    count++;
                }
                i++;
            }
            return len - count;
        }
        else return 0;
    }
}

// version 2
public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        else{
            int len = nums.length;
            int index = 0;
            for(int i = 0; i < len; i++){
                if(nums[i] != val){
                    nums[index++] = nums[i];
                }
            }
            return index;
        }
    }
}

// solution 3
public class Solution {
    public int removeElement(int[] nums, int val) {
		int l = 0, r = nums.length - 1;
		while(l <= r){
			if(nums[r] == val){
				r--;
				continue;
			}
			if(nums[l] == val){
				swap(nums, l, r);
			}
			l++;
		}
		return l;
    }
	private void swap(int[] nums, int a, int b){
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}
