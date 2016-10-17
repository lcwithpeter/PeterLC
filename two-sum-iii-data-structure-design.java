/*
Source : https://leetcode.com/problems/two-sum-iii-data-structure-design/
Author : Jiayi Lei
Date   : Sep 10, 2015

Description:
    Design and implement a TwoSum class. It should support the following
	operations: add and find.

	add - Add the number to an internal data structure.
	find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
	add(1); add(3); add(5);
	find(4) -> true
	find(7) -> false

Tags:
    Hash Table; Data Structure

Similar Problems:
	https://leetcode.com/problems/two-sum/
*/

// version 1
public class TwoSum {
    List<Integer> list = new ArrayList<Integer>();
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	public void add(int number) {
	    list.add(number);
	    if(!map.containsKey(number)) map.put(number, 1);
	    else map.put(number, map.get(number) + 1);
	}

	public boolean find(int value) {
	    if(list.size() > 1){
	        boolean ret = false;
	        for(Integer cur : list){
	            map.put(cur, map.get(cur) - 1);
	            if(map.containsKey(value - cur) && map.get(value - cur) > 0) 
					ret = true;
	            map.put(cur, map.get(cur) + 1);
	            if(ret) return true;
	        }
	    }
	    return false;
	}
}

// version 2
public class TwoSum {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	public void add(int number) {
	    map.put(number, map.containsKey(number) ? 2 : 1);
	}

	public boolean find(int value) {
	    for(int one : map.keySet()){
	        int two = value - one;
	        if(one == two && map.get(one) > 1 ||
	            one != two && map.containsKey(two))
	            return true;
	    }
	    return false;
	}
}
