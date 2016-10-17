/*
Source : https://leetcode.com/problems/remove-duplicates-from-sorted-list/
Author : Jiayi Lei
Date   : Jun 5, 2015

Description:
    Given a sorted linked list, delete all duplicates such that each element 
    appear only once.
For example,
    Given 1->1->2, return 1->2.
    Given 1->1->2->3->3, return 1->2->3.
Tags: Linked List
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// solution 1
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pointer = head;
        while(pointer.next != null){
            if(pointer.val == pointer.next.val)
				pointer.next = pointer.next.next;
            else
				pointer = pointer.next;
        }
        return head;
    }
}

// solution 2
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head != null && head.next != null){
            ListNode cur = head;
            ListNode next = head.next;
            while(next != null){
                if(next.val != cur.val){
                    cur.next = next;
                    cur = cur.next;
                }
                next = next.next;
            }
            cur.next = next;
        }
        return head;
    }
}
