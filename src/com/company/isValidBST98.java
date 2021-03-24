package com.company;

import java.util.HashMap;
import java.util.Stack;

public class isValidBST98 {


    private  boolean ans = true;

    public boolean isValidBST(TreeNode root) {
//        my_helper(root,arr);
        return inorder2(root);
    }

    public boolean isValidBst2(TreeNode root){
         return helper2(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper2(TreeNode root, long minValue, long maxValue) {
        if (root == null)
            return true;

        if(root.val <= minValue || root.val >= maxValue)
            return false;

        return helper2(root.left,minValue,root.val) && helper2(root.right,root.val,maxValue);
    }


    //    因为二叉搜索树的中序遍历是升序的 所以就可以这么解决
    public boolean inorder2(TreeNode root) {
        HashMap<TreeNode,Integer> map = new HashMap<TreeNode,Integer>();
        Stack<TreeNode> stack = new  Stack<>();
        double prev = - Double.MAX_VALUE;
        stack.push(root);
        map.put(root,1);

        while (!stack.isEmpty()){
            TreeNode  node = stack.pop();

            if(map.get(node) == 1){

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
                if(node.val <= prev)
                    return false;
                prev = node.val;
            }
        }
        return true;
    }


    public void my_helper(TreeNode root) {
        if(!ans)
            return;

        //        递归终止条件
        if (root.left != null && root.left.val >= root.val)
            ans = false;
        if (root.right != null && root.val >= root.right.val)
            ans = false;

//        处理
//        下探
        if (root.left != null)
            my_helper(root.left);
        if (root.right != null)
            my_helper(root.right);

        return;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
//        root.left.left = null;
//        root.left.right = null;
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(6);

        new isValidBST98().isValidBST(root);
    }
}
