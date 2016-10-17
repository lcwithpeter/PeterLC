/*
Source : https://leetcode.com/problems/rectangle-area/
Author : Jiayi Lei
Date   : Jul 4, 2015

Description:
    Find the total area covered by two rectilinear rectangles in a 2D plane.
    Each rectangle is defined by its bottom left corner and top right corner as
    shown in the figure.

https://leetcode.com/static/images/problemset/rectangle_area.png

    Assume that the total area is never beyond the maximum possible value of 
    int.

Credits:
    Special thanks to @mithmatt for adding this problem, creating the above 
    image and all test cases.
    
Tags: Math
*/

// version 1
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = Math.max(A, E), right = Math.max(left, Math.min(C, G));
        int bottom = Math.max(B, F), top = Math.max(bottom, Math.min(D, H));
        return (C - A) * (D - B) + (G - E) * (H - F) - (right - left) * (top - bottom);
    }
}

// version 2
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int sum = (C - A) * (D - B) + (G - E) * (H - F);
        int a = Math.max(Math.max(A, E), Math.min(C, G)) - Math.max(A, E);
        int b = Math.max(Math.max(B, F), Math.min(D, H)) - Math.max(B, F);
        return sum - a * b;
    }
}
