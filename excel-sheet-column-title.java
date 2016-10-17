/*
Source : https://leetcode.com/problems/excel-sheet-column-title/
Author : Jiayi Lei
Date   : Oct 11, 2015
Description:
    Given a positive integer, return its corresponding column title as appear in
	an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 

Credits:
	Special thanks to @ifanchu for adding this problem and creating all test 
	cases.
	
*/

// version 1
public class Solution {
    public String convertToTitle(int n) {
        if(n > 0){
            StringBuilder sb = new StringBuilder();
            for(int p = 1; n > 0; p++){
                int d = (n % (int)Math.pow(26, p)) / (int)Math.pow(26, p - 1);
                if(d == 0) d = 26;
                sb.append((char)('A' + d - 1));
                n -= d * (int)Math.pow(26, p - 1);
            }
            return sb.reverse().toString();
        }
        return "";
    }
}

// version 2
public class Solution {
    public String convertToTitle(int n) {
        if(n > 0){
            StringBuilder sb = new StringBuilder();
            while(n > 0){
                n--;			// brilliant
                sb.insert(0, (char)(n % 26 + 'A'));
                n /= 26;
            }
            return sb.toString();
        }
        return "";
    }
}
