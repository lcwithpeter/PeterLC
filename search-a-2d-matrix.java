/*
Source : https://leetcode.com/problems/search-a-2d-matrix/
Author : Jiayi Lei
Date   : Jun 3, 2015

Description:
    Write an efficient algorithm that searches for a value in an m x n matrix. 
    This matrix has the following properties:
        Integers in each row are sorted from left to right.
        The first integer of each row is greater than the last integer of the 
        previous row.
    For example,
    Consider the following matrix:
    [
      [1,   3,  5,  7],
      [10, 11, 16, 20],
      [23, 30, 34, 50]
    ]
    Given target = 3, return true.
Tags:
    Array; Binary Search
*/

// solution 1
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        for(int i = 0; i < matrix.length; i++){
            if(target <= matrix[i][matrix[i].length - 1]) 
                return binSearch(matrix[i], 0, matrix[i].length - 1, target);
        }
        return false;
    }
    public boolean binSearch(int[] m, int start, int end, int target){
        int mid;
        while(true){
             mid = start + (end - start) / 2;
             if(m[mid] == target) return true;
             else if(m[mid] > target && mid > start) end = mid - 1;
             else if(m[mid] < target && mid < end) start = mid + 1;
             else return false;
        }
    }
}

// solution 2
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        for(int i = 0; i < matrix.length; i++){
            if(target <= matrix[i][matrix[i].length - 1]){
                for(int j = matrix[i].length - 1; j >= 0; j--){
                    if(target == matrix[i][j]) return true;
                }
                return false;
            }
        }
        return false;
    }
}
