/*
Source : https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
Author : Jiayi Lei
Date   : Nov 12, 2015

Description:
	There are a number of spherical balloons spread in two-dimensional space. 
	For each balloon, provided input is the start and end coordinates of the 
	horizontal diameter. Since it's horizontal, y-coordinates don't matter and 
	hence the x-coordinates of start and end of the diameter suffice. Start is 
	always smaller than end. There will be at most 104 balloons.

	An arrow can be shot up exactly vertically from different points along the 
	x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart
	≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An 
	arrow once shot keeps travelling up infinitely. The problem is to find the 
	minimum number of arrows that must be shot to burst all balloons.

Example:

	Input:
	[[10,16], [2,8], [1,6], [7,12]]

	Output:
	2

	Explanation:
	One way is to shoot one arrow for example at x = 6 (bursting the balloons 
	[2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).
*/

// version 1
// 48 ms
public class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0) return 0;
        
        PriorityQueue<Interval> heap = new PriorityQueue(new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.end - b.end;
            }
        });
        
        for(int[] balloon: points){
            heap.offer(new Interval(balloon[0], balloon[1]));
        }
        
        int shot = 1;
        int arrow = heap.poll().end;
        
        while(!heap.isEmpty()){
            Interval temp = heap.poll();
            if(temp.start > arrow){
                arrow = temp.end;
                shot++;
            }
        }
        
        return shot;
    }
}

class Interval{
    int start;
    int end;
    public Interval(int a, int b){
        start = a;
        end = b;
    }
}
