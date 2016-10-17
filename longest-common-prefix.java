/*
Source : https://leetcode.com/problems/longest-common-prefix/
Author : Jiayi Lei
Date   : Jul 30, 2015

Description:
    Write a function to find the longest common prefix string amongst an array 
    of strings.
    
Tags: String;
*/

// version 1
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        String s = strs[0];
        for(int i = 1; i < strs.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < Math.min(strs[i].length(), s.length()); j++){
                if(s.charAt(j) != strs[i].charAt(j)) break;
                else sb.append(strs[i].charAt(j));
            }
            s = sb.toString();
        }
        return s;
    }
}

// version 2
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length > 0){
            String prefix = strs[0];
            for(String s : strs){
                if(s.length() < prefix.length()) prefix = s;
            }            
            for(int i = prefix.length(); i >= 1; i--){
                for(String s : strs){
                    if(!s.substring(0, prefix.length()).equals(prefix)){
                        prefix = prefix.substring(0, prefix.length() - 1);
                        break;
                    }
                }
            }            
            return prefix;
        }
        return "";
    }
}

// solution 3
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        
        int index = 0;
        boolean flag = true;
        while(index < strs[0].length()){
            char cur = strs[0].charAt(index);
            for(String s: strs){
                if(index >= s.length() || s.charAt(index) != cur){
                    flag = false;
                    break;
                }
            }
            if(!flag) break;
            index++;
        }
        
        return strs[0].substring(0, index);
    }
}

// solution 4
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ret = "";
        if(strs != null && strs.length > 0){
            if(strs.length == 1) return strs[0];
            ret = strs[0];
            int index = ret.length();
            for(int i = 0; i < ret.length(); i++){
                char cur = ret.charAt(i);
                for(int j = 0; j < strs.length; j++){
                    if(i == strs[j].length() || cur != strs[j].charAt(i)){
                        return ret.substring(0, i);
                    }
                }
            }
        }
        return ret;
    }
}

