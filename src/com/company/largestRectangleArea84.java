package com.company;
//    给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//    求在该柱状图中，能够勾勒出来的矩形的最大面积。

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class largestRectangleArea84 {
    //思路1 刚开始想的双指针 ，但是又和蓄水那道题不太一样 暴力法呢 for for ？？超时！！！
    public int largestRectangleArea(int[] heights) {
        int maxArea = -1;
//        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
//
//        for (int i = 0; i < heights.length; i++) {
//            map.put(heights[i],i);
//        }
        if(heights.length == 0)
            return 0;

        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length; j++) {
//                计算矩形高度 横×高（最小的那个）
                int curArea = (j-i+1)* minHight(heights,i,j);
                if (curArea >maxArea)
                    maxArea = curArea;
            }
        }
        return maxArea;
    }

    private int minHight(int[] heights,int i, int j) {
        int minHight = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            if (minHight > heights[k])
                minHight = heights[k];
        }
        return minHight;
    }

    //暴力法2 仅针对棒子的枚举  看看左右谁比他更矮
    public int largestRectangleArea2(int[] heights) {
        int maxArea = -1;
        for (int i = 0; i < heights.length; i++) {
            int left = i,right = i;
            while (left > 0 && heights[left-1] >= heights[i]) {
                left--;
            }
            while (right < heights.length-1 && heights[i] < heights[right+1]){
                right++;
            }
            maxArea = Math.max((right - left + 1) * heights[i], maxArea);
        }
        return maxArea;
    }

    //别人的暴力法
    public int largestRectangleArea3(int[] heights) {
        //暴力破解
        int max = 0, n = heights.length;
        for(int i = 0; i < n; i++){     //枚举以当前heights[i]为高的所有矩形
            int temp = 0;
            for(int k = 0; k <= i; k++){    //遍历前半部分，加上紧邻当前heights[i]的可用矩形面积
                if(heights[k] >= heights[i])
                    temp += heights[i];
                else
                    temp = 0;
            }
            for(int j = i+1; j<n; j++){     //遍历后半部分
                if(heights[j] < heights[i])
                    break;                  //因为遍历后半部分可以截断，所以前后部分遍历分开写了
                else{
                    temp += heights[i];
                }
            }
            if(max < temp)
                max = temp;
        }
        return max;
    }


    //奇怪思路 官方解法
    public int largestRectangleArea4(int[] heights) {
            // 初始化最终结果为0
            int res = 0;
            Stack<Integer> stack = new Stack<>();

            // 将给定的原数组左右各添加一个元素0
            int[] newHeights = new int[heights.length + 2];
            newHeights[0] = 0;
            newHeights[newHeights.length-1] = 0;
            for (int i = 1; i < heights.length + 1; i++) {
                newHeights[i] = heights[i - 1];
            }

            // 开始遍历
            for (int i = 0; i < newHeights.length; i++) {
                // 如果栈不为空且当前考察的元素值小于栈顶元素值，
                // 则表示以栈顶元素值为高的矩形面积可以确定
                while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                    // 弹出栈顶元素
                    int cur = stack.pop();
                    // 获取栈顶元素对应的高
                    int curHeight = newHeights[cur];

                    // 栈顶元素弹出后，新的栈顶元素就是其左侧边界
                    int leftIndex = stack.peek();
                    // 右侧边界是当前考察的索引
                    int rightIndex = i;
                    // 计算矩形宽度
                    int curWidth = rightIndex - leftIndex - 1;

                    // 计算面积
                    res = Math.max(res, curWidth * curHeight);
                }

                // 当前考察索引入栈
                stack.push(i);
            }

            return res;


    }
    public static void main(String[] args) {
        int[] nums = new int[]{2,1,5,6,2,3};
        largestRectangleArea84 sol =   new largestRectangleArea84();
        sol.largestRectangleArea2(nums);
     }
}
