package com.rishi.Medium;

// https://leetcode.com/problems/powx-n/discuss/1348317/Pow(xn)-O(log-n)-100-faster

/*
consider x=2.0 and n=10

1. 2^10 = (2 * 2)^5 = 4^5
2. 4^5  = 4 *(4^4)
3. 4^4  = (4*4)^2 = 16^2
4. 16^2 = (16 * 16)^1=256^1
5. 256^1= 256*(256)*0=256

 -------------------------------------------------
| Observation:                                    |
--------------------------------------------------
|                                                 |
| 1. if n is even ,                               |
|     -->n=n/2                                    |
|     -->x=x*x                                    |
| 2. if n is odd ,                                |
|     -->n=n-1                                    |
|     -->ans=ans*x                                |
 -------------------------------------------------
*/

public class PowXN {
    public double myPow(double x, int pow) {
        // power to long as -2^31 * -1 leads to 2*31 which is out of integer range
        long n = pow;

        // base conditions
        if(n == 0)
            return 1.0;
        if(x == 0)
            return 0;
        if(x == 1)
            return 1;

        boolean isNegative = true;
        double ans = 1.0;

        // check for negative power
        if(n < 0){
            isNegative = false;
            n *= -1;
        }

        // main logic
        while(n > 0){
            if(n % 2 == 0){
                n = n / 2;
                x = x * x;
            }
            else{
                n = n - 1;
                ans = ans * x;
            }
        }

        // for positive power
        if(isNegative)
            return ans;
        return (1.0 / ans);
    }

    public static void main(String[] args) {
        System.out.println(new PowXN().myPow(1.00000, -2));
    }
}
