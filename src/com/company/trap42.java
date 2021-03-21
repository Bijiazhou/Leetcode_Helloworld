package com.company;
/*
* 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
* 输出：6
* 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
* */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class trap42 {
//    思路1 这个感觉似乎很有意思 维恩数学分析法
    public int trap1(int[] height) {
//      从左到右扫一遍s1、从右到左扫一遍s2  s = s1 + s2 - 柱子的面积 - 大的矩形面积

        int rectArea = 0, heightArea = 0;
        int s = 0, s1 = 0, s2 = 0;
        int curHeight = 0;

        for (int j : height) {
            if (j > curHeight)
                curHeight = j;
            s1 += curHeight;
            heightArea += j;
        }

        curHeight = 0;

        for (int i = height.length-1; i >= 0; i--) {
            if(height[i]>curHeight)
                curHeight = height[i];
            s1 += curHeight;
        }

        rectArea = curHeight * height.length;

        s = s1+s2-rectArea- heightArea;
        return s;
    }

//    思路2 单调栈法  栈次顶元素 栈顶元素 当前元素 围成一个面积 进行计算
    public int trap2(int[] height) {
        int ans = 0, current = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty())
                    break;
                int distance = current - stack.peek() - 1;
                int bounded_height = Math.min(height[current], height[stack.peek()]) - height[top];
                ans += distance * bounded_height;
            }
            stack.push(current++);
        }
        return ans;
    }

    //思路3 就纯粹是暴力思路 每个元素都去找他的左右边界，并取其最小值
    public int trap3(int[] height) {
        int ans = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int left_max = 0,right_max = 0;

            for (int j = i; j >= 0 ; j--) {
                left_max = Math.max(left_max,height[j]);
            }
            for (int j = i; j < height.length ; j++) {
                right_max = Math.max(right_max,height[j]);
            }

            ans += Math.min(left_max,right_max) - height[i];
        }
        return ans;
    }



        public static void main(String[] args) {
        trap42 tramp = new trap42();
        int[] num = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(tramp.trap3(num));
    }
}
