/*
Source : https://leetcode.com/problems/pascals-triangle-ii/
Author : Jiayi Lei
Date   : Jun 1, 2015
Description:
    Given an index k, return the k-th row of the Pascal's triangle.

    For example, given k = 3,
    Return [1,3,3,1].

Note:
    Could you optimize your algorithm to use only O(k) extra space?
*/

// version 1
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
		if(rowIndex < 0) return row;
		else if(rowIndex == 0){
			row.add(1);
		}
		else{
			List<Integer> lastRow = new ArrayList<Integer>();
			lastRow.add(1);
			for(int i = 0; i < rowIndex; i++){
				List<Integer> newRow = new ArrayList<Integer>();
				newRow.add(1);
				for(int j = 0; j < lastRow.size() - 1; j++){
					newRow.add(lastRow.get(j) + lastRow.get(j + 1));
				}
				newRow.add(1);
				lastRow = newRow;
			}
			return lastRow;
		}
		return row;
    }
}

// version 2
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
		long value = 1;
		for(int i = 0; i <= rowIndex; i++){
		    row.add((int)value);
		    value = value * (rowIndex - i) / (i + 1);
		}
		return row;
    }
}

// version 3
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new LinkedList<Integer>();
        if(rowIndex >= 0){
            list.add(1);
            while(rowIndex-- >= 1){
                list.add(0, 1);
                for(int i = 1; i < list.size() - 1; i++){
                    list.set(i, list.get(i) + list.get(i + 1));
                }
            }
        }
        return list;
    }
}
