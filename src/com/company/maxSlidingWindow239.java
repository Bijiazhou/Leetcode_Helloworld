package com.company;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class maxSlidingWindow239 {

//    思路1: 暴力法 我觉得你就先输出来看看什么情况呗 一般来说会超时
    public int[] maxSlidingWindow0(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        for (int i = 0; i < nums.length-k+1; i++) {
            int max = Integer.MIN_VALUE;
//            这里可以优化么？
            for (int j = i; j < i+k; j++) {
                max = Math.max(max,nums[j]);
            }
            ans[i] = max;
        }
        return ans;
    }

    //一个比较有意思的方法 优先队列
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        int index =0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (int i = 0; i < nums.length; i++) {

            if(priorityQueue.size() >= k)
                priorityQueue.remove(nums[i-k]);
            priorityQueue.offer(nums[i]);
            if(i >= k-1)
                ans[index++] = priorityQueue.peek();
        }
        return  ans;
    }

//    官方解法1 双端队列 大致思路就是最左边永远是当前滑动窗口内最大元素的下标
    public int[] maxSlidingWindow(int[] nums, int k) {
        int curleft = 0,curRight = 0;
        int[] res = new int[k];
//        用一个双端队列
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            if(!deque.isEmpty() && deque.peekFirst() == i - k){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
            if(i >= k - 1){
                res[i + 1 - k] = nums[deque.peekFirst()];
            }
        }
        return res;

        /*
        for (int i = 0; curRight < nums.length; i++) {
            if(i==0) {
                for (int j = 0; j <k; j++) {
                    deque.addLast(nums[j]);
                }
                curRight = k-1;
//                find max one
            }else {
                curleft++;
                curRight++;
                deque.addLast(nums[curRight]);
                deque.removeFirst();
                //find max one
            }
        }
        return ans;

         */
    }



    public static void main(String[] args) {
        int [] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;

        maxSlidingWindow239 aa = new maxSlidingWindow239();
        aa.maxSlidingWindow(nums,k);
    }
}
