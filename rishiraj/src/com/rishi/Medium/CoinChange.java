package com.rishi.Medium;

import java.util.Arrays;

import com.rishi.util.Util;

public class CoinChange
{
	/*
			 0  1  2  3  4  5
		2   -1 -1 -1 -1 -1
		4   -1 -1 -1 -1 -1
	 */
	public static int coinChange(int[] coins, int amount)
	{
		int[] dp = new int[amount + 1];

		for(int j = 0; j < amount + 1; j++)
		{
			if(j != 0)
				dp[j] = -1;
		}

		for(int i = 0; i < coins.length; i++)
		{
			for(int j = coins[i]; j <= amount; j++)
			{
				if(dp[j - coins[i]] != -1)
				{
					dp[j] = dp[j] == -1 ? dp[j - coins[i]] + 1 : Math.min(dp[j], dp[j - coins[i]] + 1);
				}
			}
		}

		System.out.println(Arrays.toString(dp));
		return dp[amount] == 0 ? -1 : dp[amount];
	}

	public static void main(String[] args)
	{
		System.out.println(coinChange(new int[] {2,5,10,1}, 27));
	}
}
