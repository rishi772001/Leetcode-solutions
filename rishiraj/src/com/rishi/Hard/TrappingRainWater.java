package com.rishi.Hard;

public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int water = 0;
        int[] lMax = new int[n];
        int[] rMax = new int[n];

        lMax[0] = height[0];
        rMax[n - 1] = height[n - 1];

//        Compute lmax
        for (int i = 1; i < n; i++) {
            lMax[i] = Math.max(lMax[i - 1], height[i]);
        }
//        Compute rMax
        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i + 1], height[i]);
        }

        for(int i = 0; i < n; i++) {
            water += Math.min(lMax[i], rMax[i]) - height[i];
        }

        return water;
    }

    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new TrappingRainWater().trap(arr));
    }
}
