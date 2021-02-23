package com.company;
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
//        使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
//
//        注意：答案中不可以包含重复的三元组。

import netscape.javascript.JSObject;

import java.util.*;

public class threeSum15 {

    public static List<List<Integer>> sokution1(int[] nums){
        //    思路1 暴力法 而且还不能重复md  哈哈哈果然超时了

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if(nums[i] + nums[j] == -nums[k]){
                        List<Integer> cur_ans = new ArrayList<Integer>();
                        cur_ans.add(nums[i]);
                        cur_ans.add(nums[j]);
                        cur_ans.add(nums[k]);
                        Collections.sort(cur_ans);

                        if(!ans.contains(cur_ans)) {
                            ans.add(cur_ans);
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> sokution2(int[] nums){
        //    思路2 打表法 存入HASH表就不用去遍历了，然后i j遍历的时候用hash表去找k 就不是三层循环了
        List<Integer> list = new ArrayList<Integer>();
        if(nums.length < 3){
            return new ArrayList<>();
        }
        //排序
        Arrays.sort(nums);
        HashMap<Integer,Integer> map = new HashMap<>();
        List<List<Integer>> resultarr = new ArrayList<>();

        //存入哈希表
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }

        Integer t;
        int target = 0;
        for(int i = 0; i < nums.length; ++i){
            target = -nums[i];
            //去重
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j = i + 1; j < nums.length; ++j){
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
//                通过hasn表去找这个数
                if((t = map.get(target - nums[j])) != null){
                    //符合要求的情况,存入
                    if(t > j){
                        resultarr.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[t])));
                    }
                    else
                        break;
                }
            }
        }
        return resultarr;
    }


    public static List<List<Integer>> sokution3(int[] nums) {
        //思路3 双指针逼近法 有点牛逼 得先排个序,已经是从小到大了,还要跳过连续一样的 其实挺有难度

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i =jumpToNext(nums, i ,nums.length-2,true)) {
            if(nums[i] > 0)
                break;
            for (int j = i+1,k = nums.length-1; j < k;) {
                if(nums[j]+nums[k]==-nums[i]) {
                    List<Integer> cur_ans = new ArrayList<Integer>();
                    cur_ans.add(nums[i]);
                    cur_ans.add(nums[j]);
                    cur_ans.add(nums[k]);
                    ans.add(cur_ans);
                    j = jumpToNext(nums,j,k,true);
                    k = jumpToNext(nums,k,j,false);
                }else if(nums[j]+nums[k] < -nums[i]){
                    j = jumpToNext(nums,j,k,true);
                }else{
                    k = jumpToNext(nums,k,j,false);
                }
            }
        }
        return ans;
    }

    public  static int jumpToNext(int[] nums,int index,int target, boolean up){
            if (up) {
                while (index < target && nums[index] == nums[++index]);
            } else {
                while (index > target && nums[index] == nums[--index]);
            }
//        System.out.println(index);
        return index;
    }

    public static void main(String[] arg) {
       int[] nums = {0,0,0};
//       sokution3(nums);
       System.out.println(sokution1(nums));
    }
}
