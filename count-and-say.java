/*
Source : https://leetcode.com/problems/count-and-say/
Author : Jiayi Lei
Date   : Jun 30, 2015

Description:
    The count-and-say sequence is the sequence of integers beginning as follows:
    1, 11, 21, 1211, 111221, ...
    1 is read off as "one 1" or 11.
    11 is read off as "two 1s" or 21.
    21 is read off as "one 2, then one 1" or 1211.
    Given an integer n, generate the nth sequence.
Note:
    The sequence of integers will be represented as a string.
    
Tags: String; Two Pointers
*/

// version 1
public class Solution {
    public String countAndSay(int n) {
        if(n < 1) return "";        
        else{
        	String s = "1";
        	String[] strArr = new String[n];
        	strArr[0] = "1";
        	for(int j = 1; j < strArr.length; j++){
        		StringBuilder sb = new StringBuilder();
        		int num = 1;
        		for(int i = 0; i < strArr[j - 1].length(); i++){
        			if(i + 1 == strArr[j - 1].length()){
        				sb.append(num);
        				sb.append(strArr[j - 1].charAt(i));				
        			}else{
        				if(strArr[j - 1].charAt(i) != strArr[j - 1].charAt(i + 1)){
        					sb.append(num);
        					sb.append(strArr[j - 1].charAt(i));
        					num = 1;
        				}else num++;
        			}
        		}
        		strArr[j] = sb.toString();
        	}
        	return strArr[n - 1];
        }
    }
}

// version 2
public class Solution {
    public String countAndSay(int n) {
        if(n < 1) return "";
        String cur = "1";
        String last;
        while(n-- > 1){
            last = cur;
            char num = last.charAt(0);
            int count = 0;
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < last.length(); i++){
                if(last.charAt(i) == num) count++;
                else{
                    sb.append(count);
                    sb.append(num);
                    num = last.charAt(i);
                    count = 1;
                }
                if(i == last.length() - 1){
                    sb.append(count);
                    sb.append(num);
                }
            }
            cur = sb.toString();
        }
        return cur;
    }
}
