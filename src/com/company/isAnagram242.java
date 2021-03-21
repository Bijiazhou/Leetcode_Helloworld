package com.company;

import java.sql.Connection;
import java.util.*;

public class isAnagram242 {
    //思路1 暴力！直接用map存一下当做计数器
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> s_map = new HashMap<Character,Integer>();
        Map<Character,Integer> t_map = new HashMap<Character,Integer>();

        if(s.length() != t.length())
            return false;

        for (int i = 0; i < s.length(); i++) {
            if(s_map.containsKey(s.charAt(i)))
                s_map.put(s.charAt(i),s_map.get(s.charAt(i)).intValue()+1);
            else
                s_map.put(s.charAt(i),1);
        }

        for (int i = 0; i < t.length(); i++) {
            if(t_map.containsKey(t.charAt(i)))
                t_map.put(t.charAt(i),t_map.get(t.charAt(i)).intValue()+1);
            else
                t_map.put(t.charAt(i),1);
        }

        return t_map.equals(s_map);
    }


    //思路2 更为暴力的排序 后直接看
    public boolean isAnagram2(String s, String t) {
        char[]s_tmp = s.toCharArray();
        char[]t_tmp = t.toCharArray();
        Arrays.sort(s_tmp);
        Arrays.sort(t_tmp);
        return Arrays.equals(s_tmp, t_tmp);
    }

        public static void main(String[] args) {
        System.out.println(new isAnagram242().isAnagram2("abcc","acbc"));
    }
}
