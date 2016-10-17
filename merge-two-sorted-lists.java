/*
Source : https://leetcode.com/problems/merge-two-sorted-lists/
Author : Jiayi Lei
Date   : Jun 5, 2015

Description:
    Merge two sorted linked lists and return it as a new list. The new list 
    should be made by splicing together the nodes of the first two lists.
Tags: Linked List
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return l1;
        else if(l1 == null && l2 != null) return l2;
        else if(l1 != null && l2 == null) return l1;
        else{
            ListNode n = new ListNode(0);
            ListNode np = n;
            
            while(l1 != null && l2 != null){
                int v1 = l1.val;
                int v2 = l2.val;
                if(v1 < v2){
                    np.next = l1;
                    l1 = l1.next;
                }else{
                    np.next = l2;
                    l2 = l2.next;
                }
                np = np.next;
            }
            if(l1 != null) np.next = l1;
            else if(l2 != null) np.next = l2;
            
            return n.next;
        }
    }
}
