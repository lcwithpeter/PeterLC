/*
Source : https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
Author : Jiayi Lei
Date   : Nov 12, 2015

Description:
	Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

	Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

	Could you do this in O(n) runtime?

Example:

	Input: [3, 10, 5, 25, 2, 8]

	Output: 28

	Explanation: The maximum result is 5 ^ 25 = 28.
*/

// version 1
// O(32n) = O(n)
// 104 ms
/*
looking from most significant bit to lowest bit(from left to right), only look 
at prefix bits. To get the maximum XOR result, the goal is to get 1 in every bit.
 Store all prefixes, if the XOR result is 1, there must be two prefixes XOR to 
 be 1 in that bit. So verify it from a reversed direction. If it's 1 in that bit,
 update the max; otherwise, keep checking.
 O(32n) is still linear time.
*/
public class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for(int i = 31; i >= 0; i--){
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet();
            for(int num : nums){
                set.add(num & mask);
            }
            
            int goal = max | (1 << i);
            for(int prefix : set){
                if(set.contains(goal ^ prefix)){
                    max = goal;
                    break;
                }
            }
        }
        return max;
    }
}
