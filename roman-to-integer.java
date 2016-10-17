/*
Source : https://leetcode.com/problems/roman-to-integer/
Author : Jiayi Lei
Date   : Jun 17, 2015

Description:
    Given a roman numeral, convert it to an integer.
    Input is guaranteed to be within the range from 1 to 3999.
Tags: Math; String
*/

// solution 1
public class Solution {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0) return 0;
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            int cur = translate(s.charAt(i));
            if(i + 1 < s.length()){
                int next = translate(s.charAt(i + 1));
                if(cur < next){
                    sum += next - cur;
                    i++;
                    continue;
                }
            }
            sum += cur;
        }
        return sum;
    }
    private int translate(char c){        
        switch(c){
            case 'M': return 1000;
            case 'D': return 500;
            case 'C': return 100;
            case 'L': return 50;
            case 'X': return 10;
            case 'V': return 5;
            case 'I': return 1;
        }
        return 0;
    }
}

// solution 2
public class Solution {
    public int romanToInt(String s) {
        if(s.length() > 0){
            int sum = dict(s.charAt(s.length() - 1));
            for(int i = s.length() - 2; i >= 0; i--){
                int cur = dict(s.charAt(i));
                int next = dict(s.charAt(i + 1));
                if(cur < next) sum -= cur;
                else sum += cur;
            }
            return sum;
        }
        return 0;
    }
    private int dict(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
