/*
Source : https://leetcode.com/problems/remove-linked-list-elements/
Author : Jiayi Lei
Date   : Jun 8, 2015

Description:
    Remove all elements from a linked list of integers that have value val.
Example
    Given:  1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
    Return: 1 --> 2 --> 3 --> 4 --> 5
Credits:
    Special thanks to @mithmatt for adding this problem and creating all test 
    cases.
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

// iteration solution
// fast, with fake head
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;        
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;        
        while(head != null){
            if(head.val != val){
                p.next = head;
                p = p.next;
            }
            head = head.next;
        }        
        p.next = head;        
        return dummy.next;
    }
}

// recursion solution
// slow, without fake head
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        head.next = removeElements(head.next, val);
        return (head.val == val) ? (head.next) : (head);
    }
}
