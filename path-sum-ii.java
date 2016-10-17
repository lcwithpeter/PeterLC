/*
Source : https://leetcode.com/problems/path-sum-ii/
Author : Jiayi Lei
Date   : Jun 16, 2015

Description:
    Given a binary tree and a sum, find all root-to-leaf paths where each 
    path's sum equals the given sum.
For example:
    Given the below binary tree and sum = 22,
                  5
                 / \
                4   8
               /   / \
              11  13  4
             /  \    / \
            7    2  5   1
    return
    [
       [5,4,11,2],
       [5,8,4,5]
    ]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> sub = new ArrayList<Integer>();
        helper(root, sum, list, sub);
        return list;
    }
    private void helper(TreeNode root, int sum, List<List<Integer>> list, List<Integer> sub) {
        if(root == null) return;
        sub.add(root.val);
        if(root.left == null && root.right == null && sum == root.val) list.add(new ArrayList(sub));
        else{
            helper(root.left, sum - root.val, list, sub);
            helper(root.right, sum - root.val, list, sub);
        }
        sub.remove(sub.size() - 1);
    }
}
