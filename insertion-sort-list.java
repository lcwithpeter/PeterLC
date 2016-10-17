/*
Source : https://leetcode.com/problems/insertion-sort-list/
Author : Jiayi Lei
Date   : Jun 8, 2015

Description:
    Sort a linked list using insertion sort.
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
// solution 1
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        while(head != null){
            insert(dummy, head.val);
            head = head.next;
        }
        return dummy.next;
    }
    private void insert(ListNode list, int val){
        ListNode prev = list;
        ListNode cur = list.next;
        while(cur != null && cur.val < val){
            prev = cur;
            cur = cur.next;
        }
        if(cur == null){
            prev.next = new ListNode(val);
        }else{
            prev.next = new ListNode(val);
            prev.next.next = cur;
        }
    }
}

// solution 2
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(-1);
        ListNode d = dummy;
        d.next = head;
        ListNode temp = head.next;
        head.next = null;
        head = temp;
        while(head != null){
            d = dummy;
            temp = head.next;
            while(d.next != null && head.val > d.next.val)
                d = d.next;
            head.next = d.next;
            d.next = head;
            
            head = temp;
        }
        return dummy.next;
    }    
}
