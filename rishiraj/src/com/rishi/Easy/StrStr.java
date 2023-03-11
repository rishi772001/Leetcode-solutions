package com.rishi.Easy;

/*
  Reference video
  https://www.youtube.com/watch?v=GTJr8OvyEVQ&t=308s&ab_channel=TusharRoy-CodingMadeSimple
 */

import java.util.Arrays;

public class StrStr {
    private static int[] prefixSuffix;

    private static void findPrefixLength(String str) {
        prefixSuffix = new int[str.length()];

        int j = 0, i = 1;
        while (i < str.length()) {
            if (str.charAt(i) == str.charAt(j)) {
                prefixSuffix[i] = j + 1;
                i++;
                j++;
            } else {
                if (j != 0)
                    j = prefixSuffix[j - 1];
                else {
                    prefixSuffix[i] = 0;
                    i++;
                }
            }
        }
    }

    public int strStr(String text, String pattern) {
        if(text == null || text.equals(""))
            if(text.equals(pattern))
                return 0;
            else
                return -1;
        if(pattern == null || pattern.equals(""))
            return 0;

        findPrefixLength(pattern);
        System.out.println(Arrays.toString(prefixSuffix));

        // KMP String matching algorithm

        int i = 0; // to traverse text
        int j = 0; // to traverse pattern

        while (i < text.length()) {
            // if matches
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                // if string is found
                if (j == pattern.length())
                    return i - j;
            } else {
                if (j != 0)
                    j = prefixSuffix[j - 1];
                else
                    i++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String text = "a";
        String pattern = "";
        System.out.println(new StrStr().strStr(text, pattern) + " - " + text.indexOf(pattern));
    }
}
