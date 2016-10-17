/*
Source : https://leetcode.com/problems/binary-tree-paths/
Author : Jiayi Lei
Date   : Aug 16, 2015
Description:
    Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:
	   1
	 /   \
	2     3
	 \
	  5

All root-to-leaf paths are:
	["1->2->5", "1->3"]

Credits:
	Special thanks to @jianchao.li.fighter for adding this problem and creating 
	all test cases.
Tags: Tree
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
    List<String> list = new LinkedList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root != null){
            helper(root, "" + root.val);
        }
        return list;
    }
    private void helper(TreeNode node, String last){
        if(node.left == null && node.right == null){
            list.add(last);
        }else if(node.left != null && node.right == null){
            helper(node.left, last + "->" + node.left.val);
        }else if(node.right != null && node.left == null){
            helper(node.right, last + "->" + node.right.val);
        }else{
            helper(node.left, last +"->" + node.left.val);
            helper(node.right, last + "->" + node.right.val);
        }
    }
}

// version 2
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new LinkedList<String>();
        if(root != null){
            StringBuilder sb = new StringBuilder();
            helper(root, sb, list);
        }
        return list;
    }
    private void helper(TreeNode node, StringBuilder sb, List<String> list){
        if(node.left != null){
            StringBuilder left = new StringBuilder(sb);
            left.append(node.val);
            left.append("->");
            helper(node.left, left, list);
        }
        if(node.right != null){
            StringBuilder right = new StringBuilder(sb);
            right.append(node.val);
            right.append("->");
            helper(node.right, right, list);
        }
        if(node.left == null && node.right == null){
            sb.append(node.val);
            list.add(sb.toString());
        }
    }
}
