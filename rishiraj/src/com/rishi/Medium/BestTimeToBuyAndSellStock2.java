package com.rishi.Medium;

import com.rishi.util.Util;

public class BestTimeToBuyAndSellStock2
{
	/*
			not buy
			[7,1,5,3,10,4]
		 0 1  2 3  4  5

	b 0  0 0   0  0  3  0
	u 1  0 0   4  4  9  9
	y 2  0 0   0  4  9  9
	  3  0 0   0  0  11 11
	  4  0 0   0  0  0  11
	  5  0 0   0  0  0  0
	*/
	public int maxProfit(int[] prices) {
		int length = prices.length;
		int[][] dp = new int[length][length];
		for(int i = 0; i < length; i++)
		{
			for(int j = i; j < length; j++)
			{
				int costPrice = prices[i];
				int profitIfExistingStockIsSold = Util.isOutBound(i - 1, length) ? 0 : dp[i - 1][i];
				int profitIfNotBought = Util.isOutBound(i - 1, length) ? 0 : dp[i - 1][j];
				int profitIfSoldInPast = Util.isOutBound(j - 1, length) ? 0 : dp[i][j - 1];
				int profit = prices[j] - costPrice;
				dp[i][j] = Math.max(profitIfNotBought, Math.max(profitIfSoldInPast, profit + profitIfExistingStockIsSold));
			}
		}
		return dp[length - 1][length - 1];
	}
}
