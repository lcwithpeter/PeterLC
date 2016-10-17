/*
Source : https://leetcode.com/problems/reorder-list/
Author : Jiayi Lei
Date   : Jun 9, 2015
Description:
    Given a singly linked list L: L0→L1→…→Ln-1→Ln,
    reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
    You must do this in-place without altering the nodes' values.
For example,
    Given {1,2,3,4}, reorder it to {1,4,2,3}.
Tag: Linked List;
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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        ListNode p = head;
        int len = 0;
        while(p != null){
            len++;
            p = p.next;
        }
        len = len / 2;
        p = head;
        while(len-- > 0){
            p = p.next;
        }
        ListNode head2 = reverse(p.next);
        p.next = null;
        ListNode p1 = head;
        ListNode p2 = head2;
        while(p1 != null && p2 != null){
            ListNode t1 = p1.next;
            ListNode t2 = p2.next;
            p2.next = t1;
            p1.next = p2;
            p1 = t1;
            p2 = t2;
        }
        return;
    }
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
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