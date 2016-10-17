/*
Source : https://leetcode.com/problems/strobogrammatic-number/
Author : Jiayi Lei
Date   : Aug 17, 2015

Description:
    A strobogrammatic number is a number that looks the same when rotated 180 
	degrees (looked at upside down).
	Write a function to determine if a number is strobogrammatic. The number is 
	represented as a string.

For example,
	the numbers "69", "88", and "818" are all strobogrammatic.
	
Tags:
	HashTable; Math

Similar Problems:
	https://leetcode.com/problems/strobogrammatic-number-ii/
	https://leetcode.com/problems/strobogrammatic-number-iii/
*/

public class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num.length() == 0) return false;
        return strobogrammatify(num);
    }
    private boolean strobogrammatify(String num){
        String forbidden = "23457";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < num.length(); i++){
            String cur = num.substring(i, i + 1);
            if(forbidden.contains(cur)) return false;
            switch(cur){
                case "0":
                    sb.append("0");
                    break;
                case "1":
                    sb.append("1");
                    break;
                case "6":
                    sb.append("9");
                    break;
                case "8":
                    sb.append("8");
                    break;
                case "9":
                    sb.append("6");
                    break;
                default: break;
            }
        }
        return num.equals(sb.reverse().toString());
    }
}
