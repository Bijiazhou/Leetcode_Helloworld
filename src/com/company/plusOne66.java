package com.company;

import java.math.BigDecimal;
import java.util.Map;

public class plusOne66 {
//    给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
//    最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//    你可以假设除了整数 0 之外，这个整数不会以零开头。

    //思路一 常规想法 死于数组超长
    public static int[] plusOne(int[] digits) {

//        digits[digits.length-1]+=1;
//        正常思路肯定是把它转换为数字进行操作
        int times = digits.length-1;
        long  count = 0;
        while (times >= 0){
            count += Math.pow(10,times)*digits[digits.length-1-times];
            times--;
        }

        count += 1;
        int newtimes = 0;
        long newcount = count;
        while (newcount != 0){
            newcount = newcount/10;
            newtimes++;
        }
//        确定位数
        int i = 0;
        int[]res = new int[newtimes];
        newtimes--;

        while (newtimes >= 0){
            long tmp = count / (long) Math.pow(10,newtimes);
            res[i] =  (int)tmp;
            count %= (int)Math.pow(10,newtimes);
            i++;
            newtimes--;
        }


        return res;
    }

//    思路2 试试递归吧
    public static int[] plusOne1(int[] digits){
        // 这个思路好巧妙！！！
        // 三种情况 当前位是9 不是9 全是9
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]==9)
                digits[i]=0;
            else{
                digits[i]++;
                return digits;
            }
        }

        digits=new int[digits.length+1];
        digits[0]=1;
        return digits;
    }


        public static void main(String[] args) {
        int[] nums = new int[]{9,8,7,6,5,4,3,2,1,0};
        plusOne(nums);
    }
}
