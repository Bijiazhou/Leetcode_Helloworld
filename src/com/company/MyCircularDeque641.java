package com.company;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */

//直接用linkedlist
public class MyCircularDeque641 {


    LinkedList<Integer> deque;
    int length = 0;
    int curLength = 0;
    int curHead = 0, curEnd = 0;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque641(int k) {
//        deque = new ArrayList<Integer>(k);
        deque = new LinkedList<Integer>();
        length = k;
        curLength = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(curLength + 1 <= length) {
            deque.addFirst(value);
            curLength ++;
        }
        else
            return false;
        return  true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(curLength + 1 <= length) {
            deque.addLast(value);
            curLength ++;
        }
        else
            return false;
        return  true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(curLength <= 0) {
            return false;
        }
        else{
            deque.removeFirst();
            curLength --;
        }
        return  true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(curLength <= 0) {
            return false;
        }
        else{
            deque.removeLast();
            curLength --;
        }
        return  true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(curLength > 0)
            return deque.getFirst();
        else
            return -1;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(curLength > 0)
            return deque.getLast();
        else
            return -1;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (curLength == length);
    }

    public static void main(String[] args) {
        int k = 3;
        MyCircularDeque641 circularDeque = new MyCircularDeque641(k);
        circularDeque.insertLast(1);			        // 返回 true
        circularDeque.insertLast(2);			        // 返回 true
        circularDeque.insertFront(3);			        // 返回 true
        circularDeque.insertFront(4);			        // 已经满了，返回 false
        circularDeque.getRear();  				// 返回 2
        circularDeque.isFull();				        // 返回 true
        circularDeque.deleteLast();			        // 返回 true
        circularDeque.insertFront(4);			        // 返回 true
        circularDeque.getFront();				// 返回 4

    }
}

//自己实现一个链表
class MyCircularDeque {

    class Node{
        int val;
        Node prev;
        Node next;
        Node(int vale){
            this.val = vale;
        }
    }


//    LinkedList<Integer> deque;
    int length = 0;
    int curLength = 0;
    Node curHead, curEnd;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        length = k;
        curLength = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(curLength + 1 <= length) {
            Node node = new Node(value);
//            这个时候判断dummy节点
            if(curHead == null){
                curHead = node;
                node.next = null;
            }else {
                node.next = curHead;
                curHead.prev = node;
                curHead = node;
            }
            if(curEnd == null)
                curEnd = node;
            curLength ++;
        }
        else
            return false;
        return  true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(curLength + 1 <= length) {
            Node node = new Node(value);
//            这个时候判断dummy节点
            if(curEnd == null)
                curEnd = node;
            else {
                node.prev = curEnd;
                curEnd.next = node;
                curEnd = node;
            }
            if(curHead == null){
                curHead = node;
            }
            curLength ++;
        }
        else
            return false;
        return  true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(curLength <= 0) {
            return false;
        }
        else{
            Node tmp = curHead.next;
            if(tmp != null){
                curHead.next = null;
                tmp.prev =null;
            }else {
                curEnd = null;
            }
            curHead = tmp;
            curLength --;
        }
        return  true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(curLength <= 0) {
            return false;
        }
        else{
            Node tmp = curEnd.prev;
            if(tmp != null){
                curEnd.prev = null;
                tmp.next =null;
            }else {
                curHead = null;
            }
            curEnd = tmp;
            curLength --;
        }
        return  true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(curLength > 0 && curHead != null)
            return curHead.val;
        else
            return -1;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(curLength > 0 && curEnd != null)
            return curEnd.val;
        else
            return -1;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return curLength == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (curLength == length);
    }

    public static void main(String[] args) {
        int k = 3;
        MyCircularDeque circularDeque = new MyCircularDeque(k);
        circularDeque.insertLast(1);			        // 返回 true
        circularDeque.insertLast(2);			        // 返回 true
        circularDeque.insertFront(3);			        // 返回 true
        circularDeque.insertFront(4);			        // 已经满了，返回 false
        circularDeque.getRear();  				// 返回 2
        circularDeque.isFull();				        // 返回 true
        circularDeque.deleteLast();			        // 返回 true
        circularDeque.insertFront(4);			        // 返回 true
        circularDeque.getFront();				// 返回 4

    }
}

