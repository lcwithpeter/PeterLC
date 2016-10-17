/*
Source : https://leetcode.com/problems/binary-search-tree-iterator/
Author : Jiayi Lei
Date   : Jun 12, 2015

Description:
    Implement an iterator over a binary search tree (BST). Your iterator will 
    be initialized with the root node of a BST.
    Calling next() will return the next smallest number in the BST.
    Note: next() and hasNext() should run in average O(1) time and uses O(h) 
    memory, where h is the height of the tree.
Credits:
    Special thanks to @ts for adding this problem and creating all test cases.
Tags: Tree; Stack
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<TreeNode> st = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        if(root != null){
            st.push(root);
            while(st.peek() != null && st.peek().left != null){
                st.push(st.peek().left);
            }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = st.pop();
        if(cur.right != null){
            st.push(cur.right);
            while(st.peek().left != null){
                st.push(st.peek().left);
            }
        }
        return cur.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
 