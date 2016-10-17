/*
Source : https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
Author : Jiayi Lei
Date   : Jan 31, 2016

Description:
    Given an integer matrix, find the length of the longest increasing path.

	From each cell, you can either move to four directions: left, right, up or 
	down. You may NOT move diagonally or move outside of the boundary (i.e. 
	wrap-around is not allowed).

Example 1:

	nums = [
	  [9,9,4],
	  [6,6,8],
	  [2,1,1]
	]
	Return 4
	The longest increasing path is [1, 2, 6, 9].

Example 2:

	nums = [
	  [3,4,5],
	  [3,2,6],
	  [2,2,1]
	]
	Return 4
	The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not 
	allowed.

Credits:
	Special thanks to @dietpepsi for adding this problem and creating all test 
	cases.
	
Tag:
	Depth-first Search; Topological Sort; Memorization;
*/
public class Solution {
    
    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        
        int[][] len = new int[matrix.length][matrix[0].length];
        int maxLength = 0;
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                len[i][j] = dfs(matrix, len, i, j);
                maxLength = Math.max(maxLength, len[i][j]);
            }
        }
        
        return maxLength;
    }
    
    private int dfs(int[][] m, int[][] l, int i, int j){
        
        // check if l[i][j] already has been calculated
        if(l[i][j] > 0) return l[i][j];
        
        // calc l[i][j]
        int max = 1;
        for(int[] dir: dirs){
            int x = i + dir[0], y = j + dir[1];
            if(x < 0 || y < 0 || x >= m.length || y >= m[0].length ||
			m[i][j] >= m[x][y])
                continue;
            max = Math.max(max, 1 + dfs(m, l, x, y));
        }
        
        l[i][j] = max;
        
        return max;
        
    }
}
