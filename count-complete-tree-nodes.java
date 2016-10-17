/*
Source : https://leetcode.com/problems/count-complete-tree-nodes/
Author : Jiayi Lei
Date   : Jun 11, 2015

Description:
    Given a complete binary tree, count the number of nodes.    
    Definition of a complete binary tree from Wikipedia:
    In a complete binary tree every level, except possibly the last, is 
    completely filled, and all nodes in the last level are as far left as 
    possible. It can have between 1 and 2h nodes inclusive at the last level h.    
Tags: Tree; Binary Search
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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int dl = leftDepth(root), dr = rightDepth(root);
        if(dl == dr) return (int)Math.pow(2, dl) - 1;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    private int leftDepth(TreeNode tree){
        if(tree == null) return 0;
        return leftDepth(tree.left) + 1;
    }
    private int rightDepth(TreeNode tree){
        if(tree == null) return 0;
        return rightDepth(tree.right) + 1;
    }
}
