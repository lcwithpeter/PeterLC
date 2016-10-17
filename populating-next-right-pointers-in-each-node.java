/*
Source : 
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
Author : Jiayi Lei
Date   : Jun 10, 2015

Description:
    Given a binary tree
        struct TreeLinkNode {
          TreeLinkNode *left;
          TreeLinkNode *right;
          TreeLinkNode *next;
        }
    Populate each next pointer to point to its next right node. If there is no 
    next right node, the next pointer should be set to NULL.
    Initially, all next pointers are set to NULL.
Note:
    You may only use constant extra space.
    You may assume that it is a perfect binary tree (ie, all leaves are at the 
    same level, and every parent has two children).
For example,
    Given the following perfect binary tree,
             1
           /  \
          2    3
         / \  / \
        4  5  6  7
    After calling your function, the tree should look like:
             1 -> NULL
           /  \
          2 -> 3 -> NULL
         / \  / \
        4->5->6->7 -> NULL
Tags: Tree; Depth-first Search
*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        for(int d = 1; d <= maxDepth(root); d++){
    		Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
    		printGivenLevel(q, root, d);
    		while(!q.isEmpty()){
    			TreeLinkNode cur = q.remove();
    			cur.next = q.peek();
    		}
    	}	   
    }
	private void printGivenLevel(Queue q, TreeLinkNode tree, int level) {
		if(tree == null) return;
		if(level == 1) q.add(tree);
		else if(level > 1){
			printGivenLevel(q, tree.left, level - 1);
		    printGivenLevel(q, tree.right, level - 1);
		}
	}
	private int maxDepth(TreeLinkNode tree){
	    if(tree == null) return 0;
	    int left = 1, right = 1;
	    left += maxDepth(tree.left);
	    right += maxDepth(tree.right);
	    if(left > right) return left;
	    return right;
	}
}
