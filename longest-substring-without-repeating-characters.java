/*
Source : https://leetcode.com/problems/longest-substring-without-repeating-characters/
Author : Jiayi Lei
Date   : Sep 2, 2015

Description:
   Given a string, find the length of the longest substring without repeating 
   characters. 

For example:
	the longest substring without repeating letters for "abcabcbb" is "abc", 
	which the length is 3. For "bbbbb" the longest substring is "b", with the 
	length of 1.
	
Tags: Hash Table; Two Pointers; String

Similiar Problems:
	https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() > 0){
            Map<Character, Integer> hm = new HashMap<Character, Integer>();
            int len = 0, max = 0;
            int start = 0;
            for(int i = 0; i < s.length(); i++){
                char curChar = s.charAt(i);
                if(!hm.containsKey(curChar)){
                    hm.put(curChar, i);
                    len++;
                    max = Math.max(max, len);
                }else{
                    if(hm.get(curChar) >= start){
                        start = hm.get(curChar) + 1;
                        len = i - hm.get(curChar);
                        hm.put(curChar, i);
                    }else{
                        hm.put(curChar, i);
                        len++;
                        max = Math.max(max, len);
                    }
                }
            }
            return max;
        }
        return 0;
    }
}
