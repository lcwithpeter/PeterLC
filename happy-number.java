/*
Source : https://leetcode.com/problems/happy-number/
Author : Jiayi Lei
Date   : May 28, 2015

Description:
    Write an algorithm to determine if a number is "happy".
    A happy number is a number defined by the following process: Starting with
    any positive integer, replace the number by the sum of the squares of its 
    digits, and repeat the process until the number equals 1 (where it will 
    stay), or it loops endlessly in a cycle which does not include 1. Those 
    numbers for which this process ends in 1 are happy numbers.

Example: 
    19 is a happy number

    1^2 + 9^2 = 82
    8^2 + 2^2 = 68
    6^2 + 8^2 = 100
    1^2 + 0^2 + 0^2 = 1
Credits:
    Special thanks to @mithmatt and @ts for adding this problem and creating 
    all test cases.
*/

// solution 1: ArrayList
public class Solution {
    public boolean isHappy(int n) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(true){
			int sum = 0;
			while(n > 0){
				sum += Math.pow(n % 10, 2);
				n /= 10;
			}
			if(sum == 1) return true;
			else{
				if(list.contains(sum)) break;
				list.add(sum);
				n = sum;
			}
		}
		return false;
    }
}

// solution 2: HashSet
public class Solution {
    public boolean isHappy(int n) {
        if(n == 1 || tenPowCheck(n)) return true;
        Set<Integer> set = new HashSet<Integer>();
        while(set.add(n)){
            n = calc(n);
        }
        return n == 1;
    }
	
    private boolean tenPowCheck(int n){
        double res = Math.log10(n);
        return res == Math.floor(n);
    }
	
    private int calc(int n){
        int sum = 0;
        while(n > 9){
            sum += (int)Math.pow(n % 10, 2);
            n /= 10;
        }
        sum += (int)Math.pow(n, 2);
        return sum;
    }
}

// solution 3: Floyd Cycle Detection Algorithm
public class Solution {
    public boolean isHappy(int n) {
        if(n == 1 || tenPowCheck(n)) return true;
        int slow = n, fast = n;
        do{
            slow = calc(slow);
            fast = calc(fast);
            fast = calc(fast);
        }while(slow != fast);
        return slow == 1;
    }
	
    private boolean tenPowCheck(int n){
        double res = Math.log10(n);
        return res == Math.floor(n);
    }
	
    private int calc(int n){
        int sum = 0, temp;
        while(n > 0){
            temp = n % 10;
            sum += temp * temp;
            n /= 10;
        }
        return sum;
    }
}
