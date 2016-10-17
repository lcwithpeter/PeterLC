/*
Source : https://leetcode.com/problems/ugly-number/
Author : Jiayi Lei
Date   : Aug 18, 2015

Description:
    Write a program to check whether a given number is an ugly number.
	Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
	For example, 6, 8 are ugly while 14 is not ugly since it includes another 
	prime factor 7.

	Note that 1 is typically treated as an ugly number.

Credits:
	Special thanks to @jianchao.li.fighter for adding this problem and creating 
	all test cases.
	
Tags:
	Math

Similar Problems:
	https://leetcode.com/problems/happy-number/
	https://leetcode.com/problems/count-primes/
	https://leetcode.com/problems/ugly-number-ii/
*/

public class Solution {
    public boolean isUgly(int num) {
        if(num < 1) return false;
        ArrayList<Integer> ugly = 
			new ArrayList<Integer>(Arrays.asList(1, 2, 3, 5));
        if(ugly.contains(num)) return true;
        while(num % 2 == 0){
            num /= 2;
        }
        if(ugly.contains(num)) return true;
        while(num % 3 == 0){
            num /= 3;
        }
        if(ugly.contains(num)) return true;
        while(num % 5 == 0){
            num /= 5;
        }
        if(ugly.contains(num)) return true;
        return false;
    }
}
