/*
Source : https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
Author : Jiayi Lei
Date   : Jun 12, 2015

Description:
    Given a binary tree, flatten it to a linked list in-place.
For example,
    Given

             1
            / \
           2   5
          / \   \
         3   4   6
    The flattened tree should look like:
       1
        \
         2
          \
           3
            \
             4
              \
               5
                \
                 6
    click to show hints.
Hints:
    If you notice carefully in the flattened tree, each node's right child 
    points to the next node of a pre-order traversal.
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
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        root.left = null;
        
        flatten(left);
        flatten(right);
        
        root.right = left;
        TreeNode cur = root;
        while(cur.right != null) cur = cur.right;
        cur.right = right;
    }
}
