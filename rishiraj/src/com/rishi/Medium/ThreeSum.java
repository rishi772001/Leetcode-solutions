package com.rishi.Medium;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // to avoid duplicate triplets
        Set<Integer> visited = new HashSet<>();

        List<List<Integer>> answer = new ArrayList<>();

        // set a number and find remaining two numbers using two pointer algorithm
        for(int i = 0; i < nums.length; i++){
            if(!visited.contains(nums[i])) {
                int remaining = -1 * nums[i];
                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum == remaining) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        answer.add(temp);
                        left++;
                        while(left < right && nums[left] == temp.get(1))left++;
                        while(left < right && nums[right] == temp.get(2))right--;
                    }
                    if (sum < remaining)
                        left++;
                    if (sum > remaining)
                        right--;
                    
                }
                visited.add(nums[i]);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
//        int[] arr = {-1, 0, 1, 2, -1, -4};  // {-4, -1, -1, 0, 1, 2}
        int[] arr = {0, 0, 0, 0};
        Arrays.sort(arr);
        List<List<Integer>> ans = new ThreeSum().threeSum(arr);
        for(List<Integer> i : ans){
            for(Object j : i){
                System.out.print(j + ", ");
            }
            System.out.println();
        }
    }
}
