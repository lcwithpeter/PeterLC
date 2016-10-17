/*
Source : https://leetcode.com/problems/ugly-number-ii/
Author : Jiayi Lei
Date   : Aug 18, 2015

Description:
    Write a program to find the n-th ugly number.
	
	Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
	For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 
	ugly numbers.
	
	Note that 1 is typically treated as an ugly number.

Hint:
	The naive approach is to call isUgly for every number until you reach the 
	nth one. Most numbers are not ugly. Try to focus your effort on generating 
	only the ugly ones.
	
	An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly 
	number.
	
	The key is how to maintain the order of the ugly numbers. Try a similar 
	approach of merging from three sorted lists: L1, L2, and L3.
	
	Assume you have U_k, the k-th ugly number. Then U_(k+1) must be Min(L1 * 2,
	L2 * 3, L3 * 5).
	
Credits:
	Special thanks to @jianchao.li.fighter for adding this problem and creating 
	all test cases.
	
Tags:
	Dynamic Programming; Heap; Math
	
Similar Problems:
	https://leetcode.com/problems/merge-k-sorted-lists/
	https://leetcode.com/problems/count-primes/
	https://leetcode.com/problems/ugly-number/
*/

// version 1
public class Solution {
    public int nthUglyNumber(int n) {
        if(n < 1) return 0;
        
        // initialization: set the 1st ugly number as 1.
        int ugly = 1, count = 1;
        
        // set up 3 queues to store later ugly numbers
        // because the product of two ugly numbers is still an ugly number
        Queue<Integer> q2 = new LinkedList<Integer>();
        Queue<Integer> q3 = new LinkedList<Integer>();
        Queue<Integer> q5 = new LinkedList<Integer>();
        
        // offer them with actually 1*2, 1*3 and 1*5
        // since 1 is the 1st ugly number
        q2.offer(2);
        q3.offer(3);
        q5.offer(5);
        
        while(count != n){
            
            // pick the smallest one among head of each queue
            int min = Math.min(q2.peek(), Math.min(q3.peek(), q5.peek()));
            if(q2.peek() == min) q2.poll();
            else if(q3.peek() == min) q3.poll();
            else q5.poll();
            
            // duplicates may happen
            // then we don't update
            if(ugly != min){
                ugly = min;
                count++;
                q2.offer(ugly * 2);
                q3.offer(ugly * 3);
                q5.offer(ugly * 5);
            }
        }
        return ugly;
    }
}

// version 2
public class Solution {
    public int nthUglyNumber(int n) {
        if(n == 1) return 1;
        int[] ugly = new int[n];
        ugly[0] = 1;
        int two = 0, three = 0, five = 0;
        for(int i = 1; i < n; i++){
            int cur = Math.min(ugly[two] * 2, 
				Math.min(ugly[three] * 3, ugly[five] * 5));
            ugly[i] = cur;
            if(cur == ugly[two] * 2) two++;
            if(cur == ugly[three] * 3) three++;
            if(cur == ugly[five] * 5) five++;
        }
        return ugly[n - 1];
    }
}
