/*
Source : https://leetcode.com/problems/search-a-2d-matrix-ii/
Author : Jiayi Lei
Date   : Jun 23, 2015

Description:
    Given a string of numbers and operators, return all possible results from 
    computing all the different possible ways to group numbers and operators. 
    The valid operators are +, - and *.

Example 1
    Input: "2-1-1".

    ((2-1)-1) = 0
    (2-(1-1)) = 2
    Output: [0, 2]

Example 2
    Input: "2*3-4*5"

    (2*(3-(4*5))) = -34
    ((2*3)-(4*5)) = -14
    ((2*(3-4))*5) = -10
    (2*((3-4)*5)) = -10
    (((2*3)-4)*5) = 10
    Output: [-34, -14, -10, -10, 10]

Credits:
    Special thanks to @mithmatt for adding this problem and creating all test 
    cases.
    
Tags: 
*/

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ret = new ArrayList<Integer>();
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '+' ||
            input.charAt(i) == '-' ||
            input.charAt(i) == '*'){
                String left = input.substring(0, i);
                String right = input.substring(i + 1);
                List<Integer> leftRes = diffWaysToCompute(left);
                List<Integer> rightRes = diffWaysToCompute(right);
                for(Integer l : leftRes){
                    for(Integer r : rightRes){
                        if(input.charAt(i) == '+') ret.add(l + r);
                        else if(input.charAt(i) == '-') ret.add(l - r);
                        else if(input.charAt(i) == '*') ret.add(l * r);
                    }
                }
            }
        }
        if(ret.isEmpty()) ret.add(Integer.valueOf(input));
        return ret;
    }
}
