package com.company;


        //    JAVA链表
public class LinkedList {

        Node head; // 头结点

        /* Linked list Node*/
        class Node {
            int data;
            Node next;
            // 构造函数

            Node(int d) {
                data = d;
                next = null;
            }
        }

//        标准的插入
        public  LinkedList InsertNode(LinkedList list, int data){
            // Create a new node with given data
            Node new_node = new Node(data);
            new_node.next = null;

            // If the Linked List is empty,
            // 如果是空的 ，那就直接作为头结点
            if (list.head == null) {
                list.head = new_node;
            }
            else {
                // Else traverse till the last node
                // and insert the new_node there
                Node last = list.head;
                while (last.next != null) {
                    last = last.next;
                }

                // Insert the new_node at last node
                last.next = new_node;
            }

            // Return the list by head
            return list;
        }

//        打印
        public void printList(LinkedList list){
            if(list.head == null) {
                System.out.println("LinkedList 是空的");
            }
            else {
                Node cur = list.head;
                while (cur != null){
                    System.out.println(cur.data + " ");
                    cur = cur.next;
                }

            }
        }


//        删除元素
        public LinkedList deleteList(LinkedList list,int data){
//            思路：首先遍历找到这个元素，找不到退出
//            找到后如果1.在head，直接赋值head 2.在其他地方重新连接一下

//            列表为空
            if(list.head == null)
                return null;

            else {
                Node cur = list.head;
                Node prev = null;
                if(cur.data == data){
                    list.head = cur.next;
                }else {
                    while (cur != null){
                        if(cur.data == data){
                            prev.next = cur.next;
                            return list;
                        }
                        prev = cur;
                        cur = cur.next;
                    }
                }
            }

            return list;
        }

//        在具体位置删除
        public LinkedList deleteAtPosition(LinkedList list,int pos){
//            思路;1 如果是空先报错 2先去找位置，如果位置超标也报错 3找到位置如果是头部 如果不是头部
            if(list == null) {
                System.out.println("列表为空 报错");
                return null;
            }

            Node cur = list.head,prev = null;
            int count = 0;

            if(pos == 0){
                list.head = cur.next;
                System.out.println(
                        pos + " position element deleted");
                return list;
            }

            while (cur != null){
                if(count == pos){
                    prev.next = cur.next;
                    System.out.println(
                            pos + " position element deleted");
                    return list;
                }
                prev = cur;
                cur = cur.next;
                count++;
            }

            if(pos > count) {
                System.out.println("pos太大 报错");
                return null;
            }

            return list;
        }


                public static void main(String[] args) {
        // write your code here
        System.out.println("Hello World");

        LinkedList linkedList = new LinkedList();
        linkedList.InsertNode(linkedList,1);
        linkedList.InsertNode(linkedList,2);
        linkedList.InsertNode(linkedList,3);
        linkedList.InsertNode(linkedList,5);

        linkedList.printList(linkedList);
//
//        linkedList.deleteAtPosition(linkedList,0);
//        linkedList.printList(linkedList);

    }
}
