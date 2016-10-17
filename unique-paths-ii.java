/*
Source : https://leetcode.com/problems/unique-paths-ii/
Author : Jiayi Lei
Date   : Jul 13, 2015

Description:
    Follow up for "Unique Paths":
    Now consider if some obstacles are added to the grids. How many unique 
    paths would there be?
    An obstacle and empty space is marked as 1 and 0 respectively in the grid.
    
For example,
    There is one obstacle in the middle of a 3x3 grid as illustrated below.
        [
          [0,0,0],
          [0,1,0],
          [0,0,0]
        ]
    The total number of unique paths is 2.

Note: m and n will be at most 100.
    
Tags: Array; Dynamic Programming
*/

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || 
        obstacleGrid[0][0] == 1 ||
        obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) 
        return 0;
        int[][] x = new int[obstacleGrid.length][obstacleGrid[0].length];
        x[0][0] = 1;
        for(int i = 0; i < obstacleGrid.length; i++){
            for(int j = 0; j < obstacleGrid[0].length; j++){
                if(obstacleGrid[i][j] == 0 && !(i == 0 && j == 0)){
                    if(j == 0) x[i][j] = x[i - 1][j];
                    else if(i == 0) x[i][j] = x[i][j - 1];
                    else x[i][j] = x[i - 1][j] + x[i][j - 1];
                }
            }
        }
        return x[x.length - 1][x[0].length - 1];
    }
}
