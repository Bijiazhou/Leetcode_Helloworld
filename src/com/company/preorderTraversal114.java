package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class preorderTraversal114 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return null;

        preorder(root,ans);
        return ans;
    }

    private void preorder(TreeNode root, List<Integer> ans) {
        if(root == null)
            return;

        ans.add(root.val);
        preorder(root.left,ans);
        preorder(root.right,ans);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        HashMap<TreeNode,Integer> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null)
            return null;

        stack.push(root);
        map.put(root,1);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();

            if(map.get(node) == 1){
                if(node.right != null){
                    map.put(node.right,1);
                    stack.push(node.right);
                }

                if(node.left != null){
                    map.put(node.left,1);
                    stack.push(node.left);
                }

                map.put(node,2);
                stack.push(node);
            }else {
                ans.add(node.val);
            }
        }

        return ans;
    }

    public List<Integer> preorderTraversal3(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null)
            return null;

        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            ans.add(node.val);

            if(node.right != null)
                stack.push(node.right);

            if(node.left != null)
                stack.push(node.left);


        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode a,b,c,d;
        d = new TreeNode(7);
        b = new TreeNode(3);
        c = new TreeNode(5,null,d);
        a = new TreeNode(1,b,c);

        List<Integer> ans =  new preorderTraversal114().preorderTraversal3(a);
    }
}
