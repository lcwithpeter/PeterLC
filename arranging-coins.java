/*
Source : https://leetcode.com/problems/arranging-coins/
Author : Jiayi Lei
Date   : Nov 2, 2015

Description:
	You have a total of n coins that you want to form in a staircase shape, 
	where every k-th row must have exactly k coins.

	Given n, find the total number of full staircase rows that can be formed.

	n is a non-negative integer and fits within the range of a 32-bit signed 
	integer.

Example 1:

	n = 5

	The coins can form the following rows:
	¤
	¤ ¤
	¤ ¤

	Because the 3rd row is incomplete, we return 2.

Example 2:

	n = 8

	The coins can form the following rows:
	¤
	¤ ¤
	¤ ¤ ¤
	¤ ¤

	Because the 4th row is incomplete, we return 3.

*/

// version 1
// 64 ms
// time: O(n)
// space: O(1)
public class Solution {
    public int arrangeCoins(int n) {
        if(n < 1) return 0;
        int i = 1;
        for(; n >= i; i++){
            n -= i;
        }
        return i - 1;
    }
}


// version 2
// 41 ms
// time: O(1)
// space: O(1)
public class Solution {
    public int arrangeCoins(int n) {
        if(n < 1) return 0;
        return (int)((Math.sqrt(8) * Math.sqrt(n + 1 / 8.0) - 1) / 2.0);
    }
}
