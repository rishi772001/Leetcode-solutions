package com.rishi.Medium;

import java.lang.*;

public class ContainerWithMostWater {
    public int maxArea(int[] ht) {
        int left = 0;
        int right = ht.length - 1;
        int ans = Integer.MIN_VALUE;

        while(left < right) {
            int width = right - left;
            int height = 0;
            if (ht[left] > ht[right]) {
                height = ht[right];
                right -= 1;
            } else {
                height = ht[left];
                left += 1;
            }
            ans = Math.max(ans, (width * height));
        }

        return ans;
    }
}
