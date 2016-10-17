/*
Source : https://leetcode.com/problems/majority-element/
Author : Jiayi Lei
Date   : May 31, 2015
Description:
    Given an array of size n, find the majority element. The majority element 
    is the element that appears more than floor(n/2) times. You may assume that
    the array is non-empty and the majority element always exist in the array.
Credits:
    Special thanks to @ts for adding this problem and creating all test cases.
*/

// version 1: HashMap
public class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length > 1){
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for(int x : nums){
                if(!map.containsKey(x)) map.put(x, 1);
                else{
                    int n = map.get(x) + 1;
                    if(n > nums.length / 2) return x;
                    map.put(x, n);
                }
            }
        }
        return 0;
    }
}

// version 2: Moore Voting Algorithm
public class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length > 1){
            int candidate = nums[0], count = 1;
            for(int i = 1; i < nums.length; i++){
                if(count == 0) candidate = nums[i];
                
                if(nums[i] == candidate) count++;
                else count--;
            }
            return candidate;
        }
        return 0;
    }
}

// version 3: Randomization
import java.util.Random;
public class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length > 1){
            Random rand = new Random();
            while(true){
                int count = 0;
                int cur = nums[rand.nextInt(nums.length)];
                System.out.println(cur);
                for(int x : nums){
                    if(x == cur){
                        count++;
                        if(count > nums.length / 2) return cur;
                    }
                }
            }
        }
        return 0;
    }
}

// version 4: Sorting
public class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length > 1){
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }
        return 0;
    }
}
