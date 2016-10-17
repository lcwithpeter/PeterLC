/*
Source : https://leetcode.com/problems/triangle/
Author : Jiayi Lei
Date   : Jul 15, 2015

Description:
    Given a triangle, find the minimum path sum from top to bottom. Each step 
    you may move to adjacent numbers on the row below.

For example, given the following triangle
    [
         [2],
        [3,4],
       [6,5,7],
      [4,1,8,3]
    ]
    The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
    Bonus point if you are able to do this using only O(n) extra space, where n
    is the total number of rows in the triangle.
    
Tags: Dynamic Programming; Array
*/

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;        
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> sub = new ArrayList<Integer>();
        sub.add(triangle.get(0).get(0));
        list.add(sub);
        for(int i = 1; i < triangle.size(); i++){
            List<Integer> last = list.get(i - 1);
            List<Integer> cur = triangle.get(i);
            sub = new ArrayList<Integer>();
            for(int j = 0; j < cur.size(); j++){
                if(j == 0){
                    sub.add(last.get(0) + cur.get(j));
                }else if(j == cur.size() - 1){
                    sub.add(last.get(j - 1) + cur.get(j));
                }else{
                    sub.add(Math.min(last.get(j) + cur.get(j), last.get(j - 1) 
                    + cur.get(j)));
                }
            }
            list.add(sub);
        }
        int row = list.size() - 1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < list.get(row).size(); i++){
            if(list.get(row).get(i) < min) min = list.get(row).get(i);
        }
        return min;
    }
}
