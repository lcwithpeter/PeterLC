/*
Source : https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
Author : Jiayi Lei
Date   : Jun 12, 2015

Description:
    Given a binary tree, return the bottom-up level order traversal of its 
    nodes' values. (ie, from left to right, level by level from leaf to root).
For example:
    Given binary tree {3,9,20,#,#,15,7},
        3
       / \
      9  20
        /  \
       15   7
    return its bottom-up level order traversal as:
    [
      [15,7],
      [9,20],
      [3]
    ]
Tags: Tree; Breadth-first Search
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

// stack solution
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Stack<List<Integer>> st = new Stack<List<Integer>>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new ArrayList<Integer>();
            for(int i = 0; i < levelNum; i++){
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            st.push(subList);
        }
        while(!st.isEmpty()){
            list.add(st.pop());
        }
        return list;
    }
}

// still use List, but insert new element in the head every time.
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new ArrayList<Integer>();
            for(int i = 0; i < levelNum; i++){
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            list.add(0, subList);
        }
        return list;
    }
}
