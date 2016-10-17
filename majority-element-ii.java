/*
Source : https://leetcode.com/problems/majority-element-ii/
Author : Jiayi Lei
Date   : Jul 21, 2015

Description:
    Given an integer array of size n, find all elements that appear more than 
    floor(n/3) times. The algorithm should run in linear time and in O(1) space.

Hint:
    How many majority elements could it possibly have?
    
Tags: Array
*/

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        if(nums == null && nums.length == 0) return list;
        int cur1 = 0, cnt1 = 0, cur2 = 1, cnt2 = 0;
        
        for(int x : nums){
            if(x == cur1) cnt1++;
            else if(x == cur2) cnt2++;
            else if(cnt1 == 0){
                cur1 = x;
                cnt1 = 1;
            }else if(cnt2 == 0){
                cur2 = x;
                cnt2 = 1;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        
        cnt1 = 0; cnt2 = 0;
        for(int x : nums){
            if(x == cur1) cnt1++;
            else if(x == cur2) cnt2++;
        }
        if(cnt1 > nums.length / 3) list.add(cur1);
        if(cnt2 > nums.length / 3) list.add(cur2);
            
        return list;
    }
}
