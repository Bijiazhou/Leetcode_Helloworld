package com.company;
//  假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//  每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//  注意：给定 n 是一个正整数

import java.util.HashMap;
import java.util.Map;

public class climbStairs70 {
    private static int count = 0;
    static Map map = new HashMap<>();

    //    思路一 试试递归,反正这么长一段路，走一步走两步都可以，直到最后还剩下一两步的时候 就说明走到头了，算是一次成功
//    不知道为什么评测机过不了 是因为没有初始化全局变量
//    但是其实也可以不用递归 开三个变量去解决问题
    public static int solution1(int n){
        if(n == 1) {
            count ++;
            return 1;
        }
        if (n == 2) {
            count += 2;
            return 2;
        }
        solution1(n-1);
        solution1(n-2);
        return count;
    }


//    思路一 优化版 使用数组优化部分思想 不用重复计算递归的一部分东西
    public static int solution1_new(int n , int[] memo){
        if(memo[n]>0)
            return memo[n];
        if(n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        memo[n] = solution1_new(n-1,memo) + solution1_new(n-2,memo);
        return memo[n];
}


//    思路2 用for循环满足这个问题的递归 其实最后想的是一样的
    public static int solution2(int n){
        int f1 = 1, f2 = 2, f3 =3;
        if(n <= 2)
            return n;
        for(int i = 2; i<n ;i++){
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }


//    思路3 动态规划 最开始想到了但是不会做 哈哈哈
//    无论如何都是在别人的基础上走一步或者走两步上来

    public static int solution3(int n){

        if(n == 1)
            return 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        int i = 3;
        while (i <= n){
            dp[i] = dp[i-1]+dp[i-2];
            i++;
        }
        return dp[n];
}

//思路4 用map空间换时间 其实跟数组差不多
    public int solution4(int n) {
        if(n<3)
            return n;
        else {
            int x,y;
            if((map.get(n-1) != null) &&(map.get(n-2) != null)){
                x = (int) map.get(n-1);
                y= (int) map.get(n-2);
            }else {
                x = solution4(n-1);
                y = solution4(n-2);
                map.put(n-1,x);
                map.put(n-2,y);
            }
            return x+y;
        }
    }


//    自己尝试用递归实现
    public int climbStairs5(int n) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        return  climbStairs_helper(n,map);
    }

    public int climbStairs_helper(int n,HashMap<Integer,Integer> map) {

//        终止条件
        if (n == 1) return 1;
        if (n == 2) return 2;

//        处理
        if (map.containsKey(n))
            return map.get(n);
        else {
//            下一层
            int val = climbStairs_helper(n - 1, map) +
                    climbStairs_helper(n - 2, map);
            map.put(n, val);
            return val;
        }
    }

    public static void main(String[] args) {
        count = 0;
        int n  = 4;

        int memo[] = new int[n+1];

//        System.out.println(solution1_new(n,memo));

        System.out.println(solution3(12));
    }
}
