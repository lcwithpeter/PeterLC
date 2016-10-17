/*
Source : https://leetcode.com/problems/balanced-binary-tree/
Author : Jiayi Lei
Date   : Jun 9, 2015

Description:
    Given a binary tree, determine if it is height-balanced.
    For this problem, a height-balanced binary tree is defined as a binary tree
    in which the depth of the two subtrees of every node never differ by more 
    than 1.
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
// solution 1
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(getDepth(root.left) - getDepth(root.right)) > 1) 
			return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    private int getDepth(TreeNode n){
        if(n == null) return 0;
        int left = 1, right = 1;
        left += getDepth(n.left);
        right += getDepth(n.right);
        if(left > right) return left;
        return right;
    }
}

// solution 2
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(!isBalanced(root.left) || !isBalanced(root.right)) return false;
        int left = maxDepth(root.left), right = maxDepth(root.right);
        return Math.abs(left - right) <= 1;
    }
    private int maxDepth(TreeNode root){
        if(root == null) return 0;
        int left = 1, right = 1;
        if(root.left != null) left += maxDepth(root.left);
        if(root.right != null) right += maxDepth(root.right);
        return Math.max(left, right);
    }
}
