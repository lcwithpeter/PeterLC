/*
Source : https://leetcode.com/problems/restore-ip-addresses/
Author : Jiayi Lei
Date   : Jul 1, 2015

Description:
    Given a string containing only digits, restore it by returning all possible
    valid IP address combinations.

For example:
    Given "25525511135",
    return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
    
Tags: String; Backtracking
*/

public class Solution {
    public List<String> restoreIpAddresses(String s) {
		List<String> list = new ArrayList<String>();
		if(s.length() >= 4){
			split(list, 4, s, "");
		}
		return list;
    }
	
	private void split(List<String> list, int index, String s, String cur){
		if(index == 1){
			if(s.length() > 3) return;
			else{
				cur += s;
				if(isGood(cur)) list.add(cur);
			}
		}else{
			for(int i = 1; i <= 3; i++){
				if(i >= s.length()) return;
				split(list, index - 1, s.substring(i), cur + s.substring(0, i) + ".");
			}
		}		
	}
	
	private boolean isGood(String cur){		
		for(String seg : cur.split("\\.")){
		    if(seg.length() > 1 && seg.charAt(0) == '0') return false;
			int sum = 0;
			for(int i = 0; i < seg.length(); i++){
				sum *= 10;
				sum += seg.charAt(i) - '0';				
			}
			if(sum > 255) return false;
		}		
		return true;
	}
}
