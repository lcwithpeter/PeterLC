/*
Source : https://leetcode.com/problems/linked-list-random-node/
Author : Jiayi Lei
Date   : Nov 2, 2015

Description:
	Given a singly linked list, return a random node's value from the linked list.
	Each node must have the same probability of being chosen.

Follow up:
	What if the linked list is extremely large and its length is unknown to you?
	Could you solve this efficiently without using extra space?

Example:

	// Init a singly linked list [1,2,3].
	ListNode head = new ListNode(1);
	head.next = new ListNode(2);
	head.next.next = new ListNode(3);
	Solution solution = new Solution(head);

	// getRandom() should return either 1, 2, or 3 randomly. Each element should
	// have equal probability of returning.
	solution.getRandom();

*/

// version 1
// 1 ms
// time: O(n)
// space: O(1)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    ListNode list;
    Random rand;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        list = head;
        rand = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int val = list.val, counter = 0;
        ListNode p = list;
        while(p != null){
            if(rand.nextInt(++counter) == 0) val = p.val;
            p = p.next;
        }
        return val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
