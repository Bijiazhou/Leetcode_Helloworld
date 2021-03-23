package com.company;

public class MyRecursion {

    public void recur(int level,int param){
//        终止条件
        if(level > 100)
            return;
//        处理
        process(level,param);

//        递归
        recur(level+1,param);

//        清理
    }

    private void process(int level, int param) {

    }

//    算阶乘
    public int Factorial(int n){
        if(n <= 1)
            return 1;
        return n *Factorial(n-1);
    }

    public static void main(String[] args) {
        System.out.println(new MyRecursion().Factorial(4));
    }
}
