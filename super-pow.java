/*
Source : https://leetcode.com/problems/super-pow/
Author : Jiayi Lei
Date   : Oct 16, 2016
Description:
    Your task is to calculate ab mod 1337 where a is a positive integer and b is
	an extremely large positive integer given in the form of an array.

Example1:

	a = 2
	b = [3]

	Result: 8
Example2:

	a = 2
	b = [1,0]

	Result: 1024
Credits:
	Special thanks to @Stomach_ache for adding this problem and creating all 
	test cases.
*/

/*
  a^5432 
= a^5000 * a^400 * a^30 * a^2
= (((a^10)^10)^10)^5 * ((a^10)^10)^4 * (a^10)^3 * a^2
---------------------------------------
x ^ y % m 信息安全数学基础:
let a = 1
	b = x
	y = 2^i1 + 2^i2 + ... + 2^k
for i = 0 to k
	if i == 1
		a = (a * b) % m
	b = b ^ 2 % m
*/
public class Solution {
    public int superPow(int a, int[] b) {
        if(a == 1) return 1;
		int mod = 1337;
        a %= mod;
        int rem = 1;
        for(int i = b.length - 1; i >= 0; i--){
            rem = rem * modPow(a, b[i], mod) % mod;
            a = modPow(a, 10, mod);
        }
        return rem;
    }
    private int modPow(int x, int y, int m){
       x %= m;
       int p = y, a = 1, b = x;
       while(p > 0){
           if((p & 1) == 1){
               a = (a * b) % m;
           }
           b = (b * b) % m;
           p >>= 1;
       }
       return a;
    }
}
