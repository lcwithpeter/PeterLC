/*
Source : https://leetcode.com/problems/path-sum/
Author : Jiayi Lei
Date   : Jun 12, 2015

Description:
    Given a binary tree and a sum, determine if the tree has a root-to-leaf 
    path such that adding up all the values along the path equals the given 
    sum.
For example:
    Given the below binary tree and sum = 22,
                  5
                 / \
                4   8
               /   / \
              11  13  4
             /  \      \
            7    2      1
    return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 
    22.
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
    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root, 0, sum);
    }
    private boolean helper(TreeNode tree, int curSum, int target){
        if(tree == null) return false;
        if(tree.left == null && tree.right == null) 
			return (curSum + tree.val) == target;
        return helper(tree.left, curSum + tree.val, target) || 
			helper(tree.right, curSum + tree.val, target);
    }
}

// version 2
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null && sum - root.val == 0) 
			return true;
        return hasPathSum(root.left, sum - root.val) || 
			hasPathSum(root.right, sum - root.val);
    }
}

// version 3
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        
        // check if root is null
        if(root == null) return false;
        
        // if the current node is not a leaf node, do recursion.
        if(root.left != null || root.right != null) 
            return hasPathSum(root.left, sum - root.val) || 
				hasPathSum(root.right, sum - root.val);
        
        // now the current node is a leaf node
        return sum - root.val == 0;
    }
}