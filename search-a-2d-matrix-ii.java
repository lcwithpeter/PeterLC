/*
Source : https://leetcode.com/problems/search-a-2d-matrix-ii/
Author : Jiayi Lei
Date   : Jun 23, 2015

Description:
    Write an efficient algorithm that searches for a value in an m x n matrix. 
    This matrix has the following properties:
        Integers in each row are sorted in ascending from left to right.
        Integers in each column are sorted in ascending from top to bottom.

For example,
    Consider the following matrix:
        [
          [1,   4,  7, 11, 15],
          [2,   5,  8, 12, 19],
          [3,   6,  9, 16, 22],
          [10, 13, 14, 17, 24],
          [18, 21, 23, 26, 30]
        ]
    Given target = 5, return true.
    Given target = 20, return false.
    
Tags: Divide and Conquer; Binary Search
*/

// solution 1
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        
        int x = matrix.length - 1, y = matrix[0].length - 1;
        for(int i = matrix.length - 1; i >= 0; i--){
            if(matrix[i][0] <= target){
                x = i;
                break;
            }
        }
        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[0][i] > target){
                y = i - 1;
                break;
            }
        }
        
        return helper(matrix, x, y, target);
    }
    private boolean helper(int[][] matrix, int x, int y, int target){
        for(int i = x; i >= 0; i--){
            for(int j = 0; j <= y; j++){
                if(matrix[i][j] == target) return true;
            }
        }
        return false;
    }
}

// solution 2
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int x = 0, y = matrix[0].length - 1;
        while(x < matrix.length && y >= 0){
            if(matrix[x][y] > target) y--;
            else if(matrix[x][y] < target) x++;
            else return true;
        }
        return false;
    }
}
