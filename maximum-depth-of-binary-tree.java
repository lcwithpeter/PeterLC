/*
Source : https://leetcode.com/problems/maximum-depth-of-binary-tree/
Author : Jiayi Lei
Date   : Jun 9, 2015

Description:
    Given a binary tree, find its maximum depth.
    The maximum depth is the number of nodes along the longest path from the 
    root node down to the farthest leaf node.
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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left = 1, right = 1;
        if(root.left != null) left += maxDepth(root.left);
        if(root.right != null) right += maxDepth(root.right);
        if(left > right) return left;
        return right;
    }
}

// solution 2
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
}
