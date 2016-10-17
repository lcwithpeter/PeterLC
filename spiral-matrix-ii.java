/*
Source : https://leetcode.com/problems/spiral-matrix-ii/
Author : Jiayi Lei
Date   : Jul 10, 2015

Description:
    Given an integer n, generate a square matrix filled with elements from 1 to
    n2 in spiral order.

For example,
    Given n = 3,
    You should return the following matrix:
        [
         [ 1, 2, 3 ],
         [ 8, 9, 4 ],
         [ 7, 6, 5 ]
        ]
    
Tags: Array
*/

public class Solution {
    public int[][] generateMatrix(int n) {
        if(n <= 0){
            int[][] m = new int[0][0];
            return m;
        }else{
            int[][] m = new int[n][n];
            int rowS = 0, rowE = n - 1;
            int colS = 0, colE = n - 1;
            int count = 1;
            while(count <= n * n){
                // move right
                for(int i = rowS, j = colS; j <= colE; j++){
                    m[i][j] = count++;
                }
                rowS++;
                if(count > n * n) break;
                
                // move down
                for(int i = rowS, j = colE; i <= rowE; i++){
                    m[i][j] = count++;
                }
                colE--;
                if(count > n * n) break;
                
                // move left
                for(int i = rowE, j = colE; j >= colS; j--){
                    m[i][j] = count++;
                }
                rowE--;
                if(count > n * n) break;
                
                // move up
                for(int i = rowE, j = colS; i >= rowS; i--){
                    m[i][j] = count++;
                }
                colS++;
            }
            return m;
        }
    }
}
