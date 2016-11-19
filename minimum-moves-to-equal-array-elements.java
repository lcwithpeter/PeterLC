/*
Source : https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
Author : Jiayi Lei
Date   : Nov 12, 2015

Description:
	Given a non-empty integer array of size n, find the minimum number of moves 
	required to make all array elements equal, where a move is incrementing n - 1
	elements by 1.

Example:
	Input:
	[1,2,3]
	Output:
	3
	
	Explanation:
	Only three moves are needed (remember each move increments two elements):

	[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
*/

// version 1
// 13 ms
/*
123: 233 343 444 (3)
847: 858 869 979 10-8-9 10-9-10 10-10-11 11-11-11(7)
*/
public class Solution {
    public int minMoves(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        
        int min = nums[0];
        for(int i: nums){
            min = Math.min(min, i);
        }
        
        int diff = 0;
        for(int i: nums){
            diff += i - min;
        }
        
        return diff;
    }
}
