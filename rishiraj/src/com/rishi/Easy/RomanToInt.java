package com.rishi.Easy;

import java.util.*;

public class RomanToInt {
    public int romanToInt(String s) {
        Map<Character, Integer> values = new HashMap<>();
        values.put('I', 1); values.put('V', 5); values.put('X', 10); values.put('L', 50);
        values.put('C', 100); values.put('D', 500); values.put('M', 1000);
        int sum = 0;

        // iterate till last - 1
        for(int i = 0; i < s.length() - 1; i++) {
            // to check for edge values like 4(IX instead of  IIII)
            if(values.get(s.charAt(i)) < values.get(s.charAt(i + 1)))
                sum -= values.get(s.charAt(i));
            else
                sum += values.get(s.charAt(i));
        }
        return sum + values.get(s.charAt(s.length() - 1));
    }
}
