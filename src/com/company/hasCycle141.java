package com.company;

import java.util.*;

public class hasCycle141 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    //思路1:正常想法 遍历呗 用hashmap存一下 每一个都存一下 如果有环形链表的话一定会有key的重复
//    a.next == b.next
    public static boolean hasCycle1(ListNode head) {
        Map<ListNode,Integer> arr = new HashMap<ListNode,Integer>();
        ListNode cur = head;
//        a.next == b.next
        while (cur != null){
            if(arr.containsKey(cur))
                return true;
            arr.put(cur,cur.val);
            cur = cur.next;
        }
        return false;
    }

    //[x]思路1.5 如果遍历之后存在null 那不就说明不是换了么  不行
    public static boolean hasCycle1_5(ListNode head) {
        ListNode cur = head;
//        a.next == b.next
        while (cur != null){
            cur = cur.next;
            if (cur == null)
                return false;
        }
        return false;
    }

    //思路1.6:正常想法 遍历呗 用set存一下 每一个都存一下 如果有环形链表的话一定会有key的重复
//    a.next == b.next
    public static boolean hasCycle1_6(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();
        ListNode cur = head;
//        a.next == b.next
        while (cur != null){
            if(set.contains(cur))
                return true;
            set.add(cur);
            cur = cur.next;
        }
        return false;
    }

//    思路2：递归不行 但是有一个快慢指针的办法  龟兔赛跑！
    public static boolean hasCycle2(ListNode head) {

        ListNode fast = head,slow = head;
        if(fast == null || fast.next == null)
            return false;

        do{
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow)
                return true;
        }
        while (fast != null && fast.next != null);
        return false;
    }

    public static void main(String[] args) {
        ListNode c =new ListNode(4,null);
        ListNode b =new ListNode(3,c);
        ListNode a =new ListNode(2,b);
        ListNode head =new ListNode(1,a);
        c.next = a;

        System.out.println(hasCycle1_6(head));

    }
}
