package com.rishi.Hard;

import java.util.*;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Double> nums = new ArrayList<>();

        for(int i : nums1){
            nums.add((double)i);
        }
        for(int i : nums2){
            nums.add((double)i);
        }

        Collections.sort(nums);
        if(nums.size() % 2 == 0) {
            int n1 = nums.size() / 2;
            int n2 = n1 - 1;
            return (nums.get(n1) + nums.get(n2)) / 2.0;
        }
        else{
            return nums.get(nums.size() / 2);
        }
    }
}
