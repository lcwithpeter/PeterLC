/*
Source : https://leetcode.com/problems/climbing-stairs/
Author : Jiayi Lei
Date   : Jul 4, 2015

Description:
    You are climbing a stair case. It takes n steps to reach to the top.
    Each time you can either climb 1 or 2 steps. In how many distinct ways can 
    you climb to the top?
    
Tags: Dynamic Programming
*/

// solution 1
public class Solution {
    public int climbStairs(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int[] x = new int[n];
        x[0] = 1;
        x[1] = 2;
        for(int i = 2; i < n; i++){
            x[i] = x[i - 1] + x[i - 2];
        }
        return x[n - 1];
    }
}

// solution 2
public class Solution {
    public int climbStairs(int n) {
        if(n == 0) return 0;
        int[] a = new int[n + 1];
        a[0] = 1;
        for(int i = 1; i < n + 1; i++){
            a[i] += a[i - 1];
            if(i - 2 >= 0) a[i] += a[i - 2];
        }
        return a[n];
    }
}

// solution 3
// more concise dp
// 0 ms
public class Solution {
    public int climbStairs(int n) {
        if(n < 0) return 0;
        
        int[] dp = new int[n + 2];
        dp[1] = 1;
        for(int i = 2; i <= n+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[dp.length - 1];
    }
}

// solution 4
// imporving space by rolling variables.
// 0 ms
public class Solution {
    public int climbStairs(int n) {
        if(n < 0) return 0;
        
        int a = 0, b = 1;
        while(n-- > 0){
            int c = a + b;
            a = b;
            b = c;
        }
        
        return b;
    }
}
