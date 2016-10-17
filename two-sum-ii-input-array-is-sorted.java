/*
Source : https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
Author : Jiayi Lei
Date   : Sep 10, 2015

Description:
    Given an array of integers that is already sorted in ascending order, find 
	two numbers such that they add up to a specific target number.

	The function twoSum should return indices of the two numbers such that they 
	add up to the target, where index1 must be less than index2. Please note 
	that your returned answers (both index1 and index2) are not zero-based.

	You may assume that each input would have exactly one solution.

	Input: numbers={2, 7, 11, 15}, target=9
	Output: index1=1, index2=2

Tags:
    Array; Two Pointers; Binary Search

Similar Problems:
	https://leetcode.com/problems/two-sum/
*/

// version 1
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers.length > 1){
            int[] ret = new int[2];
            int left = 0, right = numbers.length - 1;
            while(left < right){
            	int sum = numbers[left] + numbers[right];
            	if(sum > target) right--;
            	else if(sum < target) left++;
            	else break;
            }
            ret[0] = left + 1;
            ret[1] = right + 1;
            return ret;
        }
        return null;
    }
}

// version 2
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if(numbers.length > 0){
            for(int i = 0; i < numbers.length - 1; i++){
                int start = i + 1, end = numbers.length - 1;
				int diff = target - numbers[i];
                if(numbers[start] > diff) break;
                while(start <= end){
                    int mid = start + (end - start) / 2;
                    if(numbers[mid] == diff){
                        res[0] = i + 1;
                        res[1] = mid + 1;
                        return res;
                    }
                    else if(numbers[mid] > diff) end = mid - 1;
                    else start = mid + 1;
                }
            }
        }
        return res;
    }
}
