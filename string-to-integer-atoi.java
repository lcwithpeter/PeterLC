/*
Source : https://leetcode.com/problems/string-to-integer-atoi/
Author : Jiayi Lei
Date   : May 28, 2015

Description:
    Implement atoi to convert a string to an integer.
    
    Hint: Carefully consider all possible input cases. If you want a challenge,
    please do not see below and ask yourself what are the possible input cases.
    
    Notes: It is intended for this problem to be specified vaguely (ie, no 
    given input specs). You are responsible to gather all the input requirements
    up front.
    
    Update (2015-02-10): The signature of the C++ function had been updated. 
    If you still see your function signature accepts a const char * argument, 
    please click the reload button  to reset your code definition.

    Requirements for atoi: The function first discards as many whitespace 
    characters as necessary until the first non-whitespace character is found. 
    Then, starting from this character, takes an optional initial plus or minus
    sign followed by as many numerical digits as possible, and interprets them 
    as a numerical value.

    The string can contain additional characters after those that form the 
    integral number, which are ignored and have no effect on the behavior of 
    this function.

    If the first sequence of non-whitespace characters in str is not a valid 
    integral number, or if no such sequence exists because either str is empty 
    or it contains only whitespace characters, no conversion is performed.

    If no valid conversion could be performed, a zero value is returned. If the
    correct value is out of the range of representable values, INT_MAX 
    (2147483647) or INT_MIN (-2147483648) is returned.

*/

// version 1
public class Solution {
    public int myAtoi(String str) {
        // check NULL
        if(str == null || str.length() < 1) return 0;
        // trim leading spaces
        str = str.trim();
        // check '-' or '+'
        int sign = 1;
        int i = 0;
    	double sum = 0;
        // check '-' or '+'
        if(str.charAt(0) == '-'){
        	sign = -1;
        	i++;
        }
        else if(str.charAt(0) == '+'){
        	sign = 1;
        	i++;
        }
        // calculate        
        while(str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9'){        	
        	sum = sum * 10 + (str.charAt(i) - '0');
        	i++;        	
        }
        if(sign == -1) sum = -sum;
        // overflow & underflow
    	if(sum > Integer.MAX_VALUE) return Integer.MAX_VALUE;
    	else if(sum < Integer.MIN_VALUE) return Integer.MIN_VALUE;
    	else return (int)sum;
    }
}

// version 2
public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }
        str = str.trim();
        int len = str.length();
        if(len == 0){
            return 0;
        }
        int sign = 1;
        int i = 0;
        if(str.charAt(i) == '-'){
        	sign = -1;
        	i++;
        }
        else if(str.charAt(i) == '+'){
        	sign = 1;
        	i++;
        }
        long sum = 0;
        int MAX = Integer.MAX_VALUE;
        int MIN = Integer.MIN_VALUE;
        while(i < len){       	
        	if(str.charAt(i) < '0' || str.charAt(i) > '9'){
        	    break;
        	}
        	sum = sum * 10 + (str.charAt(i) - '0');
        	if(sum > MAX){
        	    break;
        	}
        	i++;
        }
        if(sign == -1) sum = -sum;
        
    	if(sum > MAX) return MAX;
    	else if(sum < MIN) return MIN;
    	else return (int)sum;
    }
}

// version 3
public class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if(str.length() > 0){
            int sign = 1, index = 0;
            long sum = 0;
            boolean signed = false;
            for(; index < str.length(); index++){
                char cur = str.charAt(index);
                if(!isNumber(cur) && !isSign(cur)) break;
                if(isSign(cur)){
                    if(signed) break;
                    if(cur == '-') sign = -1;
                    signed = true;
                }else{
                    if(sign == 1){
                        sum *= 10;
                        sum += cur - '0';
                        if(sum >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
                    }else{
                        sum *= 10;
                        sum -= cur - '0';
                        if(sum <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
                    }
                    
                }
            }
            return (int)sum;
        }
        return 0;
    }
    private boolean isNumber(char c){
        return c >= '0' && c <= '9';
    }
    private boolean isSign(char c){
        return c == '+' || c == '-';
    }
}

// version 4
public class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if(str.length() > 0){
            long base = 0;
            int sign = 1, index = 0;
            
            if(str.charAt(0) == '-' || str.charAt(0) == '+'){
                sign = str.charAt(0) == '-' ? -1 : 1;
                index++;
            }
            
            for(; index < str.length() && isNumber(str.charAt(index)); index++){
                base *= 10;
                base += str.charAt(index) - '0';
                if(sign == 1 && base >= Integer.MAX_VALUE) 
					return Integer.MAX_VALUE;
                if(sign == -1 && -base <= Integer.MIN_VALUE)
					return Integer.MIN_VALUE;
            }
            
            return sign * (int)base;
        }
        return 0;
    }
    private boolean isNumber(char c){
        return c >= '0' && c <= '9';
    }
}

