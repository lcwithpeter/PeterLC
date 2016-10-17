/*
Source : https://leetcode.com/problems/binary-tree-preorder-traversal/
Author : Jiayi Lei
Date   : Jun 10, 2015

Description:
    Given a binary tree, return the preorder traversal of its nodes' values.
For example:
    Given binary tree {1,#,2,3},
       1
        \
         2
        /
       3
    return [1,2,3].
Note: 
    Recursive solution is trivial, could you do it iteratively?
Tags: Tree; Stack
*/

// recursion solution
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
    public List<Integer> list = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root != null) treeWalk(root);
        return list;
    }
    private void treeWalk(TreeNode t){
        if(t == null) return;
        else{
            list.add(t.val);
            treeWalk(t.left);
            treeWalk(t.right);
        }
    }
}

// stack solution
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root != null){
            Stack<TreeNode> st = new Stack<TreeNode>();
            while(!st.empty() || root != null){
                if(root != null){
                    list.add(root.val);
                    if(root.right != null){
                        st.push(root.right);
                    }
                    root = root.left;
                }else{
                    root = st.pop();
                }
            }
        }
        return list;
    }
}
