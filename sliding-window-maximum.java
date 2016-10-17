/*
Source : https://leetcode.com/problems/sliding-window-maximum/
Author : Jiayi Lei
Date   : Jul 21, 2015

Description:
    Given an array nums, there is a sliding window of size k which is moving 
    from the very left of the array to the very right. You can only see the k 
    numbers in the window. Each time the sliding window moves right by one 
    position.

For example,
    Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

        Window position                Max
        ---------------               -----
        [1  3  -1] -3  5  3  6  7       3
         1 [3  -1  -3] 5  3  6  7       3
         1  3 [-1  -3  5] 3  6  7       5
         1  3  -1 [-3  5  3] 6  7       5
         1  3  -1  -3 [5  3  6] 7       6
         1  3  -1  -3  5 [3  6  7]      7
    Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: 
    You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-
    empty array.

Follow up:
    Could you solve it in linear time?

Hint:
    How about using a data structure such as deque (double-ended queue)?
    The queue size need not be the same as the window’s size.
    Remove redundant elements and the queue should store only elements that 
    need to be considered.
    
Tags: Heap
*/

// solution 1
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return nums;
        int[] result = new int[nums.length - k + 1];
        for(int i = 0; i < result.length; i++){
            result[i] = max(nums, k, i);
        }
        return result;
    }
    private int max(int[] nums, int k, int i){
        if(k == 1) return nums[i];
        else if(k == 2) return Math.max(nums[i], nums[i + 1]);
        else return Math.max(nums[i], max(nums, k - 1, i + 1));
    }
}

// solution 2
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return nums;
        
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> q = new LinkedList<Integer>();
        
        for(int i = 0; i < nums.length; i++){        	
            while(!q.isEmpty() && q.peek() < i - k + 1){
                q.poll();
            }
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]){
            	q.pollLast();
            }
            q.offer(i);
            if(i >= k - 1){
                result[i - k + 1] = nums[q.peek()];
            }
        }
        return result;
    }
}
