/*
Source : https://leetcode.com/problems/add-binary/
Author : Jiayi Lei
Date   : Jun 21, 2015

Description:
    Given two binary strings, return their sum (also a binary string).
    For example,
    a = "11"
    b = "1"
    Return "100".
    
Tags: String; Math
*/

// version 1
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int lenA = a.length() - 1, lenB = b.length() - 1;
        int add = 0;
        while(lenA >= 0 && lenB >= 0){
        	int sum = a.charAt(lenA) - '0' + b.charAt(lenB) - '0' + add;
        	add = sum / 2;
        	sb.append((char) (sum % 2 + '0'));
        	lenA--;
        	lenB--;
        }
        for(;lenA >= 0; lenA--){
        	int sum = a.charAt(lenA) - '0' + add;
        	add = sum / 2;
        	sb.append((char) (sum % 2 + '0'));
        }
        for(;lenB >= 0; lenB--){
        	int sum = b.charAt(lenB) - '0' + add;
        	add = sum / 2;
        	sb.append((char) (sum % 2 + '0'));
        }
        if(add == 1) sb.append('1');
        return sb.reverse().toString();
    }
}

// version 2
public class Solution {
    public String addBinary(String a, String b) {
        if(a.length() > 0 && b.length() > 0){
            StringBuilder sb = new StringBuilder();
            if(b.length() > a.length()){
                String temp = a;
                a = b;
                b = temp;
            }
            int extra = 0;
            int i = a.length() - 1, j = b.length() - 1;
            for(; i >= 0 && j >= 0; i--, j--){
                int res = adder(a.charAt(i), b.charAt(j)) + extra;
                extra = res / 2;
                res %= 2;
                sb.append(res);
            }
            for(; i >= 0; i--){
                int res = adder(a.charAt(i), '0') + extra;
                extra = res / 2;
                res %= 2;
                sb.append(res);
            }
            if(extra > 0) sb.append(1);
            
            return sb.reverse().toString();
        }
        return null;
    }
    private int adder(char a, char b){
        return (a - '0') + (b - '0');
    }
}
