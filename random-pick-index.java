/*
Source : https://leetcode.com/problems/random-pick-index/
Author : Jiayi Lei
Date   : Oct 16, 2016
Description:
    Given an array of integers with possible duplicates, randomly output the 
	index of a given target number. You can assume that the given target number 
	must exist in the array.

Note:
	The array size can be very large. Solution that uses too much extra space 
	will not pass the judge.

Example:

	int[] nums = new int[] {1,2,3,3,3};
	Solution solution = new Solution(nums);

	// pick(3) should return either index 2, 3, or 4 randomly. Each index should
	have equal probability of returning.
	solution.pick(3);

	// pick(1) should return 0. Since in the array only nums[0] is equal to 1.
	solution.pick(1);
*/

// Algorithm: Reservoir Sampling(https://en.wikipedia.org/wiki/Reservoir_sampling)
public class Solution {
    private int[] numbers;
    private Random rand;
    public Solution(int[] nums) {
        numbers = nums;
        rand = new Random();
    }
    
    public int pick(int target) {
        int counter = 0, pick = 0;
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] != target) continue;
            if(rand.nextInt(++counter) == 0) pick = i;
        }
        return pick;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
 