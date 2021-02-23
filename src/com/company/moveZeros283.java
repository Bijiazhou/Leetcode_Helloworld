package com.company;

import java.util.Arrays;

public class moveZeros283 {

    public static void solution1(int[] nums) {
        // 思路1. 设置一个0的计数器，前面先用其他数的填满，最后补零
        int zeroCount = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != 0){
                // System.out.println(nums[i]);
                nums[i-zeroCount]=nums[i];
            }
            else
                zeroCount++;
        }
        while(zeroCount > 0){
            // System.out.println(0);
            nums[nums.length-zeroCount]=0;
            zeroCount--;
        }
    }

    public static void solution2(int[] nums) {
        //思路2 其实可以进行这样一个操作，直接在数组里面进行操作，核心在于index
        //只要你不是0 你就跟着0下表计数器j往前凑 同时因为你已经换了 所以原本的位置是0
//        int j = 0;
//        for(int i = 0;i < nums.length;i++){
//            if(nums[i] != 0){
//                nums[j] = nums[i];
//                // 发生交换
//                if(i != j){
//                    nums[i] = 0;
//                }
//                j++;
//            }
//        }
    }



    public static void solution3(int[] nums) {
        //思路3 冒泡排序 这个就是说 我只针对0和非0进行排序 暂时还不明白 没事儿

        boolean swapped = true;
        for(int i=0; i<nums.length-1; i++) {
            if(!swapped)
                break;
            swapped = false;
            for(int j=0; j<nums.length-1-i; j++) {
                if(nums[j] == 0) {
                    nums[j+1] = nums[j] + nums[j+1];
                    nums[j] = nums[j+1] - nums[j];
                    nums[j+1] = nums[j+1] - nums[j];
                    swapped = true;
                }
            }
        }
    }

    public static void printList(int[] nums){
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,0,2,0,3,4,0,5};

        solution3(nums);

        printList(nums);

    }
}
