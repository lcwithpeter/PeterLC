/*
Source : https://leetcode.com/problems/zigzag-conversion/
Author : Jiayi Lei
Date   : Jun 18, 2015

Description:
    The string "PAYPALISHIRING" is written in a zigzag pattern on a given 
    number of rows like this: (you may want to display this pattern in a fixed 
    font for better legibility)
        P   A   H   N
        A P L S I I G
        Y   I   R
    And then read line by line: "PAHNAPLSIIGYIR"
    Write the code that will take a string and make this conversion given a 
    number of rows:
        string convert(string text, int nRows);
    convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

Tags: String
*/

// version 1
public class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) sb[i] = new StringBuilder();
        int i = 0;
        while(i < s.length()){
        	for(int index = 0; i < s.length() && index < numRows; index++) 
                sb[index].append(s.charAt(i++));
        	for(int index = numRows - 2; i < s.length() && index > 0; index--) 
                sb[index].append(s.charAt(i++));
        }
        for(int j = 1; j < numRows; j++) sb[0].append(sb[j]);
        return sb[0].toString();
    }
}

// version 2
public class Solution {
    public String convert(String s, int numRows) {
        if(numRows > 1 && s.length() > numRows){
            StringBuilder[] nRow = new StringBuilder[numRows];
            for(int j = 0; j < numRows; j++) nRow[j] = new StringBuilder();
            for(int i = 0; i < s.length();){
                for(int j = 0; i < s.length() && j < numRows - 1; i++, j++)
					nRow[j].append(s.charAt(i));
                for(int j = numRows - 1; i < s.length() && j > 0; i++, j--)
					nRow[j].append(s.charAt(i));
            }
            for(int j = 1; j < numRows; j++) nRow[0].append(nRow[j].toString());
            return nRow[0].toString();
        }
        return s;
    }
}
