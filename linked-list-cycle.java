/*
Source : https://leetcode.com/problems/linked-list-cycle/
Author : Jiayi Lei
Date   : Jun 5, 2015

Description:
    Given a linked list, determine if it has a cycle in it.
    Follow up:
    Can you solve it without using extra space?
Tags: Linked List; Two Pointers
*/


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
 // version 1
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null){
            fast = fast.next;
            if(fast.next == null) return false;
            fast = fast.next;
            slow = slow.next;
            if(slow == fast) return true;
        }
        return false;
    }
}

// version 2
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while(fast != null){
            if(fast == slow) return true;
            if(fast.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}