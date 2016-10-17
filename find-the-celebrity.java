/*
Source : https://leetcode.com/problems/find-the-celebrity/
Author : Jiayi Lei
Date   : Sep 10, 2015

Description:
    Suppose you are at a party with n people (labeled from 0 to n - 1) and among
	them, there may exist one celebrity. The definition of a celebrity is that 
	all the other n - 1 people know him/her but he/she does not know any of them.

	Now you want to find out who the celebrity is or verify that there is not 
	one. The only thing you are allowed to do is to ask questions like: "Hi, A.
	Do you know B?" to get information of whether A knows B. You need to find 
	out the celebrity (or verify there is not one) by asking as few questions as
	possible (in the asymptotic sense).

	You are given a helper function bool knows(a, b) which tells you whether A 
	knows B. Implement a function int findCelebrity(n), your function should 
	minimize the number of calls to knows.

Note:
	There will be exactly one celebrity if he/she is in the party. Return the 
	celebrity's label if there is a celebrity in the party. If there is no 
	celebrity, return -1.

Tags:
    Array
*/

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

// version 1
public class Solution extends Relation {
    public int findCelebrity(int n) {
        if(n < 1) return -1;
        else if(n == 1) return 0;
        else{
            Stack<Integer> celebrity = new Stack<Integer>();
            Set<Integer> people = new HashSet<Integer>();
            Map<Integer, int[]> relation = new HashMap<Integer, int[]>();
            for(int i = 0; i < n; i++){
                if(people.contains(i)) continue;
                celebrity.push(i);
                for(int j = 0; j < n; j++){
                    if(i == j) continue;
                    
                    // i:
                    if(!relation.containsKey(i)){
                        relation.put(i, new int[n]);
                    }
                    if(relation.get(i)[j] == 0){
                        relation.get(i)[j] = (knows(j, i)) ? (1) : (-1);
                    }
                    if(relation.get(i)[j] == -1){
                        people.add(celebrity.pop());
                        break;
                    }
                    
                    // j:
                    if(!relation.containsKey(j)){
                        relation.put(j, new int[n]);
                    }
                    if(relation.get(j)[i] == 0){
                        relation.get(j)[i] = (knows(i, j)) ? (1) : (-1);
                    }
                    if(relation.get(j)[i] == 1){
                        people.add(celebrity.pop());
                        break;
                    }
                }
            }
            if(celebrity.isEmpty()) return -1;
            return celebrity.peek();
        }
    }
}

// version 2
public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        for(int i = 0; i < n; i++){
            if(knows(candidate, i))
                candidate = i;
        }
        for(int i = 0; i < n; i++){
            if(i == candidate) continue;
            if(knows(candidate, i) || !knows(i, candidate)) return -1;
        }
        return candidate;
    }
}
