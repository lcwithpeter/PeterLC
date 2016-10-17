/*
Source : https://leetcode.com/problems/palindrome-permutation/
Author : Jiayi Lei
Date   : Aug 24, 2015

Description:
    Given a string, determine if a permutation of the string could form a 
	palindrome.

For example,
	"code" -> False, "aab" -> True, "carerac" -> True.

Hint:
	Consider the palindromes of odd vs even length. What difference do you 
	notice?
	Count the frequency of each character.
	If each character occurs even number of times, then it must be a palindrome.
	How about character which occurs odd number of times?
	
Tags: Hash Table
Similiar Problems:
	https://leetcode.com/problems/longest-palindromic-substring/
	https://leetcode.com/problems/valid-anagram/
	https://leetcode.com/problems/palindrome-permutation-ii/
*/

public class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s.length() != 0){
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            int count = 0;
            for(int i = 0; i < s.length(); i++){
                char cur = s.charAt(i);
                if(!map.containsKey(cur)){
                    map.put(cur, 1);
                    count++;
                }else{
                    int num = map.get(cur);
                    if(num % 2 == 0) count++;
                    else count--;
                    map.put(cur, num + 1);
                }
            }
            if(count > 1) return false;
        }
        return true;
    }
}
