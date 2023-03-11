package com.rishi.Easy;

import java.util.Arrays;

public class RemoveDuplicatesFromSotedArray {

    public int[] removeDuplicates(int[] nums) {
        int n = nums.length;

        int i = 0, j = 1;

        while(j < n){
            if(nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new RemoveDuplicatesFromSotedArray().removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4})));
    }
}
