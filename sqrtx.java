/*
Source : https://leetcode.com/problems/sqrtx/
Author : Jiayi Lei
Date   : Jun 2, 2015

Description:
    Implement int sqrt(int x).

    Compute and return the square root of x.
Tags: Math, Binary Search
*/

// version 1: recursion, binary search
public class Solution {
    public int mySqrt(int x) {
        if(x <= 0) return 0;
        if(x == 1) return 1;
        
        return binFind(1, x, x);		
    }
	
	private int binFind(int start, int end, int target) {
		int mid = start + (end - start) / 2;
		double comp = target / (double)mid;
		if(comp < mid && start < mid) return binFind(start, mid - 1, target);
		else if(comp > mid && mid < end) return binFind(mid + 1, end, target);
		else if(comp == mid) return mid;
		else{
			if(comp < mid) return mid - 1;
			return mid;
		}
	}
}

// version 2: two pointers, binary search
public class Solution {
    public int mySqrt(int x) {
        if(x <= 0) return 0;
        if(x == 1 || x == 2 || x == 3) return 1;
        
        int start = 1;
        int end = x;
        int mid;
        double comp;
        
        while(true){
            mid = start + (end - start) / 2;
            comp = x / mid;
            if(comp < mid && start < mid){
                end = mid - 1;
            }
            else if(comp > mid && mid < end){
                start = mid + 1;
            }
            else if(comp == mid){
                return mid;
            }
            else{
                if(comp < mid) return mid - 1;
                return mid;
            }
        }
    }
}

// version 3: Newton Sqrt
public class Solution {
    public int mySqrt(int x) {
        double old = 0, neww = 1;
        while((int)old != (int)neww){
            old = neww;
            neww = (neww + x/neww)/2;
        }
        return (int)neww;
    }
}

// version 4 (C++ code): wtf (source: http://en.wikipedia.org/wiki/Fast_inverse_square_root)
float Q_rsqrt( float number ){
	long i;
	float x2, y;
	const float threehalfs = 1.5F;
 
	x2 = number * 0.5F;
	y  = number;
	i  = * ( long * ) &y;                       // evil floating point bit level hacking
	i  = 0x5f3759df - ( i >> 1 );               // what the fuck? 
	y  = * ( float * ) &i;
	y  = y * ( threehalfs - ( x2 * y * y ) );   // 1st iteration
//      y  = y * ( threehalfs - ( x2 * y * y ) );   // 2nd iteration, this can be removed
 
	return y;
}