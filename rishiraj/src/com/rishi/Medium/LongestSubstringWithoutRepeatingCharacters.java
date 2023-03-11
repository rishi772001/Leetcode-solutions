package com.rishi.Medium;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        HashSet<Character> window = new HashSet<>();
        int start = 0, end = 0, maxi = 0, size = 0;

        while (end < s.length())
            if (!window.contains(s.charAt(end))) {
                window.add(s.charAt(end));
                size += 1;
                end += 1;
            } else {
                maxi = Math.max(size, maxi);
                window.remove(s.charAt(start));
                start += 1;
                size -= 1;
            }
        return Math.max(maxi, size);
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
