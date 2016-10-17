/*
Source : https://leetcode.com/problems/pascals-triangle/
Author : Jiayi Lei
Date   : Jun 1, 2015
Description:
    Given numRows, generate the first numRows of Pascal's triangle.
    
    For example, given numRows = 5,
    Return
    [
         [1],
        [1,1],
       [1,2,1],
      [1,3,3,1],
     [1,4,6,4,1]
    ]
*/

// version 1
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(numRows > 0){
			List<Integer> lastRow = new ArrayList<Integer>();
			lastRow.add(1);
			for(int i = 1; i <= numRows; i++){
				list.add(lastRow);
				List<Integer> newRow = new ArrayList<Integer>();
				newRow.add(1);
				for(int j = 0; j < lastRow.size() - 1; j++){
					newRow.add(lastRow.get(j) + lastRow.get(j + 1));
				}
				newRow.add(1);
				lastRow = newRow;
			}			
		}
		return list;
    }
}

// version 2
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if(numRows > 0){
            List<Integer> sub = new LinkedList<Integer>();
            sub.add(1);
            list.add(sub);
            while(numRows-- > 1){
                sub = new LinkedList<Integer>();
                sub.add(1);
                List<Integer> last = list.get(list.size() - 1);
                for(int i = 0; i < last.size() - 1; i++){
                    sub.add(last.get(i) + last.get(i + 1));
                }
                sub.add(1);
                list.add(sub);
            }
        }
        return list;
    }
}
