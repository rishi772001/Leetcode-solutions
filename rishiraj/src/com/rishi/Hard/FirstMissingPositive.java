package com.rishi.Hard;

public class FirstMissingPositive {
    // works for arrays with no duplicates
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int count = 0;

        if(n == 0)
            return 1;

        for(int i = 0; i < n; i++){
            if(nums[i] <= 0)
                nums[i] = 0;
            else
                count++;
        }

        for(int i: nums){
            if(i != 0 && Math.abs(i) <= n)
                nums[Math.abs(i) - 1] *= -1;
        }

        for(int i = 0; i < n; i++){
            if(nums[i] > 1)
                return i + 1;
        }

        return count + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(new FirstMissingPositive().firstMissingPositive(nums));
    }
}
