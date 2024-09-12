package com.rishi.Medium;

import java.util.Arrays;

/**
 * Intuition :
 * 1. We are splitting the nums into two subset. One with positive values and one with negative values
 * 2. Find count subsets with the difference = positive(s1) - negative(s2) equals target
 */
public class TargetSum
{
	public static int[][] buildDP(int[] nums, int subsetSum)
	{
		/*
		 * [2,3,3,4] 6
		 *
		 *   0  1  2  3  4  5  6=> sum(j)
		 * 0[1, 0, 0, 0, 0, 0, 0]
		 * 2[1, 0, 1, 0, 0, 0, 0]
		 * 3[1, 0, 1, 1, 0, 1, 0]
		 * 3[1, 0, 1, 2, 0, 2, 1]
		 * 4[1, 0, 1, 2, 1, 2, 2]
		 *
		 * * [2,3,3,4] 6
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
					dp[i][j] = 1 + dp[i - 1][j];
				if(nums[i - 1] > j) // copy top as we cannot include it
					dp[i][j] = dp[i - 1][j];
				if(nums[i - 1] < j) { // see top row in column(sum - value) is true or copy top as we cannot include it
					dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
				}
			}
		}

//		Printing the table
		 for(int[] dpRow : dp)
		 {
		 	System.out.println(Arrays.toString(dpRow));
		 }
		return dp;
	}
	public static int findTargetSumWays(int[] nums, int target) {
		int sum = Arrays.stream(nums).sum();
		if(target > sum)
			return 0;

		int s1 = (sum + target) / 2;
		System.out.println(s1);
		int[][] dp = buildDP(nums, s1);
		return dp[nums.length][s1];
	}

	public static void main(String[] args)
	{
		System.out.println(findTargetSumWays(new int[]{0,0,0,0,0,0,0,0,1}, 1));
	}
}
