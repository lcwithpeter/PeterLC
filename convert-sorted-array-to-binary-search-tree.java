/*
Source : 
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
Author : Jiayi Lei
Date   : Jun 9, 2015

Description:
    Given an array where elements are sorted in ascending order, convert it to 
    a height balanced BST.
Tags: Tree; Depth-first Search
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        int start = 0, end = nums.length - 1;
        return buildTree(nums, start, end);
    }
    private TreeNode buildTree(int[] n, int start, int end){
        if(start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode t = new TreeNode(n[mid]);
        t.left = buildTree(n, start, mid - 1);
        t.right = buildTree(n, mid + 1, end);
        return t;
    }
}

/* 
using Arrays.copyOfRange method:
public static int[] copyOfRange(int[] original, int from, int to)
    original -- This is the array from which a range is to to be copied.
    from -- This is the initial index of the range to be copied, inclusive.
    to -- This is the final index of the range to be copied, exclusive.
*/
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        int mid = nums.length / 2;
        TreeNode t = new TreeNode(nums[mid]);
        t.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        t.right = 
        sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));
        return t;
    }
}