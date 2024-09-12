package com.rishi.Medium;

import java.util.Arrays;

/**
 * Intuition : Build subset sum dp array and iterate through the last row from last to find
 * the minimum difference. The difference can be only from 0 to sum / 2
 *
 * <a href="https://youtu.be/FB0KUhsxXGY?si=Q4v8INUqGqmR8w52">Youtube link</a>
 */
public class MinimumSubsetSumDifference
{
	public static int minimumDiff(int[] nums) {
		int sum = Arrays.stream(nums).sum();

		int[][] dp = PartitionEqualSubsetSum.buildDP(nums, sum / 2);
		for(int i = dp[dp.length - 1][sum / 2]; i >= 0; i--)
		{
			if(dp[dp.length - 1][i] > 0)
				return dp[dp.length - 1][i];
		}
		return sum / 2;
	}
}
