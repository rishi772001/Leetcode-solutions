package com.rishi.Medium;

import java.util.Arrays;

public class FirstAndLastPositionOfElement {
    private static int binarySearch(int[] nums, int left, int right, int target, boolean start){
        if(nums.length == 0)
            return -1;
        if(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                if(start && mid - 1 >= 0 && nums[mid - 1] == target)
                    return binarySearch(nums, left, mid - 1, target, start);
                else if(!start && mid + 1 < nums.length && nums[mid + 1] == target)
                    return binarySearch(nums, mid + 1, right, target, start);
                return mid;
            } if(nums[mid] > target){
                return binarySearch(nums, left, mid - 1, target, start);
            } else {
                return binarySearch(nums, mid + 1, right, target, start);
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int start = binarySearch(nums, 0, nums.length - 1, target, true);
        int end = binarySearch(nums, 0, nums.length - 1, target, false);
        return new int[]{start, end};
    }

    public static void main(String[] args) {
        int[] nums = {2, 2};
        int target = 3;
        System.out.println(Arrays.toString(new FirstAndLastPositionOfElement().searchRange(nums, target)));
    }
}
