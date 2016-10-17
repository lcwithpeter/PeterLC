/*
Source : https://leetcode.com/problems/odd-even-linked-list/
Author : Jiayi Lei
Date   : Jan 24, 2016

Description:
    Given a singly linked list, group all odd nodes together followed by the 
	even nodes. Please note here we are talking about the node number and not 
	the value in the nodes.

	You should try to do it in place. The program should run in O(1) space 
	complexity and O(nodes) time complexity.

Example:
	Given 1->2->3->4->5->NULL,
	return 1->3->5->2->4->NULL.

Note:
	The relative order inside both the even and odd groups should remain as it 
	was in the input. 
	The first node is considered odd, the second node even and so on ...

Credits:
	Special thanks to @aadarshjajodia for adding this problem and creating all 
	test cases.
	
Tag:
	Linked List;
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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return head;
		
        ListNode leftPre = head;
        ListNode rightPre = leftPre;
        int gap = 1;
        
		while(rightPre.next != null){
            for(int i = 0; i < gap && rightPre.next != null; i++){
                rightPre = rightPre.next;
            }
			
            if(rightPre.next != null){
                ListNode temp = rightPre.next;
                rightPre.next = temp.next;
                temp.next = leftPre.next;
                leftPre.next = temp;
                gap++;
                leftPre = leftPre.next;
                rightPre = leftPre;
            }
        }
		
        return head;
    }
}

// solution 2
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return head;
        
        ListNode oddTail = oddHead;
        ListNode evenHead = head.next, evenTail = evenHead;
        
        while(evenTail != null && evenTail.next != null){
            oddTail.next = evenTail.next;
            oddTail = oddTail.next;
            evenTail.next = oddTail.next;
            evenTail = evenTail.next;
        }
        oddTail.next = evenHead;
        
        return head;
    }
}
