/*
Source : https://leetcode.com/problems/reverse-nodes-in-k-group/
Author : Jiayi Lei
Date   : Jun 9, 2015

Description:
    RGiven a linked list, reverse the nodes of a linked list k at a time and 
    return its modified list.
    If the number of nodes is not a multiple of k then left-out nodes in the 
    end should remain as it is.
    You may not alter the values in the nodes, only nodes itself may be 
    changed.
    Only constant memory is allowed.
For example,
    Given this linked list: 1->2->3->4->5
    For k = 2, you should return: 2->1->4->3->5
    For k = 3, you should return: 3->2->1->4->5
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

// version 1
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k < 2) return head;
        ListNode dummyHead = new ListNode(9);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while(true){
            // length check
            ListNode check = prev;
            int len = k;
            while(check.next != null && len > 0){
                len--;
                check = check.next;
            }
            if(len > 0) break;
            
            // reverse
            ListNode left = head;
            ListNode right = head.next;
            while(left != check){
                ListNode temp = right.next;
                right.next = left;
                left = right;
                right = temp;
            }
            
            // works for new head and tail
            prev.next = left;
            head.next = right;
            prev = head;
            head = right;            
        }
        return dummyHead.next;
    }
}

// version 2
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        int count = 0;
        while(cur != null){
            count++;
            ListNode next = cur.next;
            if(count == k){
                prev = reverse(prev, next);
                count = 0;
            }
            cur = next;
        }
        return dummy.next;
    }
    private ListNode reverse(ListNode prev, ListNode end){
        if(prev == null || prev.next == null) return prev;
        ListNode head = prev.next;
        ListNode cur = prev.next.next;
        while(cur != end){
            ListNode next = cur.next;
            cur.next = prev.next;
            prev.next = cur;
            cur = next;
        }
        head.next = end;
        return head;
    }
}
