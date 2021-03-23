package com.company;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis22 {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<>();
        helper(0,0,n,"",ans);
        return ans;
    }

    public void helper(int left, int right ,int max ,String str,ArrayList<String> ans){
//        终止
        if(left == right && left == max)
            ans.add(str);

//        处理
//        深入
        if(left < max)
            helper(left+1,right,max,str+"(",ans);
        if(right < left)
            helper(left,right+1,max,str+")",ans);
//        清楚
    }


    public static void main(String[] args) {

    }
}
