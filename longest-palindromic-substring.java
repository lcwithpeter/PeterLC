/*
Source : https://leetcode.com/problems/longest-palindromic-substring/
Author : Jiayi Lei
Date   : Dec 29, 2015

Description:
    Given a string S, find the longest palindromic substring in S. You may 
	assume that the maximum length of S is 1000, and there exists one unique 
	longest palindromic substring.
Tags: String
*/

// solution 1
public class Solution {
    private String expandPalindrome(String s, int c1, int c2){
		// expand from center
        while(c1 >= 0 && c2 < s.length() && s.charAt(c1) == s.charAt(c2)){
            c1--;
            c2++;
        }
        return s.substring(c1 + 1, c2);
    }
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1) return s;
        String longest = s.substring(0, 1);
        for(int i = 0; i < s.length() - 1; i++){
			// odd length
            String ret = expandPalindrome(s, i, i);
            if(ret.length() > longest.length()) longest = ret;
			// even length
            ret = expandPalindrome(s, i, i + 1);
            if(ret.length() > longest.length()) longest = ret;
        }
        return longest;
    }
}
