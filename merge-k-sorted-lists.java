/*
Source : https://leetcode.com/problems/merge-k-sorted-lists/
Author : Jiayi Lei
Date   : Jun 11, 2015

Description:
    Merge k sorted linked lists and return it as one sorted list. Analyze and 
	describe its complexity.
    
Tags: 
	Divide and Conquer; Linked List; Heap;

Similar Problems:
	https://leetcode.com/problems/merge-two-sorted-lists/
	https://leetcode.com/problems/ugly-number-ii/
*/

/*
version 1: implemented with PriorityQueue
time complexity: O(n log k), n: total number of nodes, k: number of lists in 
array.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        if(lists.length == 2) return mergeTwoLists(lists[0], lists[1]);
        return helper(lists, 0, lists.length - 1);
    }
    private ListNode helper(ListNode[] lists, int start, int end){
        int mid = start + (end - start) / 2;
        if(start > end) return null;
        else if(start == end) return lists[start];
        else return mergeTwoLists(helper(lists, start, mid),
                                helper(lists, mid + 1, end));
    }
    private ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummyHead = new ListNode(1);
        ListNode p = dummyHead;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1 == null) p.next = l2;
        if(l2 == null) p.next = l1;
        return dummyHead.next;
    }
}

/*
version 2: implemented without PriorityQueue, using tree-building-like structure
by calling mergeTwoLists().
time complexity: O(n log k), n: total number of nodes, k: number of lists in 
array.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return helper(lists, 0, lists.length - 1);
    }
    private ListNode helper(ListNode[] lists, int start, int end){
		if(start > end) return null;
		if(start == end) return lists[start];
		int mid = start + (end - start) / 2;
		return mergeTwoLists(helper(lists, start, mid), 
							helper(lists, mid + 1, end));
    }
    private ListNode mergeTwoLists(ListNode a, ListNode b){
        if(b == null) return a;
        if(a == null) return b;
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		while(a != null && b != null){
			if(a.val < b.val){
				p.next = a;
				a = a.next;
			}else{
				p.next = b;
				b = b.next;
			}
			p = p.next;
		}
		if(a == null) p.next = b;
		else p.next = a;
		return dummy.next;
    }
}
