/*
Source : https://leetcode.com/problems/same-tree/
Author : Jiayi Lei
Date   : Jun 9, 2015

Description:
    Given two binary trees, write a function to check if they are equal or not.
    Two binary trees are considered equal if they are structurally identical 
    and the nodes have the same value.
Tags: Tree; Depth-first Search
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        else if(p == null && q != null) return false;
        else if(p != null && q == null) return false;
        else if(p.val != q.val) return false;
        else return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
