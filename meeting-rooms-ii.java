/*
Source : https://leetcode.com/problems/meeting-rooms-ii/
Author : Jiayi Lei
Date   : Aug 17, 2015

Description:
    Given an array of meeting time intervals consisting of start and end times 
	[[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms
	required.

For example,
	Given [[0, 30],[5, 10],[15, 20]],
	return 2.
	
Tags:
	Sort

Similar Problems:
	https://leetcode.com/problems/merge-intervals/
	https://leetcode.com/problems/meeting-rooms/
*/

// solution 1
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
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length <= 1) return intervals.length;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        List<List<Interval>> list = new LinkedList<List<Interval>>();
        for(int i = 0; i < intervals.length; i++){
            int index = findNextNonOverlappingIndex(list, intervals[i]);
            if(index == -1){
                List<Interval> subList = new LinkedList<Interval>();
                subList.add(intervals[i]);
                list.add(subList);
            }else{
                list.get(index).add(intervals[i]);
            }
        }
        return list.size();
    }
    private int findNextNonOverlappingIndex(List<List<Interval>> list,
        Interval interval){
        int index = -1;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).get(list.get(i).size() - 1).end <= interval.start)
                return i;
        }
        return index;
    }
}

// solution 2
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
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length <= 1) return intervals.length;
        
        // sort the interval[] by start time
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        
        // initialize a list storing end time of current meeting room
        List<Integer> list = new LinkedList<Integer>();
        
        // for each intervals in Interval[], grouping them
        for(int i = 0; i < intervals.length; i++){
            int index = findAMeetingRoom(list, intervals[i]);
            if(index == -1){
                // if no room was found, add a new one
                list.add(intervals[i].end);
            }else{
                // if an appropriate room was found, update the end time
                list.set(index, intervals[i].end);
            }
        }
        return list.size();
    }
    private int findAMeetingRoom(List<Integer> list, Interval interval){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) <= interval.start)
                return i;
        }
        return -1;
    }
}

// solution 3
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
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length <= 1) return intervals.length;
        
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });
        
        List<Integer> list = new ArrayList<Integer>();
        list.add(intervals[0].end);
        
        int index = 1;
        int numberOfRooms = 1;
        while(index < intervals.length){
            boolean setFlag = false;
            for(int i = 0; i < list.size(); i++){
                // can use current available room
                if(intervals[index].start >= list.get(i)){
                    list.set(i, intervals[index].end);
                    setFlag = true;
                    break;
                }
            }
            // need another room
            if(!setFlag){
                list.add(intervals[index].end);
                numberOfRooms++;
            }
            index++;
        }
        
        return numberOfRooms;
    }
}

// heap solution with O(n log n)
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
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null) return 0;
        if(intervals.length <= 1) return intervals.length;
        
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });
        
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(
            new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return a - b;
            }
        });
        
        heap.offer(intervals[0].end);
		
        for(int i = 1; i < intervals.length; i++){
            int curMin = heap.poll();
            
            if(intervals[i].start >= curMin){
                curMin = intervals[i].end;
            }else{
                heap.offer(intervals[i].end);
            }
            heap.offer(curMin);
        }
        
        return heap.size();
    }
}
