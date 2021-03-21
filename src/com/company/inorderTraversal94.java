package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class TreeNode{
    int val;
    TreeNode left,right;
    TreeNode(){
    }
    TreeNode(int value){
        this.val = value;
        this.left = null;
        this.right = null;
    }
    TreeNode(int value,TreeNode left,TreeNode right){
        this.val = value;
        this.left = left;
        this.right = right;
    }
}

public class inorderTraversal94 {

    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        pre_order(root,ans);
        return ans;
    }

    public void pre_order(TreeNode root,List<Integer> list){
        if(root == null)
            return;
        pre_order(root.left,list);
        list.add(root.val);
        pre_order(root.right,list);
    }

//    非递归实现 传统方法
    public List<Integer> inorderTraversal2(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }

        return ans;
    }

    //非递归实现 染色法 1白色 2灰色
    public List<Integer> inorderTraversal3(TreeNode root){
//        默认 1是第一次访问 2是第二次访问 直接输出
        HashMap<TreeNode,Integer> map = new HashMap();
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if(root == null)
            return ans;

        stack.push(root);
        map.put(root,1);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(map.get(node) == 1){
//                中序遍历  左根右 调整这里的顺序就可以做到

                if(node.right != null){
                    stack.push(node.right);
                    map.put(node.right,1);
                }

                stack.push(node);
                map.put(node,2);

                if(node.left != null){
                    stack.push(node.left);
                    map.put(node.left,1);
                }
            }else {
                ans.add(node.val);
            }
        }
        return ans;
    }

        public static void main(String[] args) {
        TreeNode a,b,c,d;
        d = new TreeNode(7);
        b = new TreeNode(3);
        c = new TreeNode(5,null,d);
        a = new TreeNode(1,b,c);


        new inorderTraversal94().inorderTraversal3(a);
    }
}
