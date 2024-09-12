package com.rishi.Medium;

import java.util.Arrays;

/**
 * 0/1 Knapsack implementation
 * Intuition -> Calc sum and check whether the sum can be made using the array elements
 * Checking intuition -> Each element has 2 possibilities, We can either include it or not include it. <br />
 * <a href="https://www.youtube.com/watch?v=34l1kTIQCIA">Youtube link</a>
 */
public class PartitionEqualSubsetSum
{
	public static boolean canPartition(int[] nums) {
		int sum = Arrays.stream(nums).sum();
		if(sum%2 != 0)
			return false;

		int subsetSum = sum/2;
		return isSubsetSumFound(nums, subsetSum);
	}

	private static boolean isSubsetSumFound(int[] nums, int subsetSum)
	{
		int[][] dp = buildDP(nums, subsetSum);
		return dp[nums.length-1][subsetSum] == 1;
	}

	public static int[][] buildDP(int[] nums, int subsetSum)
	{
		/*
		 * [2,3,3,4] 6
		 *
		 *   0 1 2 3 4 5 6=> sum(j)
		 * 0[1 0 0 0 0 0 0]
		 * 2[1 0 1 0 0 0 0]
		 * 3[1 0 1 1 0 1 0]
		 * 3[1 0 1 1 0 1 1]
		 * 4[1 0 1 1 1 1 1]
		 */
		int[][] dp = new int[nums.length + 1][subsetSum + 1];
		for(int i = 0; i < dp.length; i++) //nums
		{
			for(int j = 0; j < dp[i].length; j++) //sum
			{
				// base case
				if(j == 0) { // if sum = 0, we can always make a subset with no elements
					dp[i][j] = 1;
					continue;
				}
				else if(i == 0) { // if there are no elements, we cannot make a subset
					dp[i][j] = 0;
					continue;
				}

				// Actual cases
				if(nums[i - 1] == j) // true as other elements can be excluded
					dp[i][j] = 1;
				if(nums[i - 1] > j) // copy top as we cannot include it
					dp[i][j] = dp[i - 1][j];
				if(nums[i - 1] < j) { // see top row in column(sum - value) is true or copy top as we cannot include it
					dp[i][j] = Integer.max(dp[i - 1][j - nums[i - 1]], dp[i - 1][j]);
				}
			}
		}

		//Printing the table
		for(int[] dpRow : dp)
		{
			System.out.println(Arrays.toString(dpRow));
		}
		return dp;
	}

	public static void main(String[] args)
	{
		System.out.println("OUT => " + canPartition(new int[]{2,3,3,4}));
	}
}
