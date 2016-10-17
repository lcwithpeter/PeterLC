/*
Source : https://leetcode.com/problems/unique-binary-search-trees/
Author : Jiayi Lei
Date   : Jun 14, 2015

Description:
    Given n, how many structurally unique BST's (binary search trees) that 
    store values 1...n?
For example,
    Given n = 3, there are a total of 5 unique BST's.

       1         3     3      2      1
        \       /     /      / \      \
         3     2     1      1   3      2
        /     /       \                 \
       2     1         2                 3
Tags: Tree; Dynamic Programming
*/

// Catalan number
/*
C0 = 1; C1 = 1; C_(n+1) = Sigma_(0<=i<=n)(Ci*C_(n-i))
*/
public class Solution {
    public int numTrees(int n) {
        if(n < 0) return 0;
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){
                res[i] += res[j] * res[i - j - 1];
            }
        }
        return res[n];
    }
}
