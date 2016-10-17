/*
Source : https://leetcode.com/problems/implement-strstr/
Author : Jiayi Lei
Date   : Jun 21, 2015

Description:
    Implement strStr().
    Returns the index of the first occurrence of needle in haystack, or -1 if 
    needle is not part of haystack.

Update (2014-11-02):
    The signature of the function had been updated to return the index instead 
    of the pointer. If you still see your function signature returns a char * 
    or String, please click the reload button  to reset your code definition.

Tags: String; Two Pointers
*/

// version 1
public class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        if(haystack.length() == 0 || haystack.length() < needle.length())
			return -1;
        for(int i = 0; i < haystack.length() && 
			haystack.length() - i >= needle.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                int indexi = i, k = 0;
                for(; k < needle.length() && indexi < haystack.length(); k++){
                    if(haystack.charAt(indexi) != needle.charAt(k)) break;
                    indexi++;
                }
                if(k == needle.length()) return i;
            }
        }
        return -1;
    }
}

// version 2
public class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        if(haystack.length() > 0 && needle.length() <= haystack.length()){
            for(int i = 0; i < haystack.length(); i++){
                if(haystack.charAt(i) == needle.charAt(0)){
                    int index = helper(haystack.substring(i), needle);
                    if(index == -1) continue;
                    else return i;
                }
            }
        }
        return -1;
    }
    private int helper(String a, String n){
        if(a.length() < n.length()) return -1;
        for(int i = 0; i < n.length(); i++){
            if(n.charAt(i) != a.charAt(i)) return -1;
        }
        return 0;
    }
}
