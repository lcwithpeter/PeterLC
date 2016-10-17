/*
Source : https://leetcode.com/problems/reconstruct-itinerary/
Author : Jiayi Lei
Date   : Feb 5, 2016

Description:
    Given a list of airline tickets represented by pairs of departure and 
	arrival airports [from, to], reconstruct the itinerary in order. All of the 
	tickets belong to a man who departs from JFK. Thus, the itinerary must begin
	with JFK.

Note:
	If there are multiple valid itineraries, you should return the itinerary 
	that has the smallest lexical order when read as a single string. For 
	example, the itinerary ["JFK", "LGA"] has a smaller lexical order than 
	["JFK", "LGB"].
	All airports are represented by three capital letters (IATA code).
	You may assume all tickets may form at least one valid itinerary.
Example 1:
	tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
	Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
	tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL",
	"SFO"]]
	Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
	Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. 
	But it is larger in lexical order.

Credits:
	Special thanks to @dietpepsi for adding this problem and creating all test 
	cases.
Tags:
	Depth-first Search; Graph
*/

public class Solution {
    
    int len = 0;
    List<String> list = new LinkedList<>();
    Map<String, List<String>> map = new HashMap<>();
    
    public List<String> findItinerary(String[][] tickets) {
        if(tickets.length == 0) return list;
        len = tickets.length + 1;
        
        // build the graph
        for(int i = 0; i < tickets.length; i++){
            if(!map.containsKey(tickets[i][0])){
                List<String> sub = new LinkedList<>();
                sub.add(tickets[i][1]);
                map.put(tickets[i][0], sub);
            }else{
                map.get(tickets[i][0]).add(tickets[i][1]);
            }
        }
        
        // sort
        for(Map.Entry<String, List<String>> e: map.entrySet()){
            Collections.sort(e.getValue());
        }
        
        list.add("JFK");
        dfs("JFK");
        
        return list;
    }
    private void dfs(String v){
        if(!map.containsKey(v)) return;
        List<String> sub = map.get(v);
        for(int i = 0; i < sub.size(); i++){
            String airport = sub.get(i);
            sub.remove(i);
            list.add(airport);
            dfs(airport);
            if(list.size() == len) return;
            sub.add(i, airport);
            list.remove(list.size() - 1);
        }
    }
}
