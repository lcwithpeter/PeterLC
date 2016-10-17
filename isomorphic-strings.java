/*
Source : https://leetcode.com/problems/isomorphic-strings/
Author : Jiayi Lei
Date   : Jun 5, 2015

Description:
    DGiven two strings s and t, determine if they are isomorphic.
    Two strings are isomorphic if the characters in s can be replaced to get t.
    All occurrences of a character must be replaced with another character 
    while preserving the order of characters. No two characters may map to the 
    same character but a character may map to itself.    
    For example,
    Given "egg", "add", return true.
    Given "foo", "bar", return false.
    Given "paper", "title", return true.
Note:
    You may assume both s and t have the same length.
Tags:
    Hash Table
*/

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || s.length() != t.length()) return false;
        if(s.length()== 0 || t.length() == 0) return true;
        HashMap<Character, Character> hm1 = new HashMap<Character, Character>();
        HashMap<Character, Character> hm2 = new HashMap<Character, Character>();
        for(int i = 0; i < s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if(hm1.containsKey(sChar)){
                if(hm1.get(sChar) != tChar) return false;
            }
            if(hm2.containsKey(tChar)){
                if(hm2.get(tChar) != sChar) return false;
            }
            hm1.put(sChar, tChar);
            hm2.put(tChar, sChar);
        }
        return true;
    }
}
