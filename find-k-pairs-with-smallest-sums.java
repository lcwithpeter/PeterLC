/*
Source : https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
Author : Jiayi Lei
Date   : Oct 16, 2016
Description:
    You are given two integer arrays nums1 and nums2 sorted in ascending order 
	and an integer k.

	Define a pair (u,v) which consists of one element from the first array and 
	one element from the second array.

	Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:
	Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

	Return: [1,2],[1,4],[1,6]

	The first 3 pairs are returned from the sequence:
	[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:
	Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

	Return: [1,1],[1,1]

	The first 2 pairs are returned from the sequence:
	[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:
	Given nums1 = [1,2], nums2 = [3],  k = 3 

	Return: [1,3],[2,3]

	All possible pairs are returned from the sequence:
	[1,3],[2,3]
Credits:
	Special thanks to @elmirap and @StefanPochmann for adding this problem and 
	creating all test cases.
*/


public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> list = new ArrayList<>();
        if(nums1 == null || nums1.length == 0 ||
        nums2 == null || nums2.length == 0 || k < 1) return list;
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] + a[1] - (b[0] + b[1]);
            }
        });
        for(int i: nums1){
            for(int j: nums2){
                int[] array = {i, j};
                q.offer(array);
            }
        }
        while(!q.isEmpty() && k-- > 0){
            list.add(q.poll());
        }
        return list;
    }
}
