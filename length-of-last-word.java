/*
Source : https://leetcode.com/problems/length-of-last-word/
Author : Jiayi Lei
Date   : Jun 18, 2015

Description:
    Given a string s consists of upper/lower-case alphabets and empty space 
    characters ' ', return the length of last word in the string.
    If the last word does not exist, return 0.
Note: 
    A word is defined as a character sequence consists of non-space characters 
    only.
For example, 
    Given s = "Hello World",
    return 5.
Tags: String
*/

// version 1
public class Solution {
    public int lengthOfLastWord(String s) {
        boolean valid = true;
        int lastLen = 0, curLen = 0;
        for(int i = 0; i < s.length(); i++){
            if(valid){
                if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || 
                s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                    curLen++;
                }else if(s.charAt(i) == ' '){
                    if(curLen > 0) lastLen = curLen;
                    curLen = 0;
                }else{
                    valid = false;
                    curLen = 0;
                }
            }else{
                if(s.charAt(i) == ' '){
                    valid = true;
                }
            }
        }
        if(curLen != 0) return curLen;
        return lastLen;
    }
}

// version 2
public class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length() == 0) return 0;
        int len = 0;
        for(String sub : s.trim().split(" ")){
            len = sub.length();
        }
        return len;
    }
}
