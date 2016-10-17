/*
Source : https://leetcode.com/problems/permutations/
Author : Jiayi Lei
Date   : Aug 24, 2015

Description:
   Given a collection of numbers, return all possible permutations.

For example,
	[1,2,3] have the following permutations:
	[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
	
Tags: Backtracking

Similiar Problems:
	https://leetcode.com/problems/next-permutation/
	https://leetcode.com/problems/permutations-ii/
	https://leetcode.com/problems/permutation-sequence/
	https://leetcode.com/problems/combinations/
*/

public class Solution {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    List<Integer> sub;
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0) return list;
        
        List<Integer> numList = new LinkedList<Integer>();
        for(int n : nums) numList.add(n);
		
        sub = new LinkedList<Integer>();
        helper(numList);
        
        return list;
    }
    
    private void helper(List<Integer> numList){
        if(numList.size() > 1){
            for(int i = 0; i < numList.size(); i++){
                int cur = numList.get(i);
                sub.add(cur);
                numList.remove(i);
                helper(numList);
                numList.add(i, cur);
                sub.remove(sub.size() - 1);
            }
        }else{
            sub.add(numList.get(0));
            list.add(new LinkedList<Integer>(sub));
            sub.remove(sub.size() - 1);
        }
    }
}
