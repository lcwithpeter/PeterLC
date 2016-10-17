/*
Source : https://leetcode.com/problems/valid-sudoku/
Author : Jiayi Lei
Date   : Jun 5, 2015

Description:
    Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
    The Sudoku board could be partially filled, where empty cells are filled 
    with the character '.'
    A partially filled sudoku which is valid.
Note:
    A valid Sudoku board (partially filled) is not necessarily solvable. Only 
    the filled cells need to be validated.
Tags:
    Hash Table
*/

// version 1
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length != 9) return false;
        for(int i = 0; i < 9; i++){
            if(board[i].length != 9) return false;
            // rowCheck
            if(!hmCheck(board, i, i, 0, 8)) return false;
            // colCheck
            if(!hmCheck(board, 0, 8, i, i)) return false;
            for(int j = 0; j < 9; j++){
                if(i % 3 == 0 && j % 3 == 0){
                    // boxCheck
                    if(!hmCheck(board, i, i + 2, j, j + 2)) return false;
                }
            }
        }
        return true;
    }
    
    public boolean hmCheck(char[][] board, int is, int ie, int js, int je){
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for(int i = is; i <= ie; i++){
            for(int j = js; j <= je; j++){
                if(hm.containsKey(board[i][j]) && board[i][j] != '.') 
                    return false;
                hm.put(board[i][j], 1);
            }
        }
        return true;
    }
}

// version 2
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            // row check
            if(!helper(board, i, i, 0, 8)) return false;
            
            // column check
            if(!helper(board, 0, 8, i, i)) return false;
            
            // box check
            if(i % 3 == 0){
                for(int j = 0; j < 3; j++){
                    if(!helper(board, i, i + 2, 3 * j, 3 * j + 2))
                        return false;
                }
            }
        }
        return true;
    }
    private boolean helper(char[][] board, int xs, int xe, int ys, int ye){
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = xs; i <= xe; i++){
            for(int j = ys; j <= ye; j++){
                if(board[i][j] != '.' && map.containsKey(board[i][j]))
					return false;
                map.put(board[i][j], 1);
            }
        }
        return true;
    }
}
