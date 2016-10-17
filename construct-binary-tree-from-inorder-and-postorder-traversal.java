/*
Source : https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
Author : Jiayi Lei
Date   : Jun 14, 2015

Description:
    Given inorder and postorder traversal of a tree, construct the binary tree.
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) return null;
        
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++){
            hm.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, hm);
    }
    private TreeNode helper(int[] inOrder, int[] postOrder, int inL, int inR, int postL, int postR, HashMap<Integer, Integer> hm){
        if(inL > inR || postL > postR) return null;
        TreeNode root = new TreeNode(postOrder[postR]);
        int index = hm.get(root.val);
        root.left = helper(inOrder, postOrder, inL, index - 1, postL, postL + index - inL - 1, hm);
        root.right = helper(inOrder, postOrder, index + 1, inR, postR - (inR - index), postR - 1, hm);
        return root;
    }
}
