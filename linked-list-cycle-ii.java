/*
Source : https://leetcode.com/problems/linked-list-cycle-ii/
Author : Jiayi Lei
Date   : Jun 6, 2015

Description:
    Given a linked list, return the node where the cycle begins. If there is no
    cycle, return null.
Follow up:
    Can you solve it without using extra space?
Tags: Linked List; Two Pointers
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
 // using extra space
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        List<ListNode> list = new ArrayList<ListNode>();
        while(head != null){
            if(list.contains(head)) return head;
            list.add(head);
            head = head.next;
        }
        return null;
    }
}

// without using extra space
// when there exists a loop, the point they meet has the same distance to the 
// loop entrance with head
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while(fast != null){
            if(fast == slow) break;
            if(fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast == null) return null;
        slow = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
