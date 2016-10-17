/*
Source : https://leetcode.com/problems/rotate-array/
Author : Jiayi Lei
Date   : May 29, 2015
Description:
    Rotate an array of n elements to the right by k steps.
    For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to 
    [5,6,7,1,2,3,4].
Note: 
    Try to come up as many solutions as you can, there are at least 3 
    different ways to solve this problem.
Hint:
    Could you do it in-place with O(1) extra space?
    Related problem: Reverse Words in a String II
Credits:
    Special thanks to @Freezen for adding this problem and creating all test 
	cases.
*/

// method of O(n) extra space
public class Solution {
    public void rotate(int[] nums, int k) {
        int leng = nums.length;
        if(leng >= 0 && k >= 0){
            int realk = k % leng;
            if(realk != 0){
                int[] result = new int[leng];
                for(int i = 0; i < leng; i++){
                    result[i] = nums[(leng - realk + i)%leng];
                }
                for(int i = 0; i < leng; i++){
                    nums[i] = result[i];
                }
            }
        }        
    }
}

// need to construct the method of O(1) extra space
public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length > 0){
            k = k % nums.length;
            if(k < 0) k += nums.length;
            if(k != 0){
                 reverse(nums, 0, nums.length - 1);
                 reverse(nums, 0, k - 1);
                 reverse(nums, k, nums.length - 1);
            }
        }
    }
    private void reverse(int[] nums, int start, int end){
        for(; start < end; start++, end--){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }
}
