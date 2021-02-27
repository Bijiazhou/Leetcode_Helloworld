package com.company;

public class swapPairs24 {
    //    默认给的链表定义
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

//    思路一:正常迭代法 走两个换一次 走两个换一次 然后保存第一个返回就可以
    public static ListNode swapPairs(ListNode head) {
        ListNode cur = head;
        ListNode first = head;
        boolean flag=true;
        ListNode  pre = head;
//       ***  就是因为少了一个pre 耗费了好久的时间
        while (cur != null && cur.next != null){
            if(flag){
                first = cur.next;
                flag = false;
            }
            ListNode next = cur.next;
            ListNode next2 = cur.next.next;

            pre.next = next;
            next.next = cur;
            cur.next = next2;
            pre = cur;
            cur = cur.next;
        }
        return first;
    }

//    再来看第二个方法 所谓的递归方案 好好理解  看看人家是怎么想的
//    换的
    public static ListNode swapPairs2(ListNode head) {
        // 执行过程 结束条件
        if(head == null || head.next == null)
            return head;
        //1 2 3 4 next = 2 head = 1
        ListNode next = head.next;
        //1 2 3 4 next = 2 head = 1->(4)
        head.next = swapPairs(next.next);
        //1 2 3 4 next = 2->1 head = 1->(4)
        next.next = head;
        return next;
    }

    public static void main(String[] args) {
        ListNode c =new ListNode(4,null);
        ListNode b =new ListNode(3,c);
        ListNode a =new ListNode(2,b);
        ListNode head =new ListNode(1,a);



        swapPairs(head);


    }
}
