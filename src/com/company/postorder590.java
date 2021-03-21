package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}
    public Node(int _val) {
        val = _val;
    }
    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class postorder590 {

    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;

        post(root,ans);
        return ans;
    }

    private void post(Node root, List<Integer> ans) {
        if (root == null)
            return;

        for (Node i : root.children) {
            post(i,ans);
        }
        ans.add(root.val);
    }

    public List<Integer> postorder2(Node root) {
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
                stack.push(node);
                map.put(node, 2);

                for (int i = node.children.size() -1 ; i >= 0; i--) {
                    if(node.children.get(i) != null){
                        stack.push(node.children.get(i));
                        map.put(node.children.get(i),1);
                    }
                }

            }else {
                ans.add(node.val);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
