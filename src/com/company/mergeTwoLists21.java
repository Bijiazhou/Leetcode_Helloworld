package com.company;

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class mergeTwoLists21 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

//    暴力法 我最喜欢暴力法么么哒
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur1 = l1,cur2 = l2;

        if(l1 == null && l2 == null)
            return null;

        int count = 0;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while(cur1 != null){
            arr.add(cur1.val);
            cur1= cur1.next;
            count++;
        }
        while (cur2 != null) {
            arr.add(cur2.val);
            cur2 = cur2.next;
            count++;
        }
//        第一种排序
        Collections.sort(arr);
        ListNode pre = new ListNode(arr.get(0));
        ListNode dummy = pre;
        for (int i = 1; i < count; i++) {
            ListNode cur = new ListNode(arr.get(i));
            pre.next = cur;
            pre = cur;
        }

        return dummy;
    }

//    思路2:除了暴力法还有其他的办法么
    //正常的想法 肯定就是new一个结果链表 然后每次都比大小
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode cur1 = l1,cur2 = l2;
        ListNode result = new ListNode(0);
        ListNode dummy = new ListNode(0);

        if(l1 == null && l2 == null)
            return null;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

//        虚节点指向头
        dummy = result;

        while (cur1 != null && cur2 != null) {
            if (cur1.val > cur2.val) {
                //那就让新的直接连上
                ListNode node = new ListNode(cur2.val);
                result.next = node;
                result = node;
                cur2 = cur2.next;
            } else {
                //那就让新的直接连上
                ListNode node = new ListNode(cur1.val);
                result.next = node;
                result = node;
                cur1 = cur1.next;
            }
        }

        if(cur1 != null){
            result.next = cur1;
        }
        else if(cur2 != null){
            result.next = cur2;
        }

        return dummy.next;
    }


    //思路3：递归
    // 递归终止条件： 任意一个为空
    // 递归处理：每次比对的时候选取最小的 然后进行操作 步伐进如何处理
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if(l1 == null )
            return l2;
        if(l2 == null)
            return l1;
        if(l1.val < l2.val) {
//            就这句最重要 每一次小的那个都指向下次递归小的那个
            l1.next = mergeTwoLists3(l1,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists3(l1,l2);
            return l2;
        }

    }
        public static void main(String[] args) {
            reverseKGroup25.ListNode g =new reverseKGroup25.ListNode(7,null);
            reverseKGroup25.ListNode f =new reverseKGroup25.ListNode(6,g);
            reverseKGroup25.ListNode d =new reverseKGroup25.ListNode(5,f);
            reverseKGroup25.ListNode c =new reverseKGroup25.ListNode(4,d);
            reverseKGroup25.ListNode b =new reverseKGroup25.ListNode(3,c);
            reverseKGroup25.ListNode a =new reverseKGroup25.ListNode(2,b);
            reverseKGroup25.ListNode head =new reverseKGroup25.ListNode(1,a);




    }
}
