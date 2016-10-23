/*
Source : https://leetcode.com/problems/add-strings/
Author : Jiayi Lei
Date   : Oct 16, 2016

Description:
    Given two non-negative numbers num1 and num2 represented as string, return 
	the sum of num1 and num2.

Note:

	The length of both num1 and num2 is < 5100.
	Both num1 and num2 contains only digits 0-9.
	Both num1 and num2 does not contain any leading zero.
	You must not use any built-in BigInteger library or convert the inputs to 
	integer directly.
*/

public class Solution {
    public String addStrings(String num1, String num2) {
        if(num1 == null) return num2;
        if(num2 == null) return num1;
        
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int a = 0, b = 0, add = 0, sum = 0;
        while(i >= 0 || j >= 0){
            if(i < 0) a = 0;
            else a = num1.charAt(i) - '0';
            
            if(j < 0) b = 0;
            else b = num2.charAt(j) - '0';
            sum = a + b + add;
            add = sum / 10;
            sum %= 10;
            sb.append(sum);
            i--;
            j--;
        }
        if(add != 0) sb.append(add);
        return sb.reverse().toString();
    }
}
