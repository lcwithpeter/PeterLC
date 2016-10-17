/*
Source : https://leetcode.com/problems/perfect-squares/
Author : Jiayi Lei
Date   : Mar 21, 2016

Description:
    Given a positive integer n, find the least number of perfect square numbers 
	(for example, 1, 4, 9, 16, ...) which sum to n.

	For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, 
	return 2 because 13 = 4 + 9.

Credits:
	Special thanks to @jianchao.li.fighter for adding this problem and creating 
	all test cases.

Tags:
	Dynamic Programming; Breadth-first Search; Math;
*/

// version 1
public class Solution {
    public int numSquares(int n) {
        if(n <= 0) return 0;
        if((int)(Math.log(n)/Math.log(2)) == n) return 1;
        
        int[] sq = new int[(int)Math.floor(Math.sqrt(n))];
        for(int i = 1; i * i <= n; i++){
            sq[i - 1] = i * i;
        }
        
        int[] nums = new int[n + 1];
        nums[1] = 1;
        for(int i = 2; i <= n; i++){
            // check square number
            double sqrt = Math.sqrt(i);
            if(sqrt == Math.floor(sqrt)){
                nums[i] = 1;
                continue;
            } else {
                int min = Integer.MAX_VALUE;
                for(int j: sq){
                    if(j > i) break;
                    min = Math.min(min, nums[i - j]);
                }
                nums[i] = min + 1;
            }
        }
        return nums[n];
    }
}

// version 2
public class Solution {
    public int numSquares(int n) {
        if(n <= 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            int min = Integer.MAX_VALUE;
            int j = 1;
            while(i - j*j >= 0){
                min = Math.min(min, dp[i - j*j] + 1);
                j++;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}

// version 3: Mathematical method
public class Solution{
	public int numSquares(int n) {
        if(n <= 0) return 0;
        // If n is a perfect square, return 1.
        if(isSquare(n)) return 1;

        // The result is 4 if and only if n can be written in the
        // form of 4^k*(8*m + 7). Please refer to
        // Legendre's three-square theorem.
        while ((n & 3) == 0) // n%4 == 0
        {
            n >>= 2;
        }
        if ((n & 7) == 7) // n%8 == 7
        {
            return 4;
        }
        
        // Check whether 2 is the result.
        int sqrt_n = (int)(Math.sqrt(n));
        for(int i = 1; i <= sqrt_n; i++) {
            if (isSquare(n - i*i))
            {
                return 2;
            }
        }
        
        return 3;
    }
    private boolean isSquare(int n){
        int sqrt_n = (int) Math.sqrt(n);
        return (sqrt_n*sqrt_n == n);
    }
}