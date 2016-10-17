/*
Source : https://leetcode.com/problems/copy-list-with-random-pointer/
Author : Jiayi Lei
Date   : Jun 11, 2015

Description:
    A linked list is given such that each node contains an additional random 
    pointer which could point to any node in the list or null.
    Return a deep copy of the list.
Tags: Linked List; Hash Table
*/


/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return head;
        HashMap<RandomListNode, RandomListNode> hm = new HashMap<>();
        RandomListNode h = head;
        while(h != null){
            hm.put(h, new RandomListNode(h.label));
            h = h.next;
        }
        h = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode d = dummy;
        while(h != null){
            d.next = hm.get(h);
            d.next.random = hm.get(h.random);
            d = d.next;
            h = h.next;
        }
        return dummy.next;
    }
}
