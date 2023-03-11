package com.rishi.Medium;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String i : strs){
            char[] sorted = i.toCharArray();
            Arrays.sort(sorted);
            String temp = new String(sorted);

            if(map.containsKey(temp)){
                map.get(temp).add(i);
            } else {
                ArrayList<String> ar = new ArrayList<>();
                ar.add(i);
                map.put(temp, ar);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(String i: map.keySet()){
            ans.add(map.get(i));
        }
        return ans;
    }
}
