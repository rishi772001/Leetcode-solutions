package com.rishi.Easy;

public class LongestCommonPrefix {
    private static String findCommonPrefix(String[] arr, int left, int right){
        if(left == right)
            return arr[left];
        else{
            int mid = (left + right) / 2;
            String leftStr = findCommonPrefix(arr, left, mid);
            String rightStr = findCommonPrefix(arr, mid + 1, right);
            return commonPrefix(leftStr, rightStr);
        }
    }

    public static String commonPrefix(String a, String b){
        int minLength = Math.min(a.length(), b.length());
        for(int i = 0; i < minLength; i++){
            if(a.charAt(i) != b.charAt(i))
                return a.substring(0, i);
        }
        return a.substring(0, minLength);
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        return findCommonPrefix(strs, 0, strs.length - 1);
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }
}
