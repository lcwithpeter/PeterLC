/*
Source : https://leetcode.com/problems/symmetric-tree/
Author : Jiayi Lei
Date   : Jun 10, 2015

Description:
    Given a binary tree, check whether it is a mirror of itself (ie, symmetric 
    around its center).
For example, this binary tree is symmetric:
        1
       / \
      2   2
     / \ / \
    3  4 4  3
    But the following is not:
        1
       / \
      2   2
       \   \
       3    3
Note:
    Bonus points if you could solve it both recursively and iteratively.
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
 
 // recursion solution
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }
    
    private boolean helper(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        else if(p == null && q != null) return false;
        else if(p != null && q == null) return false;
        else if(p.val != q.val) return false;
        else return helper(p.left, q.right) && helper(p.right, q.left);
    }
}
