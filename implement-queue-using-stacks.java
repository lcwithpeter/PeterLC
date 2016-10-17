/*
Source : https://leetcode.com/problems/implement-queue-using-stacks/
Author : Jiayi Lei
Date   : Jul 6, 2015

Description:
    Implement the following operations of a queue using stacks.
        push(x) -- Push element x to the back of queue.
        pop() -- Removes the element from in front of queue.
        peek() -- Get the front element.
        empty() -- Return whether the queue is empty.
Notes:
    You must use only standard operations of a stack -- which means only push 
    to top, peek/pop from top, size, and is empty operations are valid. 
    Depending on your language, stack may not be supported natively. You may 
    simulate a stack by using a list or deque (double-ended queue), as long as 
    you use only standard operations of a stack.
    You may assume that all operations are valid (for example, no pop or peek 
    operations will be called on an empty queue).
    
Tags: Stack; Data Structure
*/

class MyQueue {
    Stack<Integer> st1 = new Stack<Integer>();
    Stack<Integer> st2 = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }
        st1.push(x);
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        st2.pop();
    }

    // Get the front element.
    public int peek() {
        return st2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return st2.isEmpty();
    }
}
