/*
Source : https://leetcode.com/problems/valid-palindrome/
Author : Jiayi Lei
Date   : Jun 29, 2015

Description:
    Given a string, determine if it is a palindrome, considering only 
    alphanumeric characters and ignoring cases.
For example,
    "A man, a plan, a canal: Panama" is a palindrome.
    "race a car" is not a palindrome.
Note:
    Have you consider that the string might be empty? This is a good question 
    to ask during an interview. For the purpose of this problem, we define 
    empty string as valid palindrome.
    
Tags: String; Two Pointers
*/

// version 1
public class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0) return true;
        int i = 0, j = s.length() - 1;
        while(i < j){
            if(!isValid(s.charAt(i))){
                i++;
                continue;
            }
            if(!isValid(s.charAt(j))){
                j--;
                continue;
            }
            if(transf(s.charAt(i)) != transf(s.charAt(j))) return false;
            else{
                i++;
                j--;
            }
        }
        return true;
    }
    
    private char transf(char c){
        if(c >= 'a' && c <= 'z') c -= 'a' - 'A';
        return c;
    }
    
    private boolean isValid(char c){
        if(c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z') return true;
        if(c >= '0' && c <= '9') return true;
        return false;
    }
}

// version 2
public class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() > 1){
            int i = 0, j = s.length() - 1;
            while(i < j){
                char left = s.charAt(i), right = s.charAt(j);
                if(!(left - 'a' >= 0 && left - 'z' <= 0) &&
                    !(left - 'A' >= 0 && left - 'Z' <= 0) &&
                    !(left - '0' >= 0 && left - '9' <= 0)){
                    i++;
                    continue;
                }
                if(!(right - 'a' >= 0 && right - 'z' <= 0) &&
                    !(right - 'A' >= 0 && right - 'Z' <= 0) &&
                    !(right - '0' >= 0 && right - '9' <= 0)){
                    j--;
                    continue;
                }
                
                if(left == right||
                    left - 'a' == right - 'A' ||
                    left - 'A' == right - 'a'){
                    i++;
                    j--;
                }else return false;
            }
        }
        return true;
    }
}
