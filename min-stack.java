/*
Source : https://leetcode.com/problems/min-stack/
Author : Jiayi Lei
Date   : Jun 17, 2015

Description:
    Design a stack that supports push, pop, top, and retrieving the minimum 
    element in constant time.
    
    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.
Tags: Stack; Data Structure
*/

// version 1
class MinStack {
    ArrayList<Integer> list = new ArrayList<Integer>();
    ArrayList<Integer> min = new ArrayList<Integer>();
    public void push(int x) {
        list.add(x);
        if(min.size() == 0) 
			min.add(x);
        else 
			min.add((x < min.get(min.size() - 1)) ? x : min.get(min.size() - 1));
    }

    public void pop() {
        list.remove(list.size() - 1);
        min.remove(min.size() - 1);
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        return min.get(min.size() - 1);
    }
}

// version 2
class MinStack {
    
    Stack<Integer> stNum;
    Stack<Integer> stMin;
    
    public MinStack(){
        stNum = new Stack<>();
        stMin = new Stack<>();
    }
    
    public void push(int x) {
        if(stNum.isEmpty()){
            stNum.push(x);
            stMin.push(x);
        }else{
            stNum.push(x);
            stMin.push(x < stMin.peek() ? x : stMin.peek());
        }
    }

    public void pop() {
        if(!stNum.isEmpty()){
            stNum.pop();
            stMin.pop();
        }
    }

    public int top() {
        return stNum.peek();
    }

    public int getMin() {
        return stMin.peek();
    }
}
