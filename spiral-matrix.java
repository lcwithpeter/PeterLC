/*
Source : https://leetcode.com/problems/spiral-matrix/
Author : Jiayi Lei
Date   : Jul 10, 2015

Description:
    Given a matrix of m x n elements (m rows, n columns), return all elements 
    of the matrix in spiral order.

For example,
    Given the following matrix:
        [
         [ 1, 2, 3 ],
         [ 4, 5, 6 ],
         [ 7, 8, 9 ]
        ]
    You should return [1,2,3,6,9,8,7,4,5].
    
Tags: Array
*/

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if(matrix != null && matrix.length > 0){            
            int rowE = matrix.length - 1, colE = matrix[0].length - 1;
            int total = (rowE + 1) * (colE + 1);
            int rowS = 0, colS = 0;
            int i = 0, j = 0;
            while(total > 0){
                
                // move right
                for(; j <= colE; j++){
                    list.add(matrix[i][j]);
                    total--;
                }
                j--; i++;
                rowS++;
                if(total == 0) break;
                
                // move down
                for(; i <= rowE; i++){
                    list.add(matrix[i][j]);
                    total--;
                }
                i--; j--;
                colE--;
                if(total == 0) break;
                
                // move left
                for(; j >= colS; j--){
                    list.add(matrix[i][j]);
                    total--;
                }
                j++; i--;
                rowE--;
                if(total == 0) break;
                
                // move up
                for(; i >= rowS; i--){
                    list.add(matrix[i][j]);
                    total--;
                }
                i++; j++;
                colS++;
            }
        }
        return list;
    }
}
