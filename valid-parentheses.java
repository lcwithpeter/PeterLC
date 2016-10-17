/*
Source : https://leetcode.com/problems/valid-parentheses/
Author : Jiayi Lei
Date   : Jun 11, 2015
Description:
    Given a string containing just the characters '(', ')', '{', '}', '[' and 
    ']', determine if the input string is valid.
    The brackets must close in the correct order, "()" and "()[]{}" are all 
    valid but "(]" and "([)]" are not.
Tag: Stack; String
*/

// version 1
public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;
        Stack<Character> st = new Stack<Character>();
        for(int index = 0; index < s.length(); index++){
            char curChar = s.charAt(index);
            switch(curChar){
                case '(': case '[': case '{':
                    st.push(curChar);
                    break;
                case ')': case ']': case '}':
                    if(st.isEmpty()) return false;
                    else{
                        char first = st.pop();
                        if(!isPair(first, curChar)) return false;
                        break;
                    }
                default: break;
            }
        }
        if(!st.isEmpty()) return false;
        return true;
    }
    private boolean isPair(char first, char second){
        return first == '(' && second == ')' ||
            first == '[' && second == ']' ||
            first == '{' && second == '}';
    }
}

// version 2
public class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0) return true;
        Stack<Character> st = new Stack<Character>();
        for(Character cur : s.toCharArray()){
            if(cur == '(' || cur == '[' || cur == '{')
                st.push(cur);
            else if(cur == ')' || cur == ']' || cur == '}'){
                if(st.isEmpty()) return false;
                if(!checker(st.pop(), cur)) return false;
            }else return false;
        }
        return st.isEmpty();
    }
    private boolean checker(char a, char b){
        return (a == '(' && b == ')') || 
            (a == '[' && b == ']') ||
            (a == '{' && b == '}'); 
    }
}
