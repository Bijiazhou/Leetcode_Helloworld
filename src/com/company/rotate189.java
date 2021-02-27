package com.company;

import java.util.ArrayList;

//旋转数组 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
public class rotate189 {

//    思路一 尝试先解决一个重复多次的问题 然后用tmp数组copy 我觉得常规方法估计要超时
    public static void rotate(int[] nums, int k) {
        int times = k % nums.length;
        int[] tmp = new int[nums.length];

        //        前期保存
//        for (int i = nums.length - times ,tmpCur = 0; i < nums.length; i++,tmpCur++) {
//            tmp[tmpCur] = nums[i];
//        }
        System.arraycopy(nums,nums.length - times,tmp,0,times);
//        后续填充
        for (int i = nums.length - 1; i >= times; i--) {
            nums[i] = nums[i-times];
        }
//        数组拷贝的方法
        System.arraycopy(tmp, 0, nums, 0, times);
    }

//    思路2 数组翻转 前后翻转后各自在进行翻转
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

//    双指针翻转数组
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }


    public static void printList(int[] nums){
        for (int num : nums) {
            System.out.println(num);
        }
    }
        public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};

        rotate(nums,30);
        printList(nums);
    }
}
