package com.company;

import java.util.*;

public class groupAnagrams49 {

//    思路1:用哈希表法
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        int row = 0;
        for (int i = 0; i < strs.length; i++) {
            char[] s = strs[i].toCharArray();
            Arrays.sort(s);
            String ss = Arrays.toString(s);
            if(map.containsKey(ss)) {
                ans.get(map.get(ss)).add(strs[i]);
            }
            else {
                map.put(ss,row++);
                List<String> tmp = new ArrayList<String>();
                tmp.add(strs[i]);
                ans.add(tmp);
            }
        }
        return ans;
    }


//    思路1.5 哈希表法2
    public List<List<String>> groupAnagrams2(String[] strs){
        Map<String,List<String>> map  = new HashMap<String,List<String>>();
        for (String str : strs){
            char[] s = str.toCharArray();
            Arrays.sort(s);
            String ss = Arrays.toString(s);
            List<String> list = map.getOrDefault(ss,new ArrayList<String>());
            list.add(str);
            map.put(ss,list);
        }
//        骚啊
        return new ArrayList<List<String>>(map.values());
    }
    public static void main(String[] args) {
        new groupAnagrams49().groupAnagrams2(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});

    }
}
