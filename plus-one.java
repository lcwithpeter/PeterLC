/*
Source : https://leetcode.com/problems/plus-one/
Author : Jiayi Lei
Date   : May 30, 2015
Description:
    Given a non-negative number represented as an array of digits, plus one to 
    the number. The digits are stored such that the most significant digit is at
    the head of the list.
*/

// version 1
public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if(len > 0){
            int i = len - 1;
            if(digits[i] != 9){
                digits[i] += 1;
                return digits;
            }
            else{
                while(i >= 0 && digits[i] == 9) digits[i--] = 0;
                if(i >= 0){
                    digits[i] += 1;
                    return digits;
                }
                else{
                    int[] nd = new int[len + 1];
                    nd[0] = 1;
                    i = 1;
                    while(i <= len) nd[i++] = 0;
                    return nd;
                }
            }
        }
        return digits;
    }
}

// version 2
public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if(len > 0){            
            for(int i = len - 1; i >= 0; i--){
                digits[i] += 1;
                if(digits[i] > 9){
                    digits[i] -= 10;
                }
                else{
                    return digits;
                }
            }
            int[] ret = new int[len + 1];
            ret[0] = 1;
            for(int i = 1; i < len + 1; i++){
                ret[i] = 0;
            }
            return ret;
        }
        return digits;
    }
}

// version 3
public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits.length > 0){
            if(digits[digits.length - 1] != 9){
                digits[digits.length - 1] += 1;
            }else{
                int i = digits.length - 1;
                for(; i >= 0 && digits[i] == 9; i--){
                    digits[i] = 0;
                }
                if(i >= 0) digits[i] += 1;
                else{
                    int[] overflow = new int[digits.length + 1];
                    overflow[0] = 1;
                    return overflow;
                }
            }
        }
        return digits;
    }
}
