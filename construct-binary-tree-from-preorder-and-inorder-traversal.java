/*
Source : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
Author : Jiayi Lei
Date   : Jun 14, 2015

Description:
    Given preorder and inorder traversal of a tree, construct the binary tree.
Note:
    You may assume that duplicates do not exist in the tree.
Tags: Tree; Array; Depth-first Search
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++){
            hm.put(inorder[i], i);
        }
        return helper(inorder, preorder, 0, inorder.length - 1, 0, preorder.length - 1, hm);
    }
    private TreeNode helper(int[] inorder, int[] preorder, int inL, int inR, int preL, int preR, HashMap<Integer, Integer> hm){
        if(inL > inR || preL > preR) return null;
        TreeNode root = new TreeNode(preorder[preL]);
        int index = hm.get(root.val);
        root.left = helper(inorder, preorder, inL, index - 1, preL + 1, preL + index - inL, hm);
        root.right = helper(inorder, preorder, index + 1, inR, preR - inR + index + 1, preR, hm);
        return root;
    }
}
