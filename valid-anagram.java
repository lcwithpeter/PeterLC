/*
Source : https://leetcode.com/problems/valid-anagram/
Author : Jiayi Lei
Date   : Aug 16, 2015
Description:
    Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
	s = "anagram", t = "nagaram", return true.
	s = "rat", t = "car", return false.

Note:
	You may assume the string contains only lowercase alphabets.
Tags: HashTable; Sort
*/

// solution 1
// HashTable
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() == t.length()){
            if(s.length() == 0) return true;
            Map<Character, Integer> hms = new HashMap<Character, Integer>();
            Map<Character, Integer> hmt = new HashMap<Character, Integer>();
            for(int i = 0; i < s.length(); i++){
                char x = s.charAt(i);
                if(!hms.containsKey(x)){
                    hms.put(x, 1);
                }else{
                    hms.put(x, hms.get(x) + 1);
                }
            }
            for(int i = 0; i < t.length(); i++){
                char x = t.charAt(i);
                if(!hmt.containsKey(x)){
                    hmt.put(x, 1);
                }else{
                    hmt.put(x, hmt.get(x) + 1);
                }
            }
            if(hms.size() != hmt.size()) return false;
            for(Map.Entry<Character, Integer> e : hms.entrySet()){
                char key = e.getKey();
                int value = e.getValue();
                if(!hmt.containsKey(key)) return false;
                if(hmt.get(key) != value) return false;
            }
            return true;
        }
        return false;
    }
}

// solution 2
// Sort
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() == t.length()){
            if(s.length() == 0) return true;
            char[] ss = s.toCharArray();
            char[] tt = t.toCharArray();
            Arrays.sort(ss);
            Arrays.sort(tt);
            for(int i = 0; i < ss.length; i++){
                if(ss[i] != tt[i]) return false;
            }
            return true;
        }
        return false;
    }
}

// solution 3
// alphabet chart
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() == t.length()){
            int[] alphabet = new int[26];
            for(int i = 0; i < s.length(); i++){
                alphabet[s.charAt(i) - 'a']++;
                alphabet[t.charAt(i) - 'a']--;
            }
            for(int i = 0; i < alphabet.length; i++){
                if(alphabet[i] != 0) return false;
            }
            return true;
        }
        return false;
    }
}
