/*
Source : https://leetcode.com/problems/binary-tree-right-side-view/
Author : Jiayi Lei
Date   : Jun 14, 2015

Description:
    Given a binary tree, imagine yourself standing on the right side of it, 
    return the values of the nodes you can see ordered from top to bottom.
For example:
    Given the following binary tree,
       1            <---
     /   \
    2     3         <---
     \     \
      5     4       <---
    You should return [1, 3, 4].
Tags: Tree; Depth-first Search; Breadth-first Search
*/

// Breadth-first queue implementation
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root != null){
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int levelNum = queue.size();
                for(int i = 0; i < levelNum - 1; i++){
                    if(queue.peek().left != null) queue.offer(queue.peek().left);
                    if(queue.peek().right != null) queue.offer(queue.peek().right);
                    queue.poll();
                }
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                list.add(queue.poll().val);
            }
        }
        return list;
    }
}

// Depth-first recursion implementation
/*
Core idea:
    1. Each depth of the tree only select one node.
    2. View depth is current size of result list.
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        helper(list, root, 0);
        return list;
    }
    private void helper(List<Integer> list, TreeNode node, int depth){
        if(node == null) return;
        if(depth == list.size()) list.add(node.val);
        helper(list, node.right, depth + 1);
        helper(list, node.left, depth + 1);
    }
}