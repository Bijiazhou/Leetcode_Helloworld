package com.company;

import java.util.*;
import java.util.LinkedList;

public class StackLearn {
//    queue 队 stack 栈
//    Deque 双端队 priorittyQueue 优先级队列
public static void main(String[] args) {

    Queue<Integer> queue = new LinkedList<Integer>();
//    offer 是不抛出异常的add
//    poll是不抛出异常的remove
    queue.offer(1);
    queue.offer(2);
    queue.offer(3);
    queue.poll();
    queue.poll();
//    queue.add()
//    queue.remove()

    Stack<String> stack = new Stack<String>();
    stack.push("he");
    stack.push("ll");
    stack.push("o!");

    stack.pop();
    stack.pop();

    Deque<String> deque = new LinkedList<String>();
    deque.addFirst("hello");
    deque.addFirst("begin");
    deque.addLast("world");
    deque.offerLast(" !");
    System.out.println(deque.peek());

//    优先队列
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    });
//    priorityQueue.comparator();

}
}
