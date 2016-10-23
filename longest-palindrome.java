/*
Source : https://leetcode.com/problems/longest-palindrome/
Author : Jiayi Lei
Date   : Oct 16, 2016

Description:
    Given a string which consists of lowercase or uppercase letters, find the 
	length of the longest palindromes that can be built with those letters.

	This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
	Assume the length of given string will not exceed 1,010.

Example:

	Input:
	"abccccdd"

	Output:
	7

	Explanation:
	One longest palindrome that can be built is "dccaccd", whose length is 7.
*/

public class Solution {
    public int longestPalindrome(String s) {
        if(s == null || s.length() < 1) return 0;
        if(s.length() == 1) return 1;
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        
        int odd = 0, even = 0;
        boolean flag = false;
        for(char c: map.keySet()){
            int num = map.get(c);
            if(num % 2 == 0){
                even += num;
            } else {
                odd += num - 1;
                flag = true;
            }
        }
        if(!flag) odd--;
        return even + odd + 1;
    }
}
