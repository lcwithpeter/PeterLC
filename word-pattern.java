/*
Source : https://leetcode.com/problems/word-pattern/
Author : Jiayi Lei
Date   : Oct 6, 2015

Description:
    Given a pattern and a string str, find if str follows the same pattern.

Examples:
	pattern = "abba", str = "dog cat cat dog" should return true.
	pattern = "abba", str = "dog cat cat fish" should return false.
	pattern = "aaaa", str = "dog cat cat dog" should return false.
	pattern = "abba", str = "dog dog dog dog" should return false.

Notes:
	patterncontains only lowercase alphabetical letters, and str contains words 
	separated by a single space. Each word in str contains only lowercase 
	alphabetical letters.
	Both pattern and str do not have leading or trailing spaces.
	Each letter in pattern must map to a word with length that is at least 1.

Credits:
	Special thanks to @minglotus6 for adding this problem and creating all test 
	cases.
    
Tags: 
	Hash Table

Similar Problems:
	https://leetcode.com/problems/isomorphic-strings/
*/

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strArr = str.split(" ");
        if(strArr.length >= 0 && pattern.length() == strArr.length){
            if(pattern.length() == 0) return true;
            Map<Character, String> map1 = new HashMap<Character, String>();
            Map<String, Character> map2 = new HashMap<String, Character>();
            for(int i = 0; i < pattern.length(); i++){
                char letter = pattern.charAt(i);
                String word = strArr[i];
                if(map1.containsKey(letter)){
                    if(!map1.get(letter).equals(word)) return false;
                }
                if(map2.containsKey(word)){
                    if(map2.get(word) != letter) return false;
                }
                map1.put(letter, word);
                map2.put(word, letter);
            }
            return true;
        }
        return false;
    }
}
