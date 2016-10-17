/*
Source : https://leetcode.com/problems/binary-tree-postorder-traversal/
Author : Jiayi Lei
Date   : Jun 10, 2015

Description:
    Given a binary tree, return the postorder traversal of its nodes' values.
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
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root != null) treeWalk(root);
        return list;
    }
    private void treeWalk(TreeNode t){
        if(t == null) return;
        else{            
            treeWalk(t.left);
            treeWalk(t.right);
            list.add(t.val);
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root != null){
            Stack<TreeNode> st = new Stack<TreeNode>();
            TreeNode lastVisited = null;
            while(!st.empty() || root != null){
                if(root != null){
                    st.push(root);
                    root = root.left;
                }else{
                    TreeNode peekNode = st.peek();
                    if(peekNode.right != null && lastVisited != peekNode.right){
                        root = peekNode.right;
                    }else{
                        list.add(peekNode.val);
                        lastVisited = st.pop();
                        root = null;
                    }
                }
            }
        }
        return list;
    }
}
