/*
Source : https://leetcode.com/problems/course-schedule-ii/
Author : Jiayi Lei
Date   : Nov 5, 2015

Description:
	There are a total of n courses you have to take, labeled from 0 to n - 1.

	Some courses may have prerequisites, for example to take course 0 you have 
	to first take course 1, which is expressed as a pair: [0,1]

	Given the total number of courses and a list of prerequisite pairs, return 
	the ordering of courses you should take to finish all courses.

	There may be multiple correct orders, you just need to return one of them. 
	If it is impossible to finish all courses, return an empty array.

For example:

	2, [[1,0]]
	There are a total of 2 courses to take. To take course 1 you should have 
	finished course 0. So the correct course order is [0,1]

	4, [[1,0],[2,0],[3,1],[3,2]]
	There are a total of 4 courses to take. To take course 3 you should have 
	finished both courses 1 and 2. Both courses 1 and 2 should be taken after 
	you finished course 0. So one correct course order is [0,1,2,3]. Another 
	correct ordering is[0,2,1,3].

Note:
	The input prerequisites is a graph represented by a list of edges, not 
	adjacency matrices. Read more about how a graph is represented.

Hints:
	This problem is equivalent to finding the topological order in a directed 
	graph. If a cycle exists, no topological ordering exists and therefore it 
	will be impossible to take all courses.
	Topological Sort via DFS - https://www.youtube.com/watch?v=jksMzq4LgfM.
	Topological sort could also be done via BFS.

*/

// version 1
// 18 ms
// time: O(|V| + |E|)
// space: O(n)
public class Solution {
    
    boolean[] courseOK;
    boolean[] visiting;
    Map<Integer, Set<Integer>> graph;
    boolean hasCycle;
    Stack<Integer> stack;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
		if(numCourses < 1) return new int[0];
		
        int[] ans = new int[numCourses];        
        if(numCourses == 1 || prerequisites == null || prerequisites.length == 0){
            for(int i = 0; i < ans.length; i++){
                ans[i] = i;
            }
            return ans;
        }
        
        hasCycle = false;
        courseOK = new boolean[numCourses];
        visiting = new boolean[numCourses];
        graph = new HashMap();
        stack = new Stack();
        
        // build graph
        for(int i = 0; i < numCourses; i++){
            graph.put(i, new HashSet<Integer>());
        }
        for(int[] e: prerequisites){
            graph.get(e[1]).add(e[0]);
        }
        
        // DFS
        for(int node: graph.keySet()){
            if(hasCycle) return new int[0];
            if(!courseOK[node]) dfs(node);
        }
        
        // repare answeres
        for(int i = 0; i < ans.length; i++){
            ans[i] = stack.pop();
        }
        
        return ans;
    }
    private void dfs(int node){
        if(hasCycle) return;
        if(courseOK[node]) return;
        if(visiting[node]){
            hasCycle = true;
            return;
        }
        visiting[node] = true;
        
        if(graph.containsKey(node)){
            for(int next: graph.get(node)){
                if(!courseOK[next]) dfs(next);
            }
        }
        
        courseOK[node] = true;
        stack.push(node);
        visiting[node] = false;
    }
}
