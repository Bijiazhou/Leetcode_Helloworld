package com.company;

public class invertTree226 {


//    俺寻思应该用递归
    public TreeNode invertTree(TreeNode root) {
        TreeNode myroot = root;
        helper(root);
        return myroot;
    }


    public void helper(TreeNode root){
        //        递归终止条件
        if(root == null)
            return ;
//        处理过程
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;

//        下探
            helper(root.left);
            helper(root.right);
//        清理
    }



    public static void main(String[] args) {

    }
}
