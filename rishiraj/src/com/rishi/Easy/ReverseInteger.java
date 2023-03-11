package com.rishi.Easy;

import java.lang.*;

public class ReverseInteger {
    public int reverse(int x) {
        boolean flag = false;
        if(x < 0) {
            x = Math.abs(x);
            flag = true;
        }

        long ans = 0;
        while(x > 0) {
            int temp = x % 10;
            x = x / 10;
            ans = temp + ans * 10;
        }

        int val;

        if(Integer.MIN_VALUE >= ans || ans >= Integer.MAX_VALUE )
            return 0;
        else
            val = (int)ans;
        return  flag ? -val : val;
    }
}
