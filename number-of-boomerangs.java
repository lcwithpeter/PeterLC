/*
Source : https://leetcode.com/problems/number-of-boomerangs/
Author : Jiayi Lei
Date   : Nov 12, 2015

Description:
	Given n points in the plane that are all pairwise distinct, a "boomerang" is
	a tuple of points (i, j, k) such that the distance between i and j equals the
	distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and 
coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:
	Input:
	[[0,0],[1,0],[2,0]]

	Output:
	2

	Explanation:
	The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
*/

// version 1
// 294 ms
public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if(points == null || points.length == 0 || points[0].length != 2) return 0;
        
        int ans = 0;
        for(int i = 0; i < points.length; i++){
            Map<Double, Integer> map = new HashMap();
            for(int j = 0; j < points.length; j++){
                if(j == i) continue;
                double distance = Math.sqrt(Math.pow(points[i][0] - points[j][0], 2) +
                    Math.pow(points[i][1] - points[j][1], 2));
                if(!map.containsKey(distance)){
                    map.put(distance, 0);
                }
                map.put(distance, map.get(distance) + 1);
            }

            for(Double key : map.keySet()){
                int value = map.get(key);
                if(value <= 1) continue;
                ans += value * (value - 1);
            }
        }

        return ans;
    }
}
