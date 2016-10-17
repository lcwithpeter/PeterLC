/*
Source : https://leetcode.com/problems/permutations-ii/
Author : Jiayi Lei
Date   : Aug 25, 2015

Description:
   Given a collection of numbers that might contain duplicates, return all
   possible unique permutations.

For example,
	[1,1,2] have the following unique permutations:
	[1,1,2], [1,2,1], and [2,1,1].
	
Tags: Backtracking

Similiar Problems:
	https://leetcode.com/problems/next-permutation/
	https://leetcode.com/problems/permutations/
	https://leetcode.com/problems/palindrome-permutation-ii/
*/

public class Solution {
    int[] nums;
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if(nums.length > 0){
            this.nums = nums;
            List<Integer> first = convertToList();
            list.add(first);
            while(true){
                nextPermutation();
                List<Integer> sub = convertToList();
                if(sub.equals(first)) break;
                list.add(sub);
            }
        }
        return list;
    }
    private List<Integer> convertToList(){
        List<Integer> sub = new LinkedList<Integer>();
        for(int n : nums) sub.add(n);
        return sub;
    }
    private void nextPermutation(){
        if(nums.length > 1){
            int index1 = nums.length - 2;
            for(; index1 >= 0 && nums[index1] >= nums[index1 + 1]; index1--);
            if(index1 == -1) reverse(0, nums.length - 1);
            else{
                int index2 = nums.length - 1;
                for(; index2 > index1 && nums[index1] >= nums[index2]; index2--);
                swap(index1, index2);
                reverse(index1 + 1, nums.length - 1);
            }
        }
    }
    private void reverse(int start, int end){
        for(; start < end; start++, end--){
            swap(start, end);
        }
    }
    private void swap(int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
