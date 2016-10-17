/*
Source : https://leetcode.com/problems/invert-binary-tree/
Author : Jiayi Lei
Date   : Jun 12, 2015
Description:
    Invert a binary tree.
         4
       /   \
      2     7
     / \   / \
    1   3 6   9
    to
         4
       /   \
      7     2
     / \   / \
    9   6 3   1
Trivia:
    This problem was inspired by this original tweet by Max Howell:
    Google: 90% of our engineers use the software you wrote (Homebrew), but you
    can’t invert a binary tree on a whiteboard so fuck off.
Tag: Tree
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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}

// solution 2
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root != null){
            if(root.left != null || root.right != null){
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
                invertTree(root.left);
                invertTree(root.right);
            }
        }
        return root;
    }
}
