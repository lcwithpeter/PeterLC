/*
Source : https://leetcode.com/problems/binary-tree-level-order-traversal/
Author : Jiayi Lei
Date   : Jun 10, 2015

Description:
    Given a binary tree, return the level order traversal of its nodes' values. 
    (ie, from left to right, level by level).
For example:
    Given binary tree {3,9,20,#,#,15,7},
        3
       / \
      9  20
        /  \
       15   7
    return its level order traversal as:
    [
      [3],
      [9,20],
      [15,7]
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
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int d = 1; d <= maxDepth(root); d++){
            List<Integer> innerList = new ArrayList<Integer>();
            addGivenLevel(innerList, root, d);
            list.add(innerList);
        }
        return list;
    }
    private void addGivenLevel(List<Integer> innerList, TreeNode tree, int level){
        if(tree == null) return;
        if(level == 1) innerList.add(tree.val);
        else{
            addGivenLevel(innerList, tree.left, level - 1);
            addGivenLevel(innerList, tree.right, level - 1);
        }
    }
    private int maxDepth(TreeNode tree){
        if(tree == null) return 0;
        int left = 1, right = 1;
        left += maxDepth(tree.left);
        right += maxDepth(tree.right);
        if(left > right) return left;
        return right;
    }
}

// queue solution
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if(root != null){
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                List<Integer> sub = new LinkedList<Integer>();
                while(size-- > 0){
                    if(queue.peek().left != null) 
						queue.offer(queue.peek().left);
                    if(queue.peek().right != null) 
						queue.offer(queue.peek().right);
                    sub.add(queue.poll().val);
                }
                list.add(sub);
            }
        }
        return list;
    }
}
