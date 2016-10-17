/*
Source : https://leetcode.com/problems/remove-nth-node-from-end-of-list/
Author : Jiayi Lei
Date   : Jun 6, 2015

Description:
    Given a linked list, remove the nth node from the end of list and return 
    its head.
    For example,
    Given linked list: 1->2->3->4->5, and n = 2.
    After removing the second node from the end, the linked list becomes 
    1->2->3->5.
Note:
    Given n will always be valid.
    Try to do this in one pass.
Tags: Linked List; Two Pointers
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
// version 1
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null) return null;
        ListNode p1 = head;
        ListNode p2 = head;
        while(--n >= 0){
            p2 = p2.next;
        }
        if(p2 == null){
            head = head.next;
            return head;
        }
        while(p2.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return head;
    }
}

// version 2
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // make a ruler
        ListNode pre = dummy;
        ListNode end = head;
        
        // set its length as n
        while(n-- > 1) end = end.next;
        
        // slide it to the end
        while(end.next != null){
            pre = pre.next;
            end = end.next;
        }
        
        // delete node
        pre.next = pre.next.next;
        
        return dummy.next;
    }
}
