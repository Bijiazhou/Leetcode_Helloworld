package com.company;

public class reverseList206 {
//    默认给的链表定义
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


//    正常思路 最基本的迭代一定要会
    public ListNode solution1(ListNode head) {
//        保存第一个头结点
        ListNode cur = head;
        ListNode prev = null;

        while (cur != null){
//            得新弄一个节点承接
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

//    思路2 递归 1.递归终结的条件 到头了就不递归了，说明得到终点 null
//    2.递归的要素 head.next.next = head 你得给我指回来
    public ListNode solution2(ListNode head) {
        if (head == null | head.next == null)
            return head;

//        别忘了拆掉指针 不然会变成环
        ListNode cur = solution2(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }

        public static void main(String[] args) {
    }
}
