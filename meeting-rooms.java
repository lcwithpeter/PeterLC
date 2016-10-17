/*
Source : https://leetcode.com/problems/meeting-rooms/
Author : Jiayi Lei
Date   : Aug 17, 2015

Description:
    Given an array of meeting time intervals consisting of start and end times 
	[[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all 
	meetings.

For example,
	Given [[0, 30],[5, 10],[15, 20]],
	return false.
	
Tags:
	Sort

Similar Problems:
	https://leetcode.com/problems/merge-intervals/
	https://leetcode.com/problems/meeting-rooms-ii/
*/

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
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals.length <= 1) return true;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                // the return value of compare():
                // 		if 1st is smaller than 2nd, return a negative value
                // 		return 0 if they are equal
                // 		otherwise return a positive value
                return i1.start - i2.start;	// ascending order
            }
        });
        for(int i = 0; i < intervals.length - 1; i++){
            if(intervals[i].end > intervals[i + 1].start) return false;
        }
        return true;
    }
}
