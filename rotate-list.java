/*
Source : https://leetcode.com/problems/rotate-list/
Author : Jiayi Lei
Date   : Jun 8, 2015

Description:
    Given a list, rotate the list to the right by k places, where k is non-
    negative.
For example:
    Given  1->2->3->4->5->NULL and k = 2,
    return 4->5->1->2->3->NULL.
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
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode p = head;
        int len = 0;
        while(p != null){
            p = p.next;
            len++;
        }        
        k = k % len;
        if(k == 0) return head;
        ListNode prev = head;
        ListNode cur = head;
        while(k-- > 0){
            cur = cur.next;
        }
        while(cur.next != null){
            prev = prev.next;
            cur = cur.next;
        }
        dummy.next = prev.next;
        prev.next = null;
        cur.next = head;
        return dummy.next;
    }
}
