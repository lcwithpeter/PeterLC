/*
Source : https://leetcode.com/problems/add-two-numbers/
Author : Jiayi Lei
Date   : Jun 8, 2015

Description:
    You are given two linked lists representing two non-negative numbers. The 
    digits are stored in reverse order and each of their nodes contain a single
    digit. Add the two numbers and return it as a linked list.
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Tags: Linked List; Math

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        int sum = 0, add = 0;
        
        while(l1 != null || l2 != null){
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            sum = x + y + add;
            add = sum / 10;
            sum %= 10;
            p.next = new ListNode(sum);
            p = p.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        
        if(add > 0){
            p.next = new ListNode(add);
        }
        
        return dummy.next;
    }
}