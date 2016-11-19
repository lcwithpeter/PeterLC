/*
Source : https://leetcode.com/problems/house-robber-iii/
Author : Jiayi Lei
Date   : Nov 13, 2015

Description:
	The thief has found himself a new place for his thievery again. There is only
	one entrance to this area, called the "root." Besides the root, each house 
	has one and only one parent house. After a tour, the smart thief realized 
	that "all houses in this place forms a binary tree". It will automatically 
	contact the police if two directly-linked houses were broken into on the same
	night.

	Determine the maximum amount of money the thief can rob tonight without 
	alerting the police.

Example 1:
     3
    / \
   2   3
    \   \ 
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

Example 2:
     3
    / \
   4   5
  / \   \ 
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.
    
Tags: Dynamic Programming
*/

// version 1
// O(e^n)
// 659 ms
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
    public int rob(TreeNode root) {
        if(root == null) return 0;
        int b = 0, c = 0, d = 0, e = 0, f = 0, g = 0;
        if(root.left != null){
            b = rob(root.left);
            d = rob(root.left.left);
            e = rob(root.left.right);
        }
        if(root.right != null){
            c = rob(root.right);
            f = rob(root.right.left);
            g = rob(root.right.right);
        }
        
        return Math.max(root.val + d + e + f + g, b + c);
    }
}

// version 2
// O(n)
// 1 ms
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
    public int rob(TreeNode root) {
        int[] ret = helper(root);
        return Math.max(ret[0], ret[1]);
    }
    private int[] helper(TreeNode node){
        // ret[0]: max value of robbing the node
        // ret[1]: max value of NOT robbing the node
        int[] ret = new int[2];
        if(node != null){
            int[] left = helper(node.left);
            int[] right = helper(node.right);
            
            ret[0] = node.val + left[1] + right[1];
            ret[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        }
        return ret;
    }
}
