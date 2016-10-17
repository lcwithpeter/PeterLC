/*
Source : https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
Author : Jiayi Lei
Date   : Jun 8, 2015

Description:
    Given a sorted linked list, delete all nodes that have duplicate numbers, 
    leaving only distinct numbers from the original list.
For example,
    Given 1->2->3->3->4->4->5, return 1->2->5.
    Given 1->1->1->2->3, return 2->3.
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
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while(head != null){
            if(head.next == null){
                p.next = new ListNode(head.val);
                p = p.next;
                head = head.next;
            }else if(head.val == head.next.val){
                ListNode prev = head;
                ListNode cur = head.next;
                while(cur != null && prev.val == cur.val){
                    cur = cur.next;
                }
                if(cur == null) head = null;
                else head = cur;
            }else{
                p.next = new ListNode(head.val);
                p = p.next;
                head = head.next;
            }
        }
        return dummy.next;
    }
}
