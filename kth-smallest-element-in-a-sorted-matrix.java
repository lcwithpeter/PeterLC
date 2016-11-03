/*
Source : https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
Author : Jiayi Lei
Date   : Nov 2, 2015

Description:
	Given a n x n matrix where each of the rows and columns are sorted in 
	ascending order, find the kth smallest element in the matrix.

	Note that it is the kth smallest element in the sorted order, not the kth 
	distinct element.

Example:

	matrix = [
	   [ 1,  5,  9],
	   [10, 11, 13],
	   [12, 13, 15]
	],
	k = 8,

	return 13.
Note: 
	You may assume k is always valid, 1 ≤ k ≤ n2.

*/

// version 1
// PriorityQueue only
// 44 ms
// time: O(n)
// space: O(n)
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        PriorityQueue<Integer> heap = new PriorityQueue();
        for(int[] row: matrix){
            for(int i: row){
                heap.offer(i);
            }
        }
        
        int ans = 0;
        for(int i = 0; i < k; i++){
            ans = heap.poll();
        }
        
        return ans;
    }
}


// version 2
// 45 ms
// time: O(k log k)
// space: O(n)
class Tuple{
    int x;
    int y;
    int val;
    public Tuple(int a, int b, int v){
        x = a;
        y = b;
        val = v;
    }
}

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        PriorityQueue<Tuple> heap = new PriorityQueue(new Comparator<Tuple>(){
            public int compare(Tuple a, Tuple b){
                return a.val - b.val;
            }
        });
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        
        heap.offer(new Tuple(0, 0, matrix[0][0]));
        visited[0][0] = true;
        
        int counter = 0, ans = 0;
        while(!heap.isEmpty()){
            Tuple cur = heap.poll();
            if(cur.x + 1 < matrix.length && !visited[cur.x + 1][cur.y]){
                heap.offer(new Tuple(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));
                visited[cur.x + 1][cur.y] = true;
            }
            if(cur.y + 1 < matrix[0].length && !visited[cur.x][cur.y + 1]){
                heap.offer(new Tuple(cur.x, cur.y + 1, matrix[cur.x][cur.y + 1]));
                visited[cur.x][cur.y + 1] = true;
            }
            if(++counter == k) {
                ans = cur.val;
                break;
            }
        }
        
        return ans;
    }
}

// version 3
// binary search + binary search
// 3 ms
// time: O(nlogn * logX) n: matrix length, X: difference between min and max in matrix
// space: O(1)
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int left = matrix[0][0], right = matrix[matrix.length - 1][matrix[0].length - 1];
        while(left < right){
            int mid = left + (right - left) / 2;
            int temp = 0;
            for(int i = 0; i < matrix.length; i++) temp += binSearch(matrix[i], mid);
            if(temp < k) left = mid + 1;
            else right = mid;
        }
        
        return left;
    }
    private int binSearch(int[] row, int target){
        int left = 0, right = row.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(row[mid] <= target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}


// version 4
// binary search + linear scan
// 1 ms
// time: O(nlogX)
// space: O(1)
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int left = matrix[0][0], right = matrix[matrix.length - 1][matrix[0].length - 1];
        while(left < right){
            int mid = left + (right - left) / 2;
            int temp = lessOrEqual(matrix, mid);
            if(temp < k) left = mid + 1;
            else right = mid;
        }
        
        return left;
    }
    private int lessOrEqual(int[][] matrix, int target){
        int i = 0, j = matrix[0].length - 1, counter = 0;
        while(i < matrix.length && j >= 0){
            if(matrix[i][j] <= target){
                counter += j + 1;
                i++;
            } else {
                j--;
            }
        }
        return counter;
    }
}
