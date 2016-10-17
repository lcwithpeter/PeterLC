/*
Source : https://leetcode.com/problems/summary-ranges/
Author : Jiayi Lei
Date   : Jul 3, 2015

Description:
    Given a sorted integer array without duplicates, return the summary of its 
    ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

Credits:
    Special thanks to @jianchao.li.fighter for adding this problem and creating
    all test cases.
    
Tags: String; Dynamic Programming
*/

// solution 1
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<String>();
        if(nums != null && nums.length > 0){
            int i = 0, j = 0;
            StringBuilder sb = new StringBuilder();
            for(int k = 0; k < nums.length; k++){
                if(k == i){
                    sb = new StringBuilder();
                    sb.append(nums[i]);
                }
                if(j != nums.length - 1){
                    if(nums[j] + 1 == nums[j + 1]){
                        j++;
                    }else{
                        if(i < j) sb.append("->" + nums[j]);
                        list.add(sb.toString());
                        j++;
                        i = j;
                    }
                }else{
                    if(i < j) sb.append("->" + nums[j]);
                    list.add(sb.toString());
                }
            }
        }
        return list;
    }
}

// solution 2
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new LinkedList<String>();
        if(nums.length > 0){
            int i = 0;
            StringBuilder sb;
            while(i < nums.length){
                sb = new StringBuilder();
                int cur = nums[i];
                sb.append(cur);
                if(i + 1 < nums.length && nums[i + 1] == cur + 1){
                    sb.append("->");
                    cur = nums[i++ + 1];
                    while(i + 1 < nums.length && nums[i + 1] == cur + 1){
                        cur = nums[i++ + 1];
                    }
                    sb.append(cur);
                }
                i++;
                list.add(sb.toString());
            }
        }
        return list;
    }
}

// solution 3
public List<String> summaryRanges(int[] nums) {
    List<String> list = new ArrayList<String>();
    if(nums.length > 0){
        for(int i = 0; i < nums.length; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(nums[i]);
            boolean flag = false;
            while(i != nums.length - 1 && nums[i] + 1 == nums[i + 1]){
                flag = true;
                i++;
            }
            if(flag) sb.append("->" + nums[i]);
            list.add(sb.toString());
        }
    }
    return list;
}
