/*
Source : https://leetcode.com/problems/sort-list/
Author : Jiayi Lei
Date   : Jun 11, 2015

Description:
    Sort a linked list in O(n log n) time using constant space complexity.
Tags: Linked List; Sort
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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        return mergeSort(head);
    }
    private ListNode mergeSort(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next != null && runner.next.next != null){
            walker = walker.next;
            runner = runner.next.next;
        }
        ListNode head1 = head;
        ListNode head2 = walker.next;
        walker.next = null;
        head1 = mergeSort(head1);
        head2 = mergeSort(head2);
        return merge(head1, head2);
    }
    private ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(0);
        dummy.next = head1;
        ListNode p = dummy;
        while(head1 != null && head2 != null){
            if(head1.val < head2.val) head1 = head1.next;
            else{
                ListNode next = head2.next;
                head2.next = p.next;
                p.next = head2;
                head2 = next;
            }
            p = p.next;
        }
        if(head2 != null) p.next = head2;
        return dummy.next;
    }
}
