/*
Source : https://leetcode.com/problems/delete-node-in-a-linked-list/
Author : Jiayi Lei
Date   : Jul 19, 2015

Description:
    Write a function to delete a node (except the tail) in a singly linked list
    , given only access to that node.
    
    Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third 
    node with value 3, the linked list should become 1 -> 2 -> 4 after calling 
    your function.
    
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

// solution 1
public class Solution {
    public void deleteNode(ListNode node) {
        if(node != null && node.next != null){
            while(node.next.next != null){
                node.val = node.next.val;
                node = node.next;
            }
            node.val = node.next.val;
            node.next = null;
        }
    }
}

// solution 2, faster
public class Solution {
    public void deleteNode(ListNode node) {
        if(node != null && node.next != null){
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
