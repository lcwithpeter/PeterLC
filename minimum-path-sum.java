/*
Source : https://leetcode.com/problems/minimum-path-sum/
Author : Jiayi Lei
Date   : Jul 13, 2015

Description:
   Given a m x n grid filled with non-negative numbers, find a path from top 
   left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
    
Tags: Array; Dynamic Programming
*/

public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int x = grid.length - 1, y = grid[0].length - 1;
        for(int i = x; i >= 0; i--){
        	for(int j = y; j >= 0; j--){
        		if(i == x && j < y) grid[i][j] += grid[i][j + 1];
        		else if(i < x && j == y) grid[i][j] += grid[i + 1][j];
        		else if(i < x && j < y) 
                    grid[i][j] += Math.min(grid[i + 1][j], grid[i][j + 1]);
        	}
        }
        return grid[0][0];
    }
}
