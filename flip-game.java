/*
Source : https://leetcode.com/problems/flip-game/
Author : Jiayi Lei
Date   : Oct 17, 2015
Description:
    You are playing the following Flip Game with your friend: Given a string 
	that contains only these two characters: + and -, you and your friend take 
	turns to flip two consecutive "++" into "--". The game ends when a person 
	can no longer make a move and therefore the other person will be the winner.

	Write a function to compute all possible states of the string after one 
	valid move.

For example:
    given s = "++++", after one move, it may become one of the following states:

        [
          "--++",
          "+--+",
          "++--"
        ]

    If there is no valid move, return an empty list [].

Tags:
	
*/

public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> list = new LinkedList<String>();
        if(s.length() > 1){
            for(int i = 0; i < s.length() - 1; i++){
                if(s.substring(i, i + 2).equals("++")){
                    list.add(s.substring(0, i) + "--" + s.substring(i + 2));
                }
            }
        }
        return list;
    }
}
