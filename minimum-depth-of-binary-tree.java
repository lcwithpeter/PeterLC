/*
Source : https://leetcode.com/problems/minimum-depth-of-binary-tree/
Author : Jiayi Lei
Date   : Jun 12, 2015

Description:
    Given a binary tree, find its minimum depth.
    The minimum depth is the number of nodes along the shortest path from the 
    root node down to the nearest leaf node.
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
 
// version 1
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        else if(root.left == null) return minDepth(root.right) + 1;
        else if(root.right == null) return minDepth(root.left) + 1;
        else return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}

// version 2
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if(root.left != null) left = minDepth(root.left) + 1;
        if(root.right != null) right = minDepth(root.right) + 1;
        return Math.min(left, right);
    }
}
