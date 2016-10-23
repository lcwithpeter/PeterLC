/*
Source : https://leetcode.com/problems/russian-doll-envelopes/
Author : Jiayi Lei
Date   : Oct 22, 2015

Description:
    You have a number of envelopes with widths and heights given as a pair of 
	integers (w, h). One envelope can fit into another if and only if both the 
	width and height of one envelope is greater than the width and height of the
	other envelope.

	What is the maximum number of envelopes can you Russian doll? (put one 
	inside other)

Example:
	Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes
	you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
Tags: Binary Search; Dynamic Programming

*/

// version 1
public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0 ||
		envelopes[0].length != 2) return 0;
		
		Arrays.sort(envelopes, new Comparator<int[]>(){
		    public int compare(int[] a, int[] b){
		        return a[0] + a[1] - (b[0] + b[1]);
		    }
		});
		
		Map<Integer, List<int[]>> map = new HashMap<>();
		int[] dp = new int[envelopes.length];
		dp[0] = 1;
		int max = 1;
		map.put(1, new ArrayList<int[]>());
		map.get(1).add(envelopes[0]);
		for(int i = 0; i < envelopes.length; i++){
			dp[i] = 1;
			search:
			for(int j = max; j >= 0; j--){
				if(j == 0){
					map.get(1).add(envelopes[i]);
					break search;
				}
				List<int[]> cur = map.get(j);
				if(cur == null) continue;
				for(int k = cur.size() - 1; k >= 0; k--){
					int[] array = cur.get(k);
					if(array[0] < envelopes[i][0] && array[1] < envelopes[i][1]){
						if(!map.containsKey(j + 1)){
							map.put(j + 1, new ArrayList<int[]>());
						}
						map.get(j + 1).add(envelopes[i]);
						max = Math.max(max, j + 1);
						dp[i] = Math.max(dp[i], j + 1);
						break search;
					}
				}
			}
		}
		
		return max;
    }
}

// version 2: 
public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0 ||
        envelopes[0] == null || envelopes[0].length != 2) return 0;
        
        /*
		Sort the array. Ascend on width and descend on height if width are same.
		For [[2, 2], [2, 3]], since they have same width, no matter what height
		is, they won't fit each other.
		*/
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]) return b[1] - a[1];
                else return a[0] - b[0];
            }
        });
        
        // Find the longest increasing subsequence based on height.
        int[] dp = new int[envelopes.length];
        int size = 0;
        for(int[] env: envelopes){
            int start = 0, end = size;
            while(start < end){
                int mid = start + (end - start) / 2;
                if(dp[mid] < env[1]) start = mid + 1;
                else end = mid;
            }
            dp[start] = env[1];
            if(start == size) size++;
        }
        
        return size;
    }
}

