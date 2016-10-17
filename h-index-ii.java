/*
Source : https://leetcode.com/problems/h-index-ii/
Author : Jiayi Lei
Date   : Sep 4, 2015

Description:
	Follow up for H-Index: What if the citations array is sorted in ascending 
	order? Could you optimize your algorithm?

Hint:
	Expected runtime complexity is in O(log n) and the input is sorted.

	
Tags: 
	Binary Search

Similiar Problems:
	https://leetcode.com/problems/h-index/
*/

public class Solution {
    public int hIndex(int[] citations) {
        if(citations.length == 1) return Math.min(1, citations[0]);
        if(citations.length > 1){
            int start = 0, end = citations.length - 1, mid = 0, num = 0;
            while(start != end){
                mid = start + (end - start) / 2;
                num = citations.length - mid;
                if(num == citations[mid]) return num;
                else if(num < citations[mid]) end = mid;
                else start = mid + 1;
            }
            return Math.min(citations.length - start, citations[start]);
        }
        return 0;
    }
}
