/*
Source : https://leetcode.com/problems/multiply-strings/
Author : Jiayi Lei
Date   : Jul 2, 2015

Description:
    Given two numbers represented as strings, return multiplication of the 
    numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
    
Tags: String; Backtracking
*/

// solution 1
public class Solution {
    public String multiply(String num1, String num2) {
		int len = Math.min(num1.length(), num2.length());
		String sum = "0";
		String up = (num1.length() == len) ? num2 : num1;
		String down = (num1.length() == len) ? num1 : num2;
		for(int i = len - 1; i >= 0; i--){
			StringBuilder sb = new StringBuilder();
			int prod = 0, add = 0;
			for(int k = 0; k < len - i - 1; k++) sb.append("0");
			for(int j = up.length() - 1; j >= 0; j--){
				prod = (up.charAt(j) - '0') * (down.charAt(i) - '0') + add;
				add = prod / 10;
				prod %= 10;
				sb.append((char)(prod + '0'));
			}
			if(add != 0) sb.append((char)(add + '0'));
			sum = addition(sum, sb.reverse().toString());
			int s = 0;
			for(int k = 0; k < sum.length(); k++){
				s += sum.charAt(k) - '0';
				if(s > 0) break;
			}
			if(s == 0) sum = "0";
		}
        return sum;
    }
	
	public String addition(String num1, String num2){
		int len1 = num1.length(), len2 = num2.length();
		StringBuilder sb = new StringBuilder();
		int sum = 0, add = 0;
		while(len1-- > 0 && len2-- > 0){
			sum = num1.charAt(len1) - '0' + num2.charAt(len2) - '0' + add;
			add = sum / 10;
			sb.append((char)(sum % 10 + '0'));
		}
		while(len1-- > 0){
			sum = num1.charAt(len1) - '0' + add;
			add = sum / 10;
			sb.append((char)(sum % 10 + '0'));
		}
		while(len2-- > 0){
			sum = num2.charAt(len2) - '0' + add;
			add = sum / 10;
			sb.append((char)(sum % 10 + '0'));
		}
		if(add != 0) sb.append((char)(add + '0'));
		return sb.reverse().toString();
	}
}

// solution 2
public class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int[] prod = new int[len1 + len2];
        for(int i = len1 - 1; i >= 0; i--){
        	for(int j = len2 - 1; j >= 0; j--){
        		prod[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        int sum = 0, carry = 0;
        for(int i = prod.length - 1; i > 0; i--){
        	sum = prod[i] + carry;
        	carry = sum / 10;
        	sb.append((char)(sum % 10 + '0'));
        }
        if(carry != 0) sb.append((char)(carry + '0'));
        String result = sb.reverse().toString();
        sum = 0;
        for(int i = 0; i < result.length(); i++){        	
        	sum += result.charAt(i) - '0';
        	if(sum > 0) break;
        }
        if(sum == 0) result = "0";
        return result;
    }
}
