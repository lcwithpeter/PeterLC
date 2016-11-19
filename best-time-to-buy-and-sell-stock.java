/*
Source : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
Author : Jiayi Lei
Date   : Jul 13, 2015

Description:
   Say you have an array for which the ith element is the price of a given 
   stock on day i.
   If you were only permitted to complete at most one transaction (ie, buy one 
   and sell one share of the stock), design an algorithm to find the maximum 
   profit.
    
Tags: Array; Dynamic Programming
*/

// version 1
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int curMin = prices[0], max = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > curMin){
                max = Math.max(max, prices[i] - curMin);
            }else{
                curMin = prices[i];
            }
        }
        return max;
    }
}


// version 2
// 3 ms
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        
        int min = Integer.MAX_VALUE, max = 0;
        for(int i = 0; i < prices.length; i++){
            max = Math.max(max, prices[i] - (min = Math.min(min, prices[i])));
        }
        
        return max;
    }
}
