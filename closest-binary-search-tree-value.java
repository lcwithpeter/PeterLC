/*
Source : https://leetcode.com/problems/closest-binary-search-tree-value/
Author : Jiayi Lei
Date   : Aug 31, 2015

Description:
   Given a non-empty binary search tree and a target value, find the value in 
   the BST that is closest to the target.

Note:
	Given target value is a floating point.
	You are guaranteed to have only one unique value in the BST that is closest 
	to the target.
	
Tags: Tree; Binary Search

Similiar Problems:
	https://leetcode.com/problems/count-complete-tree-nodes/
	https://leetcode.com/problems/closest-binary-search-tree-value-ii/
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
    public int closestValue(TreeNode root, double target) {
        if(root == null) return 0;
        if(root.val == target) return root.val;
        else if(root.val > target){
            if(root.left != null){
                int candidate = closestValue(root.left, target);
                return (root.val - target <
				Math.abs((double)candidate - target)) ? root.val : candidate;
            }
            else return root.val;
        }else{
            if(root.right != null){
                int candidate = closestValue(root.right, target);
                return (target - root.val <
				Math.abs((double)candidate - target)) ? root.val : candidate;
            }
            else return root.val;
        }
    }
}

// version 2
public class Solution {
    public int closestValue(TreeNode root, double target) {        
        if(target < root.val){
            if(root.left == null) return root.val;
            else{
                int child = closestValue(root.left, target);
                return Math.abs(root.val - target) < Math.abs(child - target) ?
					root.val : child;
            }
        }else if(target > root.val){
            if(root.right == null) return root.val;
            else{
                int child = closestValue(root.right, target);
                return Math.abs(root.val - target) < Math.abs(child - target) ?
					root.val : child;
            }
        }else return root.val;
    }
}