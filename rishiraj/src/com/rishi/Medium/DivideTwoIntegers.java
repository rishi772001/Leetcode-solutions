package com.rishi.Medium;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        boolean isNegative = false;
        if(dividend < 0 || divisor < 0) {
            if(!(dividend < 0 && divisor < 0)){
                isNegative = true;
            }
            dividend = Math.abs(dividend);
            divisor = Math.abs(divisor);
        }


        long res = 0;
        while(dividend >= 0){
            res++;
            dividend -= divisor;
            if(res > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
        }

        int ans = (int) res;
        return isNegative ? -1 * (ans - 1) : ans - 1;
    }

    public static void main(String[] args) {
        System.out.println(new DivideTwoIntegers().divide(
                -2147483648, -1));
    }
}
