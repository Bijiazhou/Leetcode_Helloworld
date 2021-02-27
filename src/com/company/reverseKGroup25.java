package com.company;
//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
//        k 是一个正整数，它的值小于或等于链表的长度。
//        如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序

import java.util.Stack;

public class reverseKGroup25 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //  [x] 思路一  正常遍历方法 好好想想之前那个咋写的
//    有一些问题  还不可以 暂时抛弃
    // 1->2->3->4->5
    // 3->2->1->4->5
    public static ListNode reverseKGroup1(ListNode head, int k) {

        ListNode cur = head;
        ListNode prev = null;

        ListNode groupCurHead = cur;
        ListNode groupFirstHead = null;
        ListNode TMPHEAD = null;
        boolean flag = true;
        int a = 0;

        while (shouldAhead(cur, k)) {
//            在这k个节点之间进行操作 在这里就转化为了 在k组之内完全翻转链表的问题
//            好像可以用栈（没法以时间换空间了 空间超了吧）

            groupCurHead = cur;
            for (int i = 0; i < k; i++) {
//                确定入口
                if (i == k - 1) {
                    if (flag) {
                        groupFirstHead = cur;
                        flag = false;
                    }
                }
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }

//            大连线
//            321 654 1->6
//            1.上一轮第一个元素现在是这一轮中前一组的最后一个元素，应该指向这一轮本组的的最后一个元素
            if (a > 0) {
                TMPHEAD.next = prev;
            }
            TMPHEAD = groupCurHead;
            a++;
        }

        if (groupFirstHead != null)
            return groupFirstHead;
        return head;
    }

    //        cur.next*k != null
    public static boolean shouldAhead(ListNode cur, int k) {
        for (int i = 0; i < k; i++) {
            if (cur == null)
                return false;
            cur = cur.next;
        }
        return true;
    }

    //思路2 看看别人写的 这种题都可以通过设置一个dummy虚节点来思考一波
    // 把单独的链表翻转的函数抽取出来
    public static ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
//        dummy永远指向头结点
        dummy.next = head;
//        end就负责向前冲 pre负责压阵
//        start 负责要翻转的第一个 next是保存断开的那个
        ListNode end = dummy, pre = dummy;

        while (end.next != null) {
            for (int i = 0; i < k & end != null; i++) end = end.next;
            if (end == null)
                break;

            ListNode start = pre.next;
            ListNode next = end.next;

//因为需要翻转整条链表  所以设置一个边界 用next保存这个边界 断一下
            end.next = null;
//            翻转后返回的是翻转后的第一个节点
            pre.next = reverseList(start);
//            start反而变成最后一个节点了 用来跟后续相连
            start.next = next;
//            之后pre和end双指针归位
            pre = start;
            end = start;
        }
        return dummy.next;
    }

    public static ListNode reverseList(ListNode head) {
        //单链表为空或只有一个节点，直接返回原单链表
        if (head == null || head.next == null) {
            return head;
        }
        //前一个节点指针
        ListNode preNode = null;
        //当前节点指针
        ListNode curNode = head;
        //下一个节点指针
        ListNode nextNode = null;
        while (curNode != null) {
            nextNode = curNode.next;//nextNode 指向下一个节点,保存当前节点后面的链表。
            curNode.next = preNode;//将当前节点next域指向前一个节点   null<-1<-2<-3<-4

            preNode = curNode;//preNode 指针向后移动。preNode指向当前节点。
            curNode = nextNode;//curNode指针向后移动。下一个节点变成当前节点
        }
        return preNode;
    }

    //    思路3 递归 说实话有点害怕递归昂
    public static ListNode reverseKGroup3(ListNode head, int k) {
        ListNode tail = head;
        for(int i = 1; i < k;i++)
        {       //由于没有使用dummy节点，所以这里向后移动了k-1个节点
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        if(tail ==null) {         //这里需要对第k个节点特判，否则会空指针
            return head;
        }
        ListNode next = tail.next;  //next指向第k+1个节点
        tail.next =null;
        ListNode curHead = reverseList2(head);

        head.next = reverseKGroup3(next, k);
        return curHead;
}

//          思路4 栈和递归相结合
    public static ListNode reverseKGroup4(ListNode head, int k) {
        ListNode des = head;
        Stack<ListNode> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            if (des == null)
                return head;
            stack.push(des);
            des = des.next;
        }

        ListNode begin = stack.pop();
//        保存next用于下一场
        ListNode next = begin.next;
//        这一组的头结点 用于返回
        ListNode backUp = begin;

        while (!stack.empty()){
            begin.next = stack.pop();
            begin = begin.next;
        }

        begin.next = reverseKGroup4(next,k);
        return backUp;
    }

    public  static  ListNode reverseList2(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode cur = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }


        public static void main(String[] args) {

        ListNode g =new ListNode(7,null);
        ListNode f =new ListNode(6,g);
        ListNode d =new ListNode(5,f);
        ListNode c =new ListNode(4,d);
        ListNode b =new ListNode(3,c);
        ListNode a =new ListNode(2,b);
        ListNode head =new ListNode(1,a);

        ListNode cur = reverseKGroup4(head,2);

        while (cur != null){
            System.out.println(cur.val);
            cur=cur.next;
        }
    }
}
