/*
Source : https://leetcode.com/problems/sum-root-to-leaf-numbers/
Author : Jiayi Lei
Date   : Jun 12, 2015

Description:
    Given a binary tree containing digits from 0-9 only, each root-to-leaf path
    could represent a number. An example is the root-to-leaf path 1->2->3 which
    represents the number 123. Find the total sum of all root-to-leaf numbers.
For example,
        1
       / \
      2   3
    The root-to-leaf path 1->2 represents the number 12.
    The root-to-leaf path 1->3 represents the number 13.

    Return the sum = 12 + 13 = 25.
Tags: Tree; Depth-first Search
*/

// DFS solution
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
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    private int helper(TreeNode node, int sum){
        if(node == null) return 0;
        if(node.left == null && node.right == null) return 10 * sum + node.val;
        return helper(node.left, 10 * sum + node.val) + 
        helper(node.right, 10 * sum + node.val);
    }
}

// BFS solution
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
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            for(int i = 0; i < levelNum; i++){
                if(queue.peek().left != null){
                    queue.peek().left.val += 10 * queue.peek().val;
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right != null){
                    queue.peek().right.val += 10 * queue.peek().val;
                    queue.offer(queue.peek().right);
                }
                if(queue.peek().left == null && queue.peek().right == null){
                    sum += queue.peek().val;
                }
                queue.poll();
            }
        }
        return sum;
    }
}
