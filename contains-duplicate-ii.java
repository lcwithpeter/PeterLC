/*
Source : https://leetcode.com/problems/contains-duplicate-ii/
Author : Jiayi Lei
Date   : Jun 1, 2015
Description:
    Given an array of integers and an integer k, find out whether there there 
    are two distinct indices i and j in the array such that nums[i] = nums[j] 
    and the difference between i and j is at most k.
*/

// version 1
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length <= 1) return false;
        int len = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0; i < len; i++){
            if(hm.containsKey(nums[i])){
                if(i - hm.get(nums[i]) <= k) return true;
                hm.put(nums[i], i);
            }
            else hm.put(nums[i], i);
        }
        return false;
    }
}

// version 2
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length > 0){
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for(int i = 0; i < nums.length; i++){
                if(map.containsKey(nums[i])){
                    if(Math.abs(map.get(nums[i]) - i) <= k) return true;
                }
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
