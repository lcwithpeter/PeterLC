/*
Source : https://leetcode.com/problems/palindrome-permutation-ii/
Author : Jiayi Lei
Date   : Aug 25, 2015

Description:
    Given a string s, return all the palindromic permutations (without 
	duplicates) of it. Return an empty list if no palindromic permutation could 
	be form.

For example:
	Given s = "aabb", return ["abba", "baab"].
	Given s = "abc", return [].

Hint:
	If a palindromic permutation exists, we just need to generate the first half
	of the string.
	To generate all distinct permutations of a (half of) string, use a similar 
	approach from: Permutations II or Next Permutation.
	
Tags: Backtracking

Similiar Problems:
	https://leetcode.com/problems/next-permutation/
	https://leetcode.com/problems/permutations-ii/
	https://leetcode.com/problems/palindrome-permutation/
*/

public class Solution {
    List<String> list = new LinkedList<String>();
    public List<String> generatePalindromes(String s) {
        
        if(s.length() == 0) return list;
        if(s.length() == 1){
            list.add(s);
            return list;
        }
        int odd = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(!map.containsKey(cur)){
                map.put(cur, 1);
                odd++;
            }else{
                int reading = map.get(cur);
                if(reading % 2 == 0) odd++;
                else odd--;
                map.put(cur, reading + 1);
            }
        }
        if(odd > 1) return list;
        StringBuilder sb = new StringBuilder();
        char middle = 'a';
        for(Map.Entry e : map.entrySet()){
            int num = (int)e.getValue();
            if(num % 2 == 1) middle = (char)e.getKey();
            while(num > 1){
                sb.append(e.getKey());
                num -= 2;
            }
        }
        char[] elements = sb.toString().toCharArray();
        uniquePermutation(elements, odd == 1, middle);
        
        return list;
    }
    private void uniquePermutation(char[] letters, boolean odd, char middle){
        String sub = convertToString(letters, odd, middle);
        list.add(sub);
        while(true){
            nextPermutation(letters);
            String cur = convertToString(letters, odd, middle);
            if(cur.equals(sub)) break;
            list.add(cur);
        }
    }
    private String convertToString(char[] letters, boolean flag, char mid){
        StringBuilder sb = new StringBuilder();
        for(char x : letters) sb.append(x);
        String secHalf = new StringBuilder(sb).reverse().toString();
        if(flag) sb.append(mid);
        return sb.toString() + secHalf;
    }
    private void nextPermutation(char[] letters){
        //if(letters.length == 1) return;
        int index1 = letters.length - 2;
        for(; index1 >= 0 && letters[index1] >= letters[index1 + 1]; index1--);
        if(index1 == -1) letters = reverse(letters, 0, letters.length - 1);
        else{
            int index2 = letters.length - 1;
            for(; index2 > index1 && letters[index2] <= letters[index1]; index2--);
            letters = swap(letters, index1, index2);
            letters = reverse(letters, index1 + 1, letters.length - 1);
        }
        
    }
    private char[] reverse(char[] letters, int start, int end){
        for(; start < end; start++, end--){
            letters = swap(letters, start, end);
        }
        return letters;
    }
    private char[] swap(char[] letters, int i, int j){
        char temp = letters[i];
        letters[i] = letters[j];
        letters[j] = temp;
        return letters;
    }
}
