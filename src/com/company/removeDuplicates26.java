package com.company;

import java.util.HashSet;
import java.util.Set;

//给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
public class removeDuplicates26 {

//    思路一 用cet写
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i]))
                continue;
            set.add(nums[i]);
            nums[count++]=nums[i];
        }

        return count;
    }

//    思路2 快慢指针么么哒 妈的你要记住这个是排序树组 所前面的小 后面的大 但是是有顺序的
//     1 1 2  2 2
public static int removeDuplicates2(int[] nums) {
    if (nums.length == 0) return 0;
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
        if(nums[count] == nums[i])
            continue;
        nums[++count]=nums[i];
    }
    return count+1;
}

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,2,3,3,4,5};
        System.out.println(removeDuplicates2(nums));
    }
}
