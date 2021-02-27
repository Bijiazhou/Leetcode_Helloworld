package com.company;

import java.util.HashSet;

public class detectCycle142 {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
            this.next = null;
        }
    }

//    正常思路 就是那啥直接用hashcet
    public ListNode detectCycle1(ListNode head) {
        ListNode cur = head;
        HashSet<ListNode> set = new HashSet<>();

        while (cur != null){
            if(set.contains(cur))
                return cur;
            set.add(cur);
            cur = cur.next;
        }
        return null;
    }

    //其他方法睡醒再说
//    还可以用快慢指针？ 以及数学推导 讲道理是有点变态 a + N(b + c) + b = a + m(b + c)+b
//    a + b =(n-2m)b+c n-2m是套的圈数
    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head,fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow){
                ListNode newnode = head;
                while (newnode != slow){
                    slow = slow.next;
                    newnode = newnode.next;
                }
                return  newnode;
            }
        }

        return null;
    }

        public static void main(String[] args) {

    }
}
