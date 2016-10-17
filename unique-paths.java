/*
Source : https://leetcode.com/problems/unique-paths/
Author : Jiayi Lei
Date   : Jul 13, 2015

Description:
   A robot is located at the top-left corner of a m x n grid (marked 'Start' in
   the diagram below). The robot can only move either down or right at any 
   point in time. The robot is trying to reach the bottom-right corner of the 
   grid (marked 'Finish' in the diagram below).
   
http://leetcode.com/wp-content/uploads/2014/12/robot_maze.png

How many possible unique paths are there?
Above is a 3 x 7 grid. How many possible unique paths are there?
Note: m and n will be at most 100.
    
Tags: Array; Dynamic Programming
*/

public class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0) return 0;
        if(m == 1 || n == 1) return 1;
        int[][] x = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0) x[i][j] = 1;
                else x[i][j] = x[i - 1][j] + x[i][j - 1];
            }
        }
        return x[m - 1][n - 1];
    }
}
