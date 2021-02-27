package com.company;
//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。


import java.util.Arrays;

public class merge88 {
//    思路1 暴力法 直接存进去然后排序 过于简单了
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0)
            return;

        if (m >= 0) System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

//    思路2 直接存进去 因为是有序的 想试试新开一个数组 双指针方案
//    这种合并数组的是最简单的了 务必要回 千万别忘了 最后两个数组有剩余的情况
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0)
            return;

        int[] result = new int[m+n];
        int cur1=0,cur2=0;
        int resCur = 0;

        while (cur1 < m && cur2 < n){

            if (nums1[cur1] > nums2[cur2]) {
                result[resCur++] = nums2[cur2];
                cur2++;
            } else {
                result[resCur++] = nums1[cur1];
                cur1++;
            }
        }
        if(cur1<m)
            System.arraycopy(nums1,cur1,result,resCur,m-cur1);
        if(cur2<n)
            System.arraycopy(nums2,cur2,result,resCur,n-cur2);
        System.arraycopy(result,0,nums1,0,n+m);
    }


//    思路3 同样是双指针  为什么不能是从后面来找大的
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        int cur1 = m -1,cur2 = n-1,resCur = m+n-1;

        while (cur1>=0 && cur2>= 0){
            if(nums1[cur1] > nums2[cur2]) {
                nums1[resCur--] =nums1[cur1--];
            }else
                nums1[resCur--] =nums2[cur2--];
        }
//        有特殊情况 [4,5,6,0,0,0] 3 [1,2,3] 3
//        System.arraycopy(nums2, 0, nums1, 0, cur2 + 1);
        while (cur1 >= 0) nums1[resCur -- ] = nums1[cur1 -- ];   //扫尾，~p1 等价于 p1 != -1
        while (cur2 >= 0) nums1[resCur -- ] = nums2[cur2 -- ];
        return;
    }


        public static void main(String[] args) {
        int[] nums1 = new int[]{4,5,6,0,0,0};
        int[] nums2 = new int[]{1,2,3};

        merge3(nums1,3,nums2,3);

    }

}
