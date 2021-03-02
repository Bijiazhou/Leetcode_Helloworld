package com.company;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

//这题什么意思
//山本 我日你先人
public class MinStack155 {
//    思路一 以空间换时间
//    数据栈
    Deque<Integer> dataStack;
//    最小栈 模拟栈元素的进出 与data同步
    Deque<Integer> minStack;

    /** initialize your data structure here. */
    public  MinStack155() {
        dataStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        dataStack.push(x);
        minStack.push(Math.min(minStack.peek(),x));
    }

    public void pop() {
        if(!dataStack.isEmpty() && !minStack.isEmpty()) {
            dataStack.pop();
            minStack.pop();
        }
    }

    public int top() {
        if(!dataStack.isEmpty() && !minStack.isEmpty()) {
            return dataStack.peek();
        }
        return -1;
    }

    public int getMin() {
        return minStack.peek();
    }



    public static void main(String[] args) {
        MinStack155 obj = new MinStack155();
          obj.push(2);
          obj.pop();
          int param_3 = obj.top();
          int param_4 = obj.getMin();
    }
}
