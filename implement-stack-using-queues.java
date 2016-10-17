/*
Source : https://leetcode.com/problems/implement-stack-using-queues/
Author : Jiayi Lei
Date   : Jul 6, 2015

Description:
    Implement the following operations of a stack using queues.
        push(x) -- Push element x onto stack.
        pop() -- Removes the element on top of the stack.
        top() -- Get the top element.
        empty() -- Return whether the stack is empty.
Notes:
    You must use only standard operations of a queue -- which means only push 
    to back, peek/pop from front, size, and is empty operations are valid.
    Depending on your language, queue may not be supported natively. You may 
    simulate a queue by using a list or deque (double-ended queue), as long as 
    you use only standard operations of a queue.
    You may assume that all operations are valid (for example, no pop or top 
    operations will be called on an empty stack).
Update (2015-06-11):
    The class name of the Java function had been updated to MyStack instead of 
    Stack.

Credits:
    Special thanks to @jianchao.li.fighter for adding this problem and all test
    cases.
    
Tags: Stack; Data Structure
*/

// version 1: using 2 queues
class MyStack {
    Queue<Integer> queue1 = new LinkedList<Integer>();
    Queue<Integer> queue2 = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        queue1.offer(x);
        while(!queue2.isEmpty()){
            queue1.offer(queue2.poll());
        }
        while(!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue2.poll();
    }

    // Get the top element.
    public int top() {
        return queue2.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue2.isEmpty();
    }
}

// version 2: using only 1 queue
class MyStack {
    Queue<Integer> queue = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        queue.offer(x);
        
        int size = queue.size();
        while(size-- > 1) queue.offer(queue.poll());
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.poll();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
