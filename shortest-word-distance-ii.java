/*
Source : https://leetcode.com/problems/shortest-word-distance-ii/
Author : Jiayi Lei
Date   : Aug 20, 2015

Description:
    This is a follow up of Shortest Word Distance. The only difference is now 
	you are given the list of words and your method will be called repeatedly 
	many times with different parameters. How would you optimize it?

	Design a class which receives a list of words in the constructor, and 
	implements a method that takes two words word1 and word2 and return the 
	shortest distance between these two words in the list.

For example,
	Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

	Given word1 = “coding”, word2 = “practice”, return 3.
	Given word1 = "makes", word2 = "coding", return 1.

Note:
	You may assume that word1 does not equal to word2, and word1 and word2 are 
	both in the list.
	
Tags:
	HashTable; Data Structure
	
Similar Problems:
	https://leetcode.com/problems/merge-two-sorted-lists/
	https://leetcode.com/problems/shortest-word-distance/
	https://leetcode.com/problems/shortest-word-distance-iii/
*/

public class WordDistance {
    
    Map<String, List<Integer>> map;
    
    public WordDistance(String[] words) {
        map = new HashMap<String, List<Integer>>();
        for(int i = 0; i < words.length; i++){
            if(map.containsKey(words[i])){
                map.get(words[i]).add(i);
            }else{
                List<Integer> temp = new LinkedList<Integer>();
                temp.add(i);
                map.put(words[i], temp);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        for(int i = 0, j = 0; i < list1.size() && j < list2.size();){
            min = Math.min(min, Math.abs(list1.get(i) - list2.get(j)));
            if(list1.get(i) < list2.get(j)) i++;
            else j++;
        }
        return min;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");
