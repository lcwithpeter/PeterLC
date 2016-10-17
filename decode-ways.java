/*
Source : https://leetcode.com/problems/decode-ways/
Author : Jiayi Lei
Date   : Jul 3, 2015

Description:
    A message containing letters from A-Z is being encoded to numbers using the
    following mapping:
        'A' -> 1
        'B' -> 2
        ...
        'Z' -> 26
    Given an encoded message containing digits, determine the total number of 
    ways to decode it.

For example,
    Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
    The number of ways decoding "12" is 2.
    
Tags: String; Dynamic Programming
*/

public class Solution {
    public int numDecodings(String s) {
        int rows = s.length() + 1;
        if(rows == 1) return 0;
        int[] A = new int[rows];
        A[0] = 1;
        for(int i = 1; i < rows; i++){
        	if(s.charAt(i - 1) >= '1' && s.charAt(i - 1) <= '9') A[i] += A[i - 1];
        	if(i - 2 >= 0){
        		int num = Integer.parseInt(s.substring(i - 2, i));
        		if(num >= 10 && num <= 26) A[i] += A[i - 2];
        	}
        }
        return A[rows - 1];
    }
}
