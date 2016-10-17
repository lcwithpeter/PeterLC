/*
Source : https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
Author : Jiayi Lei
Date   : Feb 2, 2016

Description:
    One way to serialize a binary tree is to use pre-order traversal. When we 
	encounter a non-null node, we record the node's value. If it is a null node,
	we record using a sentinel value such as #.

			 _9_
			/   \
		   3     2
		  / \   / \
		 4   1  #  6
		/ \ / \   / \
		# # # #   # #

For example:
	The above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6
	,#,#", where # represents a null node.

	Given a string of comma separated values, verify whether it is a correct 
	preorder traversal serialization of a binary tree. Find an algorithm without
	reconstructing the tree.

	Each comma separated value in the string must be either an integer or a 
	character '#' representing null pointer.

	You may assume that the input format is always valid, for example it could 
	never contain two consecutive commas such as "1,,3".

Example 1:
	"9,3,4,#,#,1,#,#,2,#,6,#,#"
	Return true

Example 2:
	"1,#"
	Return false

Example 3:
	"9,#,#,1"
	Return false

Credits:
	Special thanks to @dietpepsi for adding this problem and creating all test 
	cases.
	
Tag:
	Stack;
*/


public class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.length() == 0){
            return false;
        }
            
        if(preorder.length() == 1){
            return preorder.charAt(0) == '#';
        }
        
        String[] tree = preorder.split(",");
        if(tree.length % 2 == 0){
            return false;
        }
        
        if(tree[0].equals("#") ||
            !tree[tree.length - 1].equals("#") ||
            !tree[tree.length - 2].equals("#")){
            return false;
        }
            
        
        Stack<Integer> st = new Stack<>();
        for(String node: tree){
            if(node.equals("#")){
                if(st.isEmpty()){
                    return false;
                } 
                st.push(st.pop() + 1);
            }
            else if(Integer.parseInt(node) <= Integer.MAX_VALUE &&
                Integer.parseInt(node) >= Integer.MIN_VALUE){
                st.push(0);
            }
            else{
                return false;
            }
            
            while(!st.isEmpty() && st.peek() == 2){
                st.pop();
                if(!st.isEmpty()){
                    st.push(st.pop() + 1);
                }
            }
        }
        return st.isEmpty();
    }
}
