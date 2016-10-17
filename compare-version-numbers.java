/*
Source : https://leetcode.com/problems/compare-version-numbers/
Author : Jiayi Lei
Date   : Jun 19, 2015

Description:
    Compare two version numbers version1 and version2.
    If version1 > version2 return 1, if version1 < version2 return -1, 
    otherwise return 0.
    You may assume that the version strings are non-empty and contain only 
    digits and the . character. The . character does not represent a decimal 
    point and is used to separate number sequences. For instance, 2.5 is not 
    "two and a half" or "half way to version three", it is the fifth second-
    level revision of the second first-level revision.

Here is an example of version numbers ordering:
    0.1 < 1.1 < 1.2 < 13.37
Credits:
    Special thanks to @ts for adding this problem and creating all test cases.

Tags: String
*/

// version 1
public class Solution {
    public int compareVersion(String version1, String version2) {
        if(version1.length() == 0 && version2.length() == 0) return 0;
        ArrayList<Integer> v1 = getNum(version1);
        ArrayList<Integer> v2 = getNum(version2);
        int i = 0;
        int minLen = (v1.size() < v2.size()) ? v1.size() : v2.size();
        int maxLen = (v1.size() < v2.size()) ? v2.size() : v1.size();
        for(; i < minLen; i++){
            if(v1.get(i) > v2.get(i)) return 1;
            if(v1.get(i) < v2.get(i)) return -1;
        }
        if(v1.size() == v2.size()) return 0;
        int sum = 0;
        if(i < v1.size()){
            for(; i < maxLen; i++){
                sum += v1.get(i);
            }
            if(sum > 0) return 1;
            return 0;
        }
        if(i < v2.size()){
            for(; i < maxLen; i++){
                sum += v2.get(i);
            }
            if(sum > 0) return -1;
            return 0;
        }
        return 0;
    }
    private ArrayList<Integer> getNum(String s){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (String retval: s.split("\\.")){
			int sum = 0;
			for(int i = 0; i < retval.length(); i++){
				 sum = sum * 10 + retval.charAt(i) - '0';
			}
			list.add(sum);
		}
		return list;
    }
}

// version 2
public class Solution {
    public int compareVersion(String version1, String version2) {
        if(version1.length() > 0 && version2.length() > 0){
            String[] v1 = version1.split("\\.");
            String[] v2 = version2.split("\\.");
            int i = 0, j = 0;
            for(;i < v1.length && j < v2.length; i++, j++){
                if(Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])) return -1;
                if(Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) return 1;
            }
            for(; i < v1.length; i++){
                if(Integer.parseInt(v1[i]) > 0) return 1;
            }
            for(; j < v2.length; j++){
                if(Integer.parseInt(v2[j]) > 0) return -1;
            }
        }
        return 0;
    }
}
