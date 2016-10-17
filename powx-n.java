/*
Source : https://leetcode.com/problems/powx-n/
Author : Jiayi Lei
Date   : Jun 3, 2015

Description:
    Implement pow(x, n).
Tags: Math, Binary Search
*/

public class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return (double)1;
        else if(n < 0){
            n = -n;
            x = 1 / x;
        }
        return (n % 2 == 0) ? (myPow(x * x, n / 2)) : (x * myPow(x, n - 1));
    }
}
