/*
Source : 
https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
Author : Jiayi Lei
Date   : Jun 11, 2015

Description:
    Given a singly linked list where elements are sorted in ascending order, 
    convert it to a height balanced BST.
Tags: Linked List; Depth-first Search
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ListNode p = head;
        int len = 0;
        while(p != null){
            len++;
            p = p.next;
        }
        return buildBST(head, 1, len);
    }
    private TreeNode buildBST(ListNode list, int start, int end){
        if(start > end) return null;
        int mid = start + (end - start) / 2;
        ListNode midNode = getListNode(list, mid);
        TreeNode tree = new TreeNode(midNode.val);
        tree.left = buildBST(list, start, mid - 1);
        tree.right = buildBST(midNode.next, start, end - mid);
        return tree;
    }
    private ListNode getListNode(ListNode list, int n){
        while(--n > 0){
            list = list.next;
        }
        return list;
    }
}
