/*
Source : https://leetcode.com/problems/word-break/
Author : Jiayi Lei
Date   : Jul 23, 2015

Description:
    Given a string s and a dictionary of words dict, determine if s can be 
    segmented into a space-separated sequence of one or more dictionary words.

For example, given
    s = "leetcode",
    dict = ["leet", "code"].

    Return true because "leetcode" can be segmented as "leet code".
    
Tags: Dynamic Programming
*/

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        Arrays.fill(f, false);
        f[0] = true;
        
        for(int i = 1; i < f.length; i++){
            for(int j = 0; j < i; j++){
                if(f[j] && wordDict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[s.length()];
    }
}
