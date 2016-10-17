/*
Source : https://leetcode.com/problems/integer-to-roman/
Author : Jiayi Lei
Date   : Jun 18, 2015

Description:
    Given an integer, convert it to a roman numeral.
    Input is guaranteed to be within the range from 1 to 3999.
Tags: Math; String
*/

public class Solution {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] tokens = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
        "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(num > 0){
            if(num >= values[i]){
                sb.append(tokens[i]);
                num -= values[i];
            }else{
                i++;
            }
        }
        return sb.toString();
    }
}
