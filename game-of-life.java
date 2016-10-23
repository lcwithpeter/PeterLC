/*
Source : https://leetcode.com/problems/game-of-life/
Author : Jiayi Lei
Date   : Oct 16, 2016
Description:
    According to the Wikipedia's article: "The Game of Life, also known simply 
	as Life, is a cellular automaton devised by the British mathematician John 
	Horton Conway in 1970."

	Given a board with m by n cells, each cell has an initial state live (1) or 
	dead (0). Each cell interacts with its eight neighbors (horizontal, vertical,
	diagonal) using the following four rules (taken from the above Wikipedia 
	article):

	Any live cell with fewer than two live neighbors dies, as if caused by under
	-population.
	Any live cell with two or three live neighbors lives on to the next 
	generation.
	Any live cell with more than three live neighbors dies, as if by over
	-population..
	Any dead cell with exactly three live neighbors becomes a live cell, as if 
	by reproduction.
	Write a function to compute the next state (after one update) of the board 
	given its current state.

Follow up: 
	Could you solve it in-place? Remember that the board needs to be updated at 
	the same time: You cannot update some cells first and then use their updated
	values to update other cells.
	In this question, we represent the board using a 2D array. In principle, the
	board is infinite, which would cause problems when the active area 
	encroaches the border of the array. How would you address these problems?
	
Credits:
	Special thanks to @jianchao.li.fighter for adding this problem and creating 
	all test cases.
*/

public class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length < 1 || board[0].length < 1) return;
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				board[i][j] = counter(board, i, j);
			}
		}
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				board[i][j] = decoder(board[i][j]);
			}
		}
    }
	private int counter(int[][] b, int x, int y){
		int count = 0;
		for(int i = -1; i <= 1; i++){
			if(x + i < 0 || x + i >= b.length) continue;
			for(int j = -1; j <= 1; j++){
				if(y + j < 0 || y + j >= b[0].length) continue;
				if(i == 0 && j == 0) continue;				
				if(b[x + i][y + j] == 1 ||
				b[x + i][y + j] == 4 ||
				b[x + i][y + j] == 5) count++;
			}
		}
		return encoder(b[x][y], count);
	}
	private int encoder(int o, int n){
		if(o == 0){
			if(n == 3) return 3;
			else return 2;
		} else {
			if(n == 2 || n == 3) return 5;
			else return 4;
		}
	}
	private int decoder(int n){
		if(n == 2 || n == 4) return 0;
		return 1;
	}
}
