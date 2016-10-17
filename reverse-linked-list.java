/*
Source : https://leetcode.com/problems/reverse-linked-list/
Author : Jiayi Lei
Date   : Jun 6, 2015

Description:
    Reverse a singly linked list.
Hint:
    A linked list can be reversed either iteratively or recursively. Could you 
    implement both?
Tags: Linked List;
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 // recursion solution 1
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode next = head.next;
        head.next = null;
        
        return reversive(head, next);
    }
    private ListNode reversive(ListNode head, ListNode next){
        if(next == null) return head;
        ListNode temp = next.next;
        next.next = head;
        
        return reversive(next, temp);
    }
}

// recursion solution 2
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode sec = head.next;
        head.next = null;
        
        ListNode rest = reverseList(sec);
        sec.next = head;
        
        return rest;
    }
}

// iteration solution
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = null;
        while(next != null){
            ListNode temp = next.next;
            next.next = head;
            head = next;
            next = temp;
        }
        return head;
    }
}

/* not very sure what this code is about
// another iteration solution with a previous pointer and an end pointer (both 
// exclusive)
public class Solution {
	public ListNode reverseList2(ListNode pre, ListNode end){
	    if(pre == null || pre.next == null) return pre;
	    ListNode head = pre.next;
	    ListNode cur = pre.next.next;
	    while(cur != end){
	    	ListNode next = cur.next;
	    	cur.next = pre.next;
	    	pre.next = cur;
	    	cur = next;
	    }
	    head.next = end;
	    return head;
	}
}
*/
