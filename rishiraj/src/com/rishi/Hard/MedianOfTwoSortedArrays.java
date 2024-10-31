package com.rishi.Hard;

import java.util.*;

/**
 * Intuition:
 * 1. Find left pool size and right pool size. based on n & m
 * 2. Partition the arrays based on the pool size.
 * 3. Select how to make the partition based on binary search
 */
public class MedianOfTwoSortedArrays {
    /*
    [1,2,8]
    [3,4,5]

    [1,2,3,4,5,8]
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int leftPoolSize = (int) Math.ceil((n + m) / 2.0) - 1;
        int rightPoolSize = n + m - leftPoolSize;

        for(int i = 0; i < leftPoolSize; i++)
        {
            int j = leftPoolSize - i;
        }

        return 0.0;
    }
}
