package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder429 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();

        bfs(root,0,ans);

        return ans;
    }

    public void bfs(Node root,int level,List<List<Integer>> ans){
        if(root == null)
            return;

        if(level >= ans.size()){
            List<Integer> sublist = new ArrayList<>();
            sublist.add(root.val);
            ans.add(sublist);
        }else {
            ans.get(level).add(root.val);
        }

        for (Node i : root.children){
            if(i != null){
                bfs(i,level+1,ans);
            }
        }
    }

//    常规bfs 非递归 队列
    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root == null)
            return ans;
        queue.add(root);

        while (!queue.isEmpty()){
            List<Integer> sublist =  new ArrayList<>();
//            System.out.println(node.val);
            int size = queue.size();
            for (int i = 0 ; i< size; i++){
                Node node = queue.poll();
                sublist.add(node.val);
                queue.addAll(node.children);
            }
            ans.add(sublist);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
