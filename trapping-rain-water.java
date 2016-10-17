/*
Source : https://leetcode.com/problems/trapping-rain-water/
Author : Jiayi Lei
Date   : Jun 11, 2015
Description:
    Given n non-negative integers representing an elevation map where the width
    of each bar is 1, compute how much water it is able to trap after raining.
For example, 
    Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
    pic: http://www.leetcode.com/wp-content/uploads/2012/08/rainwatertrap.png
Tag: Stack; Array; Two Pointers
*/

public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length < 3) return 0;
        int left = 0;
        int right = height.length - 1;
        int water = 0;
        while(left < right){
            int min = Math.min(height[left], height[right]);
            if(height[left] == min){
                left++;
                while(left < right && height[left] < min){
                    water += min - height[left];
                    left++;
                }
            }
            else{
                right--;
                while(left < right && height[right] < min){
                    water += min - height[right];
                    right--;
                }
            }
        }
        return water;
    }
}
