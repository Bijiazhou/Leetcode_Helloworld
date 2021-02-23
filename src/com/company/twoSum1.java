package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
public class twoSum1 {
    //思路一：暴力破解 一定会有一个解 这个可以
    public static int[] solution1(int[] nums, int target) {
        int[] ans = {0,0};
        for (int i = 0;i < nums.length-1; i++){
            for ( int j = i+1; j < nums.length; j++){
                if(nums[i]+nums[j]==target){
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }

    //（X）思路二，双指针其实可以 就是得先排序,排序前先存一下那也没必要了
    public static int[] solution2(int[] nums, int target) {
        int[] ans = {0,0};
        Arrays.sort(nums);
        for (int i = 0,j = nums.length-1; i < j;) {
            if(nums[i]+nums[j] ==target ) {
                ans[0] = i;
                ans[1] = j;
                return ans;
            }else if (nums[i]+nums[j] < target)
                i++;
            else
                j--;
//            if()
        }
        return ans;
    }

    //思路三  哈希表法 自己写着试试 这个方法还挺巧妙的
    public static int[] solution3(int[] nums, int target) {
        int[] ans = {0,0};
        Map<Integer, Integer> hashMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(target-nums[i])){
                ans[1] = i;
                ans[0] = hashMap.get(target-nums[i]);
                return ans;
            }
            hashMap.put(nums[i],i);
        }
        return ans;
    }


    public static void main(String[] args) {

        int[] input = {3,2,4};
        int target = 6;

        System.out.println(solution2(input,target)[0]);
        System.out.println(solution2(input,target)[1]);

    }

}
