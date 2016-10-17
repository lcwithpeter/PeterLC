/*
Source : https://leetcode.com/problems/reverse-linked-list-ii/
Author : Jiayi Lei
Date   : Jun 8, 2015

Description:
    Reverse a linked list from position m to n. Do it in-place and in one-pass.
For example:
    Given 1->2->3->4->5->NULL, m = 2 and n = 4,
    return 1->4->3->2->5->NULL.
Note:
    Given m, n satisfy the following condition:
    1 ≤ m ≤ n ≤ length of list.
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        for(int i = 0; i < m - 1; i++){
            p = p.next;
        }
        ListNode head2 = p;
        p = head2.next;
        ListNode cur = p.next;
        for(int i = m; i < n; i++){
            p.next = cur.next;
            cur.next = head2.next;
            head2.next = cur;
            cur = p.next;
        }
        return dummy.next;
    }
}
