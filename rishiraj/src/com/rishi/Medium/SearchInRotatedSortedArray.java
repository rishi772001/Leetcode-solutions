package com.rishi.Medium;

public class SearchInRotatedSortedArray {
    private static int findPeak(int[] nums, int left, int right)
    {
        while(right-left > 1) {
            int mid = left + (right - left) / 2;
            if (nums[left] < nums[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static int binarySearch(int[] nums, int left, int right, int target){
        if(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                if(nums[mid - 1] == target)
                    return binarySearch(nums, left, mid - 1, target);
                return mid;
            } if(nums[mid] > target){
                return binarySearch(nums, left, mid - 1, target);
            } else {
                return binarySearch(nums, mid + 1, right, target);
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;

        int peak = findPeak(nums, 0, nums.length - 1);
        System.out.println(peak);
        if(target == nums[peak])
            return peak;
        if(target < nums[peak] && target >= nums[0])
            return binarySearch(nums, 0, peak - 1, target);
        else
            return binarySearch(nums, peak + 1, nums.length - 1, target);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3};
        int target = 0;
        System.out.println(new SearchInRotatedSortedArray().search(nums, target));
    }
}
