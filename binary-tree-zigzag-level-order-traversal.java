/*
Source : https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
Author : Jiayi Lei
Date   : Jun 15, 2015

Description:
    Given a binary tree, return the zigzag level order traversal of its nodes' 
    values. (ie, from left to right, then right to left for the next level and 
    alternate between).
For example:
    Given binary tree {3,9,20,#,#,15,7},
        3
       / \
      9  20
        /  \
       15   7
    return its zigzag level order traversal as:
    [
      [3],
      [20,9],
      [15,7]
    ]
Tags: Tree; Array; Breadth-first Search; Stack
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root != null){
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            int seq = 1;
            while(!queue.isEmpty()){
                int levelNum = queue.size();
                List<Integer> subList = new ArrayList<Integer>();
                for(int i = 0; i < levelNum; i++){
                    if(queue.peek().left != null) queue.offer(queue.peek().left);
                    if(queue.peek().right != null) queue.offer(queue.peek().right);
                    if(seq == 1) subList.add(queue.poll().val);
                    else subList.add(0, queue.poll().val);
                }
                seq *= -1;
                list.add(subList);
            }
        }
        return list;
    }
}
