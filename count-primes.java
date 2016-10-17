/*
Source : https://leetcode.com/problems/count-primes/
Author : Jiayi Lei
Date   : May 27, 2015
Description:
    Count the number of prime numbers less than a non-negative number, n.
Credits:
    Special thanks to @mithmatt for adding this problem and creating all test 
    cases.
*/

public class Solution {
    public int countPrimes(int n) {
        
        // initialize a boolean array
        boolean[] result = new boolean[n];
        for(int i = 2; i < n; i++){
            result[i] = true;
        }
        
        // Sieve of Eratosthenes method
        for(int i = 2; i * i < n; i++){
            if(result[i]){
                for(int j = i * i; j < n; j += i){
                    result[j] = false;
                }
            }
        }
        
        // count the number of primes
        int count = 0;
        for(int i = 2; i < n; i++){
            if(result[i]) count++;
        }
        
        return count;
    }
}