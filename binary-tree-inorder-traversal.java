/*
Source : https://leetcode.com/problems/binary-tree-inorder-traversal/
Author : Jiayi Lei
Date   : Jun 9, 2015

Description:
    Given a binary tree, return the inorder traversal of its nodes' values.
For example:
    Given binary tree {1,#,2,3},
       1
        \
         2
        /
       3
    return [1,3,2].
Note: 
    Recursive solution is trivial, could you do it iteratively?
Tags: Tree; Hash Table; Stack
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
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root != null) treeWalk(root);
        return list;
    }
    private void treeWalk(TreeNode n){
        if(n == null) return;
        else{
            treeWalk(n.left);
            list.add(n.val);
            treeWalk(n.right);
        }
    }
}

// stack solution
/**
 * Definition for a binary tree root.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root != null){
            Stack<TreeNode> st = new Stack<TreeNode>();
            while(!st.empty() || root != null){
                if(root != null){
                    st.push(root);
                    root = root.left;
                }else{
                    root = st.pop();
                    list.add(root.val);
                    root = root.right;
                }
            }
        }
        return list;
    }
}

// Morris two pointer solution
// tutorial: http://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /* 
1. If cur.left is null, output cur.val and move to its right child.
2. If cur.left is not null, find its in-order prev node in the left sub-tree of
   cur node.
    a) If prev.right is null, point its right to cur. Then, cur moves to its 
       left child.
    b) If prev.right is cur, point its right to null (recovering the tree 
       structure). Then, output cur node and cur moves to its right child.
3. repeat step 1 and step 2 till cur is null.
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root != null){
            TreeNode cur = root, prev = null;
            while(cur != null){
                if(cur.left == null){
                    list.add(cur.val);
                    cur = cur.right;
                }else{
                    prev = cur.left;
                    while(prev.right != null && prev.right != cur)
                        prev = prev.right;
                    if(prev.right == null){
                        prev.right = cur;
                        cur = cur.left;
                    }else{
                        prev.right = null;
                        list.add(cur.val);
                        cur = cur.right;
                    }
                }
            }
        }
        return list;
    }
}
