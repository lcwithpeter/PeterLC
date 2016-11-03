/*
Source : https://leetcode.com/problems/remove-k-digits/
Author : Jiayi Lei
Date   : Oct 23, 2015

Description:
	Given a non-negative integer num represented as a string, remove k digits 
	from the number so that the new number is the smallest possible.

Note:
	The length of num is less than 10002 and will be ≥ k.
	The given num does not contain any leading zero.
Example 1:
	Input: num = "1432219", k = 3
	Output: "1219"
	Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219
	which is the smallest.
Example 2:
	Input: num = "10200", k = 1
	Output: "200"
	Explanation: Remove the leading 1 and the number is 200. Note that the 
	output must not contain leading zeroes.
Example 3:
	Input: num = "10", k = 2
	Output: "0"
	Explanation: Remove all the digits from the number and it is left with 
	nothing which is 0.

*/

public class Solution {
    public String removeKdigits(String num, int k) {
        if(num == null || num.length() == 0 ||
        num.length() <= k) return "0";
        if(k == 0) return num;
        
        int start = 0, window = k;
        StringBuilder sb = new StringBuilder();
        
        while(start + window < num.length() && window > 0){
            int minIndex = start;
            for(int i = 1; i < window; i++){
                if(num.charAt(start + i) - '0' < num.charAt(minIndex) - '0'){
                    minIndex = start + i;
                }
            }
            if(num.charAt(start + window) - '0' < num.charAt(minIndex) - '0'){
                start += window;
                window = 0;
            } else {
                while(start != minIndex){ 
                    window--;
                    start++;
                }
                sb.append(num.charAt(start++));
            }
        }
        
        while(window-- > 0) start++;
        
        if(start < num.length()){
            sb.append(num.substring(start));
        }
        
        String ans = sb.toString();
        
        int i = 0;
        for(; i < ans.length() && ans.charAt(i) == '0'; i++);
        
        if(i == ans.length()) return "0";
        return ans.substring(i);
        
        
    }
}
