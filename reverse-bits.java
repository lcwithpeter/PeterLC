/*
Source : https://leetcode.com/problems/reverse-bits/
Author : Jiayi Lei
Date   : Jul 5, 2015

Description:
    Reverse bits of a given 32 bits unsigned integer. 
    For example, given input 43261596 (represented in binary as 
    00000010100101000001111010011100), return 964176192 (represented in binary 
    as 00111001011110000010100101000000).

Follow up:
    If this function is called many times, how would you optimize it?
    
Related problem: Reverse Integer

Credits:
    Special thanks to @ts for adding this problem and creating all test cases.
    
Tags: Bit Manipulation
*/

// version 1
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for(int i = 0; i < 32; i++){
            result += n & 1;
            n >>= 1;
            if(i == 31) break;
            result <<= 1;
        }
        return result;
    }
}

// version 2
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int count = 0, res = 0;
        while(true){
            count++;
            if((n & 1) == 1) res |= 1;
            if(count != 32){
                n >>= 1;
                res <<= 1;
            }else{
                break;
            }
        }
        return res;
    }
}
