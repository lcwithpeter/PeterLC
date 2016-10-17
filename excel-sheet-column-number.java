/*
Source : https://leetcode.com/problems/excel-sheet-column-number/
Author : Jiayi Lei
Date   : Sep 12, 2015
Description:
    Related to question Excel Sheet Column Title (https://leetcode.com/problems/excel-sheet-column-title/)

	Given a column title as appear in an Excel sheet, return its corresponding 
	column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 

Credits:
	Special thanks to @ts for adding this problem and creating all test cases.
*/

public class Solution {
    public int titleToNumber(String s) {
        if(s.length() > 0){
            int sum = 0;
            for(int i = s.length() - 1; i >= 0; i--){
                int n = s.charAt(i) - 'A' + 1;
                sum += n * (int)Math.pow(26, s.length() - i - 1);
            }
            return sum;
        }
        return 0;
    }
}
