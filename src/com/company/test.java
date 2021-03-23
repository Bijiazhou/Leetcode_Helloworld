package com.company;

import javax.sql.rowset.spi.SyncResolver;
import java.util.*;

//草稿版
public class test {

    Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    int[] memo = new int[100+1];

    // 以空间换时间 三变量法恶心人 f1 f2 f3
    public int climbStairs(int n) {
        if(map.containsKey(n))
            return map.get(n);
        if(n == 1)
            return 1;
        else if(n == 2)
            return 2;
        else{
            map.put(n,climbStairs(n-1)+climbStairs(n-2));
            return climbStairs(n-1)+climbStairs(n-2);
        }
    }

    public void test1 (MyTree.TreeNode root){
        List<Integer> ans = new ArrayList<>();
        HashMap<MyTree.TreeNode,Integer> map = new HashMap<>();
        Stack<MyTree.TreeNode> stack = new Stack<>();
        map.put(root,1);
        stack.add(root);

        while (!stack.isEmpty()){
            MyTree.TreeNode node = stack.pop();
            if(map.get(node) == 1){
//                左根右
                if(node.left != null){
                    map.put(node.left,1);
                    stack.push(node.left);
                }

                map.put(node,2);
                stack.push(node);

                if(node.right != null){
                    map.put(node.right,1);
                    stack.push(node.right);
                }

            }else {
                ans.add(node.val);
            }
        }

    }



    public void test_bfs_order(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();

        test_bfs(root,0,ans);

    }

    public void test_bfs(TreeNode root,int level ,List<List<Integer>> ans){
        if(root == null)
            return;

        if(level > ans.size()){
            List<Integer> sub = new ArrayList<>();
            sub.add(root.val);
            ans.add(sub);
        }else {
            ans.get(level).add(root.val);
        }

        if(root.left != null)
            test_bfs(root.left,level+1,ans);

        if(root.right != null)
            test_bfs(root.right,level+1,ans);
    }


    public void test_dfs(TreeNode root){
        if(root == null)
            return;

        System.out.println(root.val);

        test_dfs(root.left);
        test_dfs(root.right);
    }



    public static void main(String[] args) {

        Character ch = 'a';

        StringBuilder sb = new StringBuilder();
        sb.append(100);
        sb.append("sfdzfs");
        sb.append("ddd");

//        String aaa = "123,789,1019";
//        for (String i: aaa.split(",")){
//            System.out.println(i);
//        }
//        sb.reverse()
        System.out.println(sb.substring(0,4));

    }
}
