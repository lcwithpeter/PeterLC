/*
Source : https://leetcode.com/problems/palindrome-number/
Author : Jiayi Lei
Date   : Sep 28, 2015
Description:
    Determine whether an integer is a palindrome. Do this without extra space.

Some hints:
	Could negative integers be palindromes? (ie, -1)
	
	If you are thinking of converting the integer to string, note the 
	restriction of using extra space.
	
	You could also try reversing an integer. However, if you have solved the 
	problem "Reverse Integer", you know that the reversed integer might 
	overflow. How would you handle such case?

	There is a more generic way of solving this problem.

Tags:
	Math
Similar Problems:
	https://leetcode.com/problems/palindrome-linked-list/

*/

public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        else if(x == 0) return true;
        else{
            if(x % 10 == 0) return false;
            int rev = 0;
            while(x > rev){
                rev = rev * 10 + x % 10;
                if(x > rev) x /= 10;
            }
            return x == rev;
        }
    }
}
