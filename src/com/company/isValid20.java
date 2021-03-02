package com.company;
//     '('，')'，'{'，'}'，'['，']'

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class isValid20 {


    //思路一 正经思路 左边的符号入栈 右边的出栈 最后看栈有没有空
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character,Character> map = new HashMap<Character,Character>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('|| s.charAt(i) == '['|| s.charAt(i) == '{')
                stack.push(s.charAt(i));
            else {
                if(s.charAt(i) !=  map.get(stack.peek()) || stack.empty())
                    return false;
                else
                    stack.pop();
            }
        }

        return stack.empty();
    }

//    思路2 直接操作replace
    public boolean isValid2(String s){
        while (s.contains("()")||s.contains("[]")||s.contains("{}")){
            s = s.replace("()","");
            s = s.replace("[]","");
            s = s.replace("{}","");
        }
        return s.isEmpty();
    }

    public static void main(String[] args) {

        String a ="[[[(())]]]";
        if(new isValid20().isValid2(a))
            System.out.println("true");
        else
            System.out.println("false");

    }
}
