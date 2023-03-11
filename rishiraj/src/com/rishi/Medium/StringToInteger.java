package com.rishi.Medium;

public class StringToInteger
{
    public int myAtoi(String str) {
        int value = 0, index = 0 , posOrNeg = 1;
        for (;index < str.length(); index ++) if (str.charAt(index) != ' ') break; // Gets index of first non-white space character
        if (index == str.length()) return 0; // If reached end, return 0
        posOrNeg = str.charAt(index) == '-' ? -1 : 1; // Get +/- Sign and store it
        index += str.charAt(index) == '-' || str.charAt(index) == '+' ? 1 : 0; // Incr. index if +/- was found earlier
        while (index != str.length() && (str.charAt(index) >= '0' && str.charAt(index) <= '9')){ // Parse to end or until non-number is found
            if ((Integer.MAX_VALUE - str.charAt(index) - 48) / 10 < value) // If the next value will overflow, return max/min value
                return posOrNeg > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            value *= 10; // Make space for next value
            value += str.charAt(index ++) - 48; // - 48 ASCII Conversion
        }
        return value * posOrNeg; // Converts to +/- if needed
    }
}
