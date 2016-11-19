/*
Source : https://leetcode.com/problems/paint-fence/
Author : Jiayi Lei
Date   : Oct 18, 2015

Description:
    There is a fence with n posts, each post can be painted with one of the k 
	colors.

	You have to paint all the posts such that no more than two adjacent fence 
	posts have the same color.

	Return the total number of ways you can paint the fence.

Note:
	n and k are non-negative integers.
Tags: 
	Dynamic Programming
Similar Problems:
	https://leetcode.com/problems/house-robber/
	https://leetcode.com/problems/house-robber-ii/	
	https://leetcode.com/problems/paint-house/
	https://leetcode.com/problems/paint-house-ii/
*/


// version 1
public class Solution {
    public int numWays(int n, int k) {
        if(n == 0) return 0;
        if(n == 1) return k;
        int diffColorCounts = k * (k - 1);
        int sameColorCounts = k;
        for(int i = 2; i < n; i++){
            int tmp = diffColorCounts;
            diffColorCounts = (diffColorCounts + sameColorCounts) * (k - 1);
            sameColorCounts = tmp;
        }
        return diffColorCounts + sameColorCounts;
    }
}


// version 2
/*
Use dp, dp[i] is the number of ways to paint. When painting post #i, consider:
1. Use a different color with post #(i-1), we have (k-1)*dp[i-1] ways.
2. Use a same color with post #(i-1), but a different color with post #(i-2), so
   we have (k-1)*dp[i-2] ways.
   
In total, for post #i, we have (k-1)*(dp[i-1] + dp[i-2]) ways.

Since for each post, only two posts are related, we can use two variables to 
improve space.
*/
public class Solution {
    public int numWays(int n, int k) {
        if(n == 0 || k == 0) return 0;
        if(n == 1) return k;
        
        int a = k, b = k * k;
        for(int i = 2; i < n; i++){
            int c = (k - 1) * (a + b);
            a = b;
            b = c;
        }
        
        return b;
    }
}
