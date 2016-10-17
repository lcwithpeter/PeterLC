/*
Source : https://leetcode.com/problems/anagrams/
Author : Jiayi Lei
Date   : Jul 1, 2015

Description:
    Given an array of strings, return all groups of strings that are anagrams.

Note:
    All inputs will be in lower-case.
    
Tags: String; Hash Table
*/

public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> list = new ArrayList<String>();
        if(strs.length > 1){
        	HashMap<String, ArrayList<Integer>> hm = new HashMap<String, ArrayList<Integer>>();
        	for(int i = 0; i < strs.length; i++){
        		char[] temp = strs[i].toCharArray();
        		Arrays.sort(temp);
        		String key = new String(temp);
        		if(!hm.containsKey(key)){
        			hm.put(key, new ArrayList<Integer>());
        		}        			
        		hm.get(key).add(i);
        	}
        	
        	for(Map.Entry<String, ArrayList<Integer>> pair: hm.entrySet()){
        		if(pair.getValue().size() > 1){
        			for(int i: pair.getValue()){
        				list.add(strs[i]);
        			}
        		}
        	}
        }
        return list;
    }
}
