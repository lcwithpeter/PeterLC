/*
Source : https://leetcode.com/problems/swap-nodes-in-pairs/
Author : Jiayi Lei
Date   : Jun 6, 2015

Description:
    Given a linked list, swap every two adjacent nodes and return its head.
    For example,
    Given 1->2->3->4, you should return the list as 2->1->4->3.
    Your algorithm should use only constant space. You may not modify the 
    values in the list, only nodes itself can be changed.
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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        head.next.next = swapPairs(head.next.next);
        ListNode newHead = head.next;
        head.next = head.next.next;
        newHead.next = head;
        return newHead;
    }
}
