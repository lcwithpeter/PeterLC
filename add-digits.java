/*
Source : https://leetcode.com/problems/add-digits/
Author : Jiayi Lei
Date   : Aug 16, 2015
Description:
    Given a non-negative integer num, repeatedly add all its digits until the 
	result has only one digit.

For example:
	Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only
	one digit, return it.

Follow up:
	Could you do it without any loop/recursion in O(1) runtime?

Hint:
	A naive implementation of the above process is trivial. Could you come up 
	with other methods?
	What are all the possible results?
	How do they occur, periodically or randomly?
	You may find this Wikipedia article useful.
Credits:
	Special thanks to @jianchao.li.fighter for adding this problem and creating
	all test cases.
Tags: Math
*/

// the most naive solution
public class Solution {
    public int addDigits(int num) {
        while(num >= 10){
            num = helper(num);
        }
        return num;
    }
    private int helper(int num){
        int sum = 0;
        while(num >= 10){
            sum += num % 10;
            num /= 10;
        }
        sum += num;
        
        return sum;
    }
}

// recursion solution
public class Solution {
    public int addDigits(int num) {
        if(num < 10) return num;
        else if(num < 100) return addDigits(num % 10 + num / 10);
        else return addDigits(num % 10 + addDigits(num / 10));
    }
}

// iteration solution 1
public class Solution {
    public int addDigits(int num) {
        while(true){
            if(num < 10) return num;
            else{
                int right = num % 10;
                num /= 10;
                int left = num % 10;
                if(left + right < 10){
                    num /= 10;
                    num = num * 10 + (left + right);
                }else{
                    num /= 10;
                    num = num * 10 + (left + right - 9);
                }
            }
        }
    }
}

// formular solution with O(1) time complexity
// applied the Digital Root property
// Wiki: https://en.wikipedia.org/wiki/Digital_root

// 3 different cases solution
public class Solution {
    public int addDigits(int num) {
        if(num == 0) return 0;
        else if(num % 9 == 0) return 9;
        else return num % 9;
    }
}

// 1 formular solution
public class Solution {
    public int addDigits(int num) {
       return num - 9 * (int)((num - 1) / 9);
    }
}
