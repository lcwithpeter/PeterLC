/*
Source : https://leetcode.com/problems/shortest-word-distance/
Author : Jiayi Lei
Date   : Aug 18, 2015

Description:
    Given a list of words and two words word1 and word2, return the shortest 
	distance between these two words in the list.

For example,
	Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

	Given word1 = “coding”, word2 = “practice”, return 3.
	Given word1 = "makes", word2 = "coding", return 1.

Note:
	You may assume that word1 does not equal to word2, and word1 and word2 are 
	both in the list.
	
Tags:
	Array
	
Similar Problems:
	https://leetcode.com/problems/shortest-word-distance-ii/
	https://leetcode.com/problems/shortest-word-distance-iii/
*/

// solution 1
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
        for(int i = 0; i < words.length; i++){
        	if(words[i].equals(word1)) list1.add(i);
        	else if(words[i].equals(word2)) list2.add(i);
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < list2.size(); i++){
        	min = Math.min(min, helper1(list1, list2.get(i)));
        }
        
        return min;
    }	
	private int helper1(ArrayList<Integer> list, int cur) {
		if(list.size() > 0){
			int start = 0, end = list.size() - 1;
			while(start <= end){
				int mid = start + (end - start) / 2;
				if(cur < list.get(mid)) end = mid - 1;
				else if(cur > list.get(mid)) start = mid + 1;
			}
			if(end == -1) return list.get(0) - cur;
			else if(start == list.size()) 
				return cur - list.get(list.size() - 1);
			else return Math.min(cur - list.get(end), list.get(start) - cur);
		}
		
		return -1;
	}
}

// solution 2
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        for(int i = 0; i < words.length; i++){
            String cur = words[i];
            if(cur.equals(word1)) list1.add(i);
            else if(cur.equals(word2)) list2.add(i);
        }
        
        int min = Integer.MAX_VALUE;
        for(Integer i : list1){
            int curMin = Math.abs(i - list2.get(0));
            for(int j = 1; j < list2.size(); j++){
                int diff = Math.abs(i - list2.get(j));
                if(diff < curMin) curMin = diff;
                else break;
            }
            if(curMin == 1) return 1;
            min = Math.min(min, curMin);
        }
        return min;
    }
}

// solution 2
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        int w1 = -1, w2 = -1;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1)) w1 = i;
            if(words[i].equals(word2)) w2 = i;
            if(w1 != -1 && w2 != -1) min = Math.min(min, Math.abs(w1 - w2));
        }
        return min;
    }
}
