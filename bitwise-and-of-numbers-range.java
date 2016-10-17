/*
Source : https://leetcode.com/problems/bitwise-and-of-numbers-range/
Author : Jiayi Lei
Date   : Jul 6, 2015

Description:
    Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise 
    AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.

Credits:
    Special thanks to @amrsaqr for adding this problem and creating all test 
    cases.
    
Tags: Bit Manipulation
*/

// solution 1
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if(m == n) return m;
        int num = 0;
        int h = helper(m);
        while(h == helper(n)){
            num |= h;
            m ^= h;
            n ^= h;
            h = helper(m);
        }
        return num;
    }
    private int helper(int n){
        int num;
        while(true){
            num = n;
            n = n & (n - 1);
            if(n == 0) break;
        }
        return num;
    }
}

// solution 2
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
       if(m == 0) return 0;
       int mask = ~0;
       while((m & mask) != (n & mask)) mask <<= 1;
       return m & mask;
    }
}

// solution 3
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
       if(m == 0) return 0;
       if(helper(m) != helper(n)) return 0;
       int mask = ~0;
       while((m & mask) != (n & mask)) mask <<= 1;
       return m & mask;
    }
    private int helper(int n){
        int num;
        while(true){
            num = n;
            n = n & (n - 1);
            if(n == 0) break;
        }
        return num;
    }
}
