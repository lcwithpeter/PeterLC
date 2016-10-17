/*
Source : https://leetcode.com/problems/bulls-and-cows/
Author : Jiayi Lei
Date   : Dec 2, 2015

Description:
    You are playing the following Bulls and Cows game with your friend: You 
	write down a number and ask your friend to guess what the number is. Each 
	time your friend makes a guess, you provide a hint that indicates how many 
	digits in said guess match your secret number exactly in both digit and 
	position (called "bulls") and how many digits match the secret number but 
	locate in the wrong position (called "cows"). Your friend will use 
	successive guesses and hints to eventually derive the secret number.

For example:
	Secret number:  "1807"
	Friend's guess: "7810"
Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
	Write a function to return a hint according to the secret number and 
	friend's guess, use A to indicate the bulls and B to indicate the cows. In 
	the above example, your function should return "1A3B".

Please note that both secret number and friend's guess may contain duplicate 
digits, for example:

	Secret number:  "1123"
	Friend's guess: "0111"
	In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a 
	cow, and your function should return "1A1B".
	You may assume that the secret number and your friend's guess only contain 
	digits, and their lengths are always equal.

Credits:
	Special thanks to @jeantimex for adding this problem and creating all test 
	cases.
Tags: Tree; Depth-first Search
*/

// solution 1
public class Solution {
    public String getHint(String secret, String guess) {
        if(secret.length() == guess.length()){
            Map<Character, Integer> map1 = new HashMap<Character, Integer>();
            Map<Character, Integer> map2 = new HashMap<Character, Integer>();
            int a = 0, b = 0;
            for(int i = 0; i < secret.length(); i++){
                char s = secret.charAt(i), g = guess.charAt(i);
                if(!checkNum(s) || !checkNum(g))
                    return null;
                if(s != g){
                    if(map2.containsKey(s) && map2.get(s) > 0){
                        map2.put(s, map2.get(s) - 1);
                        b++;
                    }else{
                        map1.put(s, map1.containsKey(s) ? map1.get(s) + 1 : 1);
                    }
                    
                    if(map1.containsKey(g) && map1.get(g) > 0){
                        map1.put(g, map1.get(g) - 1);
                        b++;
                    }else{
                        map2.put(g, map2.containsKey(g) ? map2.get(g) + 1 : 1);
                    }
                }else{
                    a++;
                }
            }
            return Integer.toString(a) + "A" + Integer.toString(b) + "B";
        }
        return null;
    }
    private boolean checkNum(char c){
        return c >= '0' && c <= '9';
    }
}
