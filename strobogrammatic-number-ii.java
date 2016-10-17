/*
Source : https://leetcode.com/problems/strobogrammatic-number-ii/
Author : Jiayi Lei
Date   : Aug 17, 2015

Description:
    A strobogrammatic number is a number that looks the same when rotated 180 
	degrees (looked at upside down).
	Find all strobogrammatic numbers that are of length = n.

For example,
	Given n = 2
	return ["11","69","88","96"].

Hint:
	Try to use recursion and notice that it should recurse with n - 2 instead of
	n - 1.
	
Tags:
	Math; Recursion

Similar Problems:
	https://leetcode.com/problems/strobogrammatic-number/
	https://leetcode.com/problems/strobogrammatic-number-iii/
*/

public class Solution {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }
    
    private List<String> helper(int n, int m){
        if(n == 0) return new LinkedList<String>(Arrays.asList(""));
        if(n == 1) return new LinkedList<String>(Arrays.asList("0", "1", "8"));
        
        List<String> list = helper(n - 2, m);
        
        List<String> res = new LinkedList<String>();
        
        for(int i = 0; i < list.size(); i++){
            String cur = list.get(i);
            
            if(n != m) res.add("0" + cur + "0");
            
            res.add("1" + cur + "1");
            res.add("6" + cur + "9");
            res.add("8" + cur + "8");
            res.add("9" + cur + "6");
        }
        
        return res;
    }
}
