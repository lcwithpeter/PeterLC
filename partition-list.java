/*
Source : https://leetcode.com/problems/partition-list/
Author : Jiayi Lei
Date   : Jun 8, 2015

Description:
    Given a linked list and a value x, partition it such that all nodes less 
    than x come before nodes greater than or equal to x.
    You should preserve the original relative order of the nodes in each of the
    two partitions.
For example,
    Given  1->4->3->2->5->2 and x = 3,
    return 1->2->2->4->3->5.
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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode lessTail = dummy;
        while(lessTail.next != null){
            if(lessTail.next.val >= x){
                break;
            }
            lessTail = lessTail.next;
        }
        if(lessTail.next == null) return head;
        ListNode p = lessTail.next;
        while(p.next != null){
            if(p.next.val < x){
                ListNode temp = p.next;
                p.next = p.next.next;
                temp.next = lessTail.next;
                lessTail.next = temp;
                lessTail = lessTail.next;
            }else{
                p = p.next;
            }
        }
        return dummy.next;
    }
}
