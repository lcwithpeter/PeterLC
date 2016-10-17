/*
Source : https://leetcode.com/problems/sudoku-solver/
Author : Jiayi Lei
Date   : Jul 8, 2015

Description:
    Write a program to solve a Sudoku puzzle by filling the empty cells.
    Empty cells are indicated by the character '.'.
    You may assume that there will be only one unique solution.
    
http://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png
A sudoku puzzle...

http://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Sudoku-by-L2G-20050714_solution.svg/250px-Sudoku-by-L2G-20050714_solution.svg.png
...and its solution numbers marked in red.
    
Tags: Backtracking; Hash Table
*/


public class Solution {
    final char[] candidate = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
	
	// call backtrack function
    public void solveSudoku(char[][] board) {
        backtrack(board, findNextPst(board, new int[2]));
    }
    
	// backtrack logic
    private boolean backtrack(char[][] board, int[] pst){
        if(pst[0] == 9) return true;
        for(char c : candidate){
            board[pst[0]][pst[1]] = c;
            if(isValidSudoku(board)){
                if(backtrack(board, findNextPst(board, pst))) return true;
            }
        }
        board[pst[0]][pst[1]] = '.';
        return false;
    }
    
    private boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            // row check
            if(!checker(board, i, i, 0, 9)) return false;
            // col check
            if(!checker(board, 0, 9, i, i)) return false;
            // box check
            for(int j = 0; j < 9; j++){
                if(i % 3 == 0 && j % 3 == 0){
                    if(!checker(board, i, i + 2, j, j + 2)) return false;
                }
            }
        }
        return true;
    }
    
    private boolean checker(char[][] x, int is, int ie, int js, int je){
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for(int i = is; i <= ie; i++){
            for(int j = js; j <= je; j++){
                if(x[i][j] != '.'){
                    if(hm.containsKey(x[i][j])) return false;
                    hm.put(x[i][j], 1);
                }
            }
        }
        return true;
    }
    
    private int[] findNextPst(char[][] board, int[] pst){
        int[] newPst = new int[2];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    newPst[0] = i;
                    newPst[1] = j;
                    return newPst;
                }
            }
        }
        newPst[0] = 9;
        return newPst;
    }
}
