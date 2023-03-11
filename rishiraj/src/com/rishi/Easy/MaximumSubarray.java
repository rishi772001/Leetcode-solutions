package com.rishi.Easy;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return 0;
        int curr_sum = nums[0];
        int maxSum = curr_sum;
        for(int i = 1; i < n; i++){
            curr_sum = Math.max(curr_sum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, curr_sum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaximumSubarray().maxSubArray(arr));
    }
}
