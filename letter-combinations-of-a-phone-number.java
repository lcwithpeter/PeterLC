/*
Source : https://leetcode.com/problems/letter-combinations-of-a-phone-number/
Author : Jiayi Lei
Date   : Jul 1, 2015

Description:
    Given a digit string, return all possible letter combinations that the 
    number could represent. A mapping of digit to letters (just like on the 
    telephone buttons) is given below.
    
http://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png

    Input:Digit string "23"
    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
    Although the above answer is in lexicographical order, your answer could be
    in any order you want.
    
Tags: String; Backtracking

Similar Problems:
	https://leetcode.com/problems/generate-parentheses/
	https://leetcode.com/problems/combination-sum/
*/

// solution 1
public class Solution {
    public List<String> letterCombinations(String digits){
		List<String> list = new ArrayList<String>();
		if(digits.length() > 0){
			list.add("");
			for(int i = 0; i < digits.length(); i++)
				list = combination(list, digitToString(digits.charAt(i)));
		}
		return list;
	}
    
	private List<String> combination(List<String> list, String s){		
		List<String> result = new ArrayList<String>();
		for(int i = 0; i < list.size(); i++)
			for(int j = 0; j < s.length(); j++)
				result.add(list.get(i) + s.charAt(j));
		return result;
	}
    
	private String digitToString(char digits){
		switch(digits){
		case '2': return "abc";
		case '3': return "def";
		case '4': return "ghi";
		case '5': return "jkl";
		case '6': return "mno";
		case '7': return "pqrs";
		case '8': return "tuv";
		case '9': return "wxyz";
		}
		return "";
	}
}

// solution 2
public class Solution {
    public List<String> letterCombinations(String digits){
		List<String> list = new ArrayList<String>();
		if(digits.length() > 0){
			List<String> pool = new ArrayList<String>();
			for(int i = 0; i < digits.length(); i++)
				pool.add(digitToString(digits.charAt(i)));
			backtracking(pool, list, 0, "");
		}
		return list;
	}
	
	private void backtracking(List<String> list, List<String> result,
        int index, String s){		
		if(index == list.size() - 1){
			for(int i = 0; i < list.get(index).length(); i++)
				result.add(s + list.get(index).charAt(i));
		}else{
			for(int i = 0; i < list.get(index).length(); i++)
				backtracking(list, result, index + 1,
                    s + list.get(index).charAt(i));
		}
	}
    
	private String digitToString(char digits){
		switch(digits){
		case '2': return "abc";
		case '3': return "def";
		case '4': return "ghi";
		case '5': return "jkl";
		case '6': return "mno";
		case '7': return "pqrs";
		case '8': return "tuv";
		case '9': return "wxyz";
		}
		return "";
	}
}

// version 3
public class Solution {
    
    private Map<Character, String> map = new HashMap<Character, String>();
    private List<String> list = new LinkedList<String>();
    
    public Solution(){
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
    
    public List<String> letterCombinations(String digits) {
        if(digits != null && digits.length() > 0){
            recursion("", digits);
        }
        return list;
    }
    
    private void recursion(String left, String right){
        if(right.length() == 1){
            if(!map.containsKey(right.charAt(0))){
                list = new LinkedList<String>();
                return;
            }
            String cur = map.get(right.charAt(0));
            for(int i = 0; i < cur.length(); i++){
                list.add(left + cur.charAt(i));
            }
        }else{
            if(!map.containsKey(right.charAt(0))){
                list = new LinkedList<String>();
                return;
            }
            String cur = map.get(right.charAt(0));
            for(int i = 0; i < cur.length(); i++){
                recursion(left + cur.charAt(i), right.substring(1));
            }
        }
        
    }
}

// version 4
// check if digits contains '0' or '1' first to improve the runtime
public class Solution {    
    private String[] map = {"", "", "abc", "def", "ghi", "jkl",
									"mno", "pqrs", "tuv", "wxyz"};
    private List<String> list = new LinkedList<String>();    
    public List<String> letterCombinations(String digits) {
        if(digits != null && digits.length() > 0){
            for(int i = 0; i < digits.length(); i++){
                if(digits.charAt(i) == '0' || digits.charAt(i) == '1') 
					return list;
            }
            recursion(digits, 0, "");
        }
        return list;
    }
    
    private void recursion(String digits, int position, String prefix){
        if(position == digits.length()){
            list.add(prefix);
            return;
        }
        
        String cur = map[digits.charAt(position) - '0'];
        for(int i = 0; i < cur.length(); i++){
            recursion(digits, position + 1, prefix + cur.charAt(i));
        }
    }
}