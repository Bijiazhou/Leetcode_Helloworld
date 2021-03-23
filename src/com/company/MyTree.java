package com.company;

import apple.laf.JRSUIUtils;
import com.sun.source.tree.Tree;

import java.util.*;
import java.util.LinkedList;

//最好要记住
public class MyTree {

    static class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int value){
            this.val = value;
            left = null;
            right = null;
        }
    }

    ArrayList<Integer> list = new ArrayList<Integer>();

//    几种遍历
//    遍历一般采用递归的形式
//    pre-order 前序遍历  根 左 右

//    第一种:递归遍历
    public void preorder_recu(TreeNode root){
        if(root != null){
            list.add(root.val);
            preorder_recu(root.left);
            preorder_recu(root.right);
        }
    }

    public void preorder_not_resu(TreeNode root){
        if(root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }
    }


//    in-order 中序遍历   左 根 右
    public void inorder_resu(TreeNode root){
        if(root != null){
            inorder_resu(root.left);
            list.add(root.val);
            inorder_resu(root.right);
        }
    }

//    非递归
    public void inorder_not_resu(TreeNode root){
        if(root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()){
//            对于每一个节点 先把所有的左儿子都弄进去
            while (root != null){
                stack.push(root);
                root = root.left;
            }

//            左 跟 右
            if(!stack.isEmpty()){
//                重新赋值 根节点
                root = stack.pop();
                System.out.println(root.val);
                root = root.right;
            }
        }
    }


//    post-order 后序遍历  左 右 根
    public void postorder_resu(TreeNode root){
        if(root != null){
            postorder_resu(root.left);
            postorder_resu(root.right);
            list.add(root.val);
        }
    }

//    非递归 左右跟
    public void postorder_not_resu(TreeNode root){
        if(root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> ans = new Stack<>();

        stack.push(root);
//        用栈来存 和 输出 所以反这来 左 右 跟
        while (!stack.isEmpty()){
            root = stack.pop();
            ans.push(root);

            if (root.left != null)
                stack.push(root.left);

            if (root.right != null)
                stack.push(root.right);
        }

        while (!ans.isEmpty())
            System.out.println(ans.pop().val);
    }


//    BFS 宽度/广度优先搜索  先访问上层 在访问下一层 每一层从左到右

//    递归版本
    public List<List<Integer>> bfs_resu_order(TreeNode root) {
        if (root == null)
            return null;
        List<List<Integer>> list = new ArrayList<>();
        bfs_resu(root,0,list);
        return list;
    }

    public void bfs_resu(TreeNode root, int level , List<List<Integer>> list){
        if (root == null)
            return;

        if(level > list.size()){
            List<Integer> subList = new ArrayList<>();
            subList.add(root.val);
            list.add(subList);
        }else {
            list.get(level).add(root.val);
        }

        bfs_resu(root.left,level+1, list);
        bfs_resu(root.right,level+1, list);
    }

//    非递归版本
    public void bfs_not_resu(TreeNode root){
        if (root == null)
            return;
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        deque.addFirst(root);

        while (!deque.isEmpty()){
            TreeNode node = deque.pollFirst();
            System.out.println(node.val);
            if(node.left != null)
                deque.addLast(node.left);
            if(node.right != null)
                deque.addLast(node.right);
        }
    }

//    深度优先 先访问根节点 然后一路往左 之后右
    public void dfs_resu(TreeNode root){
        if (root == null)
            return;
        System.out.println(root.val);
        dfs_resu(root.left);
        dfs_resu(root.right);
    }

    public void dfs_not_resu(TreeNode root){
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }
    }

//    二叉树
//    二叉树是每个结点最多有两个子树的树结构。它有五种基本形态：二叉树可以是空集；根可以有空的左子树或右子树；或者左、右子树皆为空。


//    平衡二叉树
//    左子树和右子树的高度差不超过1

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(21);
        root.right.right = new TreeNode(18);
        root.right.left.left = new TreeNode(19);

        MyTree slotion = new MyTree();

//        slotion.preorder_recu(root);
//        for (Integer e : slotion.list){
//            System.out.println(e);
//        }
        slotion.dfs_resu(root);
    }
}
