/*
Source : https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
Author : Jiayi Lei
Date   : Jan 14, 2016

Description:
    Given a string, find the length of the longest substring T that contains at 
	most 2 distinct characters.

	For example, Given s = “eceba”,

	T is "ece" which its length is 3.
	
Tags:
	Hash Table; Two Pointers; String

Similar Problems:
	https://leetcode.com/problems/longest-substring-without-repeating-characters/
	https://leetcode.com/problems/sliding-window-maximum/
*/

public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int head = 0, cur = 0, maxLength = 0;
        int k = 2;  // at most k distinct char
        Map<Character, Integer> map = new HashMap<>();
        
        while(cur < s.length()){
            if(map.size() <= k){
                map.put(s.charAt(cur), cur++);
            }
            if(map.size() > k){
                int leftMost = s.length();
                for(int i: map.values()){
                    leftMost = Math.min(leftMost, i);
                }
                map.remove(s.charAt(leftMost));
                head = leftMost + 1;
            }
            maxLength = Math.max(maxLength, cur - head);
        }
        return maxLength;
        
    }
}
