/*
Source : https://leetcode.com/problems/contains-duplicate/
Author : Jiayi Lei
Date   : May 31, 2015
Description:
    Given an array of integers, find if the array contains any duplicates. Your
    function should return true if any value appears at least twice in the 
    array, and it should return false if every element is distinct.
*/

// solution 1
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(hm.get(nums[i]) == null){
                hm.put(nums[i], 1);
            }
            else{
                return true;
            }
        }
        return false;
    }
}

// solution 2
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length > 1){
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for(int i = 0; i < nums.length; i++){
                if(!map.containsKey(nums[i])) map.put(nums[i], 1);
                else return true;
            }
        }
        return false;
    }
}
