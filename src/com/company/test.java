package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    public static void main(String[] args) {

    }
}
