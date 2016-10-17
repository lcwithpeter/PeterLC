/*
Source : https://leetcode.com/problems/palindrome-linked-list/
Author : Jiayi Lei
Date   : Jul 10, 2015

Description:
    Given a singly linked list, determine if it is a palindrome.

Follow up:
    Could you do it in O(n) time and O(1) space?
    
Tags: Array
*/

// solution 1
// Time: O(n); Space: O(n)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode p = head;
        Stack<Integer> st = new Stack<Integer>();
        while(p != null){
            st.push(p.val);
            p = p.next;
        }
        p = head;
        int half = st.size() / 2;
        for(int i = 0; i < half; i++){
            if(p.val != st.pop()) return false;
            p = p.next;
        }
        return true;
    }
}

// solution 2
// Time: O(n); Space: O(1)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        
        // find mid
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
            if(fast.next != null) fast = fast.next;
        }
        
        // reverse second-half
        fast = reverseListNode(slow.next);
        
        // compare
        slow = head;
        while(fast != null){
        	if(fast.val != slow.val) return false;
        	fast = fast.next;
        	slow = slow.next;
        }
        return true;
    }
    private ListNode reverseListNode(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode next = head.next;
		head.next = null;
		while(next != null){
			ListNode temp = next.next;
			next.next = head;
			head = next;
			if(temp != null) next = temp;
			else return next;
		}
		return next;
	}    
}
