/*
Source : https://leetcode.com/problems/maximal-square/
Author : Jiayi Lei
Date   : Jul 9, 2015

Description:
    Given a 2D binary matrix filled with 0's and 1's, find the largest square 
    containing all 1's and return its area.

For example, given the following matrix:
    1 0 1 0 0
    1 0 1 1 1
    1 1 1 1 1
    1 0 0 1 0
    Return 4.
Credits:
    Special thanks to @Freezen for adding this problem and creating all test 
    cases.
    
Tags: Dynamic Programming
*/

public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int x = matrix.length, y = matrix[0].length;
        int[][] m = new int[x][y];
        int max = 0;
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                if(i == 0 || j == 0) m[i][j] = matrix[i][j] - '0';
                else if(matrix[i][j] == '0'){
                    m[i][j] = 0;
                }else{
                    int a = m[i - 1][j - 1];
                    int b = m[i - 1][j];
                    int c = m[i][j - 1];
                    int min = Math.min(a, Math.min(b, c));
                    m[i][j] = (int)Math.pow(((int)Math.sqrt(min) + 1), 2); 
                }
                if(m[i][j] > max) max = m[i][j];
            }
        }
        return max;
    }
}
