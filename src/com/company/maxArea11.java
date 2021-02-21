package com.company;

public class maxArea11 {
//    给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
//    在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
//    找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

//    思路一 暴力法 就两个for循环加上个max值完事儿
    public static int solution1(int[] height){
        int max = 0;
//        i j 不应该重复
        for (int i = 0; i < height.length-1;i++){
            for (int j = i + 1; j < height.length;j++){
                int curArea = (j-i) * Math.min(height[i],height[j]);
                   max = (curArea > max)? curArea:max;
            }
        }
        return max;
    }


//    思路二 两侧夹逼办法 即所谓双指针法,也叫做左右边界法
//    从两侧逐渐逼近，只留高的，不要矮的，矮的就向内侧逼近
public static int solution2(int[] height){
    int max = 0;
    for (int i = 0 , j = height.length - 1; i < j;){
//        这里还没改变 执行完毕才改变的
        int minHeight = height[i] > height[j] ? height[j--] : height[i++];
//        这里是因为我保存到矮数据了的并且还移动了，所以要j-i+1，作为这一次的面积
        int curArea = (j - i + 1) * minHeight;
        max = Math.max(max,curArea);
    }
    return max;
}


public static int solution2_re(int[] height){
        int max = 0;
        for (int i = 0, j = height.length - 1 ; i < j ; ){
            int minHeight = (height[i] < height[j]) ? height[i++] :height[j--];
            int curArea = (j - i + 1) * minHeight;
            max = Math.max(max, curArea);
        }
        return  max;
}
    public static void main(String[] args) {

        int[] nums = {1,8,6,2,5,4,8,3,7};

        System.out.println(solution2_re(nums));

    }
}
