package com.rishi.Medium;

import java.util.*;

public class Permutations {
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    List<List<Integer>> output = new ArrayList<>();
    private void findPermutations(int[] nums, int l, int r){
        if(l == r) {
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i : nums)
                arr.add(i);
            output.add(arr);
        }

        for(int i = l; i < r + 1; i++){
            swap(nums, l, i);
            findPermutations(nums, l + 1, r);
            swap(nums, l, i);
        }

    }
    public List<List<Integer>> permute(int[] nums) {
        findPermutations(nums, 0, nums.length - 1);
        return output;
    }
}
