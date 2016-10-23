/*
Source : https://leetcode.com/problems/coin-change/
Author : Jiayi Lei
Date   : Feb 8, 2016

Description:
    You are given coins of different denominations and a total amount of money 
	amount. Write a function to compute the fewest number of coins that you need
	to make up that amount. If that amount of money cannot be made up by any 
	combination of the coins, return -1.

Example 1:
	coins = [1, 2, 5], amount = 11
	return 3 (11 = 5 + 5 + 1)

Example 2:
	coins = [2], amount = 3
	return -1.

Note:
	You may assume that you have an infinite number of each kind of coin.

Credits:
	Special thanks to @jianchao.li.fighter for adding this problem and creating 
	all test cases.
Tags:
	Dynamic Programming;
*/

// version 1
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return -1;
        if(amount <= 0) return 0;
        
        int[] dp = new int[amount + 1];
        for(int i = 1; i < dp.length; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        
        for(int am = 1; am < dp.length; am++){
            for(int coin: coins){
                if(coin <= am){
                    int sub = dp[am - coin];
                    if(sub != Integer.MAX_VALUE){
                        dp[am] = Math.min(sub + 1, dp[am]);
                    }
                }
            }
        }
        
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}

// version 2
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount < 1) return 0;
        if(coins.length < 1) return -1;
        int[] table = new int[amount + 1];
        Arrays.sort(coins);
        for(int i = 0; i < coins.length && coins[i] < table.length; i++){
            table[coins[i]] = 1;
        }
        for(int i = 1; i < table.length; i++){
            if(table[i] == 1) continue;
            table[i] = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length && i - coins[j] > 0; j++){
                if(table[i - coins[j]] == -1) continue;
                table[i] = Math.min(table[i], 1 + table[i - coins[j]]);
            }
            if(table[i] == Integer.MAX_VALUE) table[i] = -1;
        }
        return table[amount];
    }
}
