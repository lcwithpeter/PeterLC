/*
Source : https://leetcode.com/problems/find-right-interval/
Author : Jiayi Lei
Date   : Nov 12, 2015

Description:
	Given a set of intervals, for each of the interval i, check if there exists 
	an interval j whose start point is bigger than or equal to the end point of 
	the interval i, which can be called that j is on the "right" of i.

	For any interval i, you need to store the minimum interval j's index, which 
	means that the interval j has the minimum start point to build the "right" 
	relationship for interval i. If the interval j doesn't exist, store -1 for 
	the interval i. Finally, you need output the stored value of each interval 
	as an array.

Note:
	You may assume the interval's end point is always bigger than its start point.
	You may assume none of these intervals have the same start point.
Example 1:
	Input: [ [1,2] ]

	Output: [-1]

	Explanation: There is only one interval in the collection, so it outputs -1.
Example 2:
	Input: [ [3,4], [2,3], [1,2] ]

	Output: [-1, 0, 1]

	Explanation: There is no satisfied "right" interval for [3,4].
	For [2,3], the interval [3,4] has minimum-"right" start point;
	For [1,2], the interval [2,3] has minimum-"right" start point.
Example 3:
	Input: [ [1,4], [2,3], [3,4] ]

	Output: [-1, 2, -1]

	Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
	For [2,3], the interval [3,4] has minimum-"right" start point.
*/

// version 1
// 40 ms
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    int[] ret;
    public int[] findRightInterval(Interval[] intervals) {
        if(intervals == null) return ret;
        ret = new int[intervals.length];
        Arrays.fill(ret, -1);
        if(intervals.length < 2) return ret;
        
        Map<Interval, Integer> map = new HashMap();
        Interval[] sorted = new Interval[intervals.length];
        for(int i = 0; i < intervals.length; i++){
            sorted[i] = intervals[i];
            map.put(intervals[i], i);
        }
        Arrays.sort(sorted, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });
        
        for(int i = 0; i < intervals.length; i++){
            int index = binSearch(sorted, intervals[i].end);
            if(index < intervals.length) ret[i] = map.get(sorted[index]);
        }
        
        
        return ret;
    }
    private int binSearch(Interval[] sorted, int target){
        // find equal or greater
        int start = 0, end = sorted.length;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(sorted[mid].start < target) start = mid + 1;
            else if(sorted[mid].start > target) end = mid;
            else return mid;
        }
        return start;
    }
}
