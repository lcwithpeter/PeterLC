/*
Source : https://leetcode.com/problems/intersection-of-two-linked-lists/
Author : Jiayi Lei
Date   : Jun 6, 2015

Description:
    Write a program to find the node at which the intersection of two singly 
    linked lists begins.
    For example, the following two linked lists:
    A:          a1 → a2
                       ↘
                         c1 → c2 → c3
                       ↗            
    B:     b1 → b2 → b3
    begin to intersect at node c1.
Notes:
    If the two linked lists have no intersection at all, return null.
    The linked lists must retain their original structure after the function 
    returns.
    You may assume there are no cycles anywhere in the entire linked structure.
    Your code should preferably run in O(n) time and use only O(1) memory.
Credits:
    Special thanks to @stellari for adding this problem and creating all test 
    cases.
Tags: Linked List;
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
 // HashMap method. Time: O(n + m) Space(n)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        HashMap<ListNode, Integer> hm = new HashMap<ListNode, Integer>();
        while(a != null){
            hm.put(a, 1);
            a = a.next;
        }
        while(b != null){
            if(hm.containsKey(b)) return b;
            b = b.next;
        }
        return null;
    }
}

// two pointer solution. Time: O(n + m). Space: O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while(a != null && b != null){
            if(a == b) return a;
            a = a.next;
            b = b.next;
        }
        if(a == null) a = headB;
        else b = headA;
        while(a != null && b != null){
            if(a == b) return a;
            a = a.next;
            b = b.next;
        }
        if(a == null) a = headB;
        else b = headA;
        while(a != b){
            if(a == null || b == null) return null;
            a = a.next;
            b = b.next;
        }
        return a;
    }
}

// a more consice version of two pointers solution
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while(a != null && b != null && a != b){
            a = a.next;
            b = b.next;
            if(a == b) return a;
            if(a == null) a = headB;
            if(b == null) b = headA;
        }
        return a;
    }
}

