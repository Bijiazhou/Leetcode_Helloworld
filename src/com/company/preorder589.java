package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class preorder589 {

    public List<Integer> perorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;

        pre(root,ans);
        return ans;
    }

    public void pre(Node root, List<Integer> ans) {
        if (root == null)
            return;

        ans.add(root.val);

        for (Node i : root.children) {
            pre(i,ans);
        }
    }

    public List<Integer> perorder2(Node root) {
        List<Integer> ans = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        HashMap<Node,Integer> map = new HashMap<>();
        if(root == null)
            return ans;

        stack.push(root);
        map.put(root,1);

        while (!stack.isEmpty()){
            Node node = stack.pop();

            if(map.get(node) == 1) {


                for (int i = node.children.size() -1 ; i >= 0; i--) {
                    if(node.children.get(i) != null){
                        stack.push(node.children.get(i));
                        map.put(node.children.get(i),1);
                    }
                }

                stack.push(node);
                map.put(node, 2);

            }else {
                ans.add(node.val);
            }
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
