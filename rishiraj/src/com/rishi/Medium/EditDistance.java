package com.rishi.Medium;

import com.rishi.util.Util;

/**
 * word1 = abc
 * word2 = bcd
 *
 * if chars not match
 * insert = we are inserting a character in word1 that matches word2, so we are moving a character left in word2 => i, j - 1
 * delete = we are deleting a character in word1, so we are moving a charcter left in word1 => i - 1, j
 * replace = we are moving both character left => i - 1, j - 1
 *
 * (i, j) - min of all three
 */
public class EditDistance
{
	/*
		     h o r s e
		   0 1 2 3 4 5
		 r 1 1 2 2 3 4
		 o 2 2 1 2 3 4
		 s 3 3 2 2 2 3
	 */
	public static int minDistance(String word1, String word2, boolean canReplace, boolean canInsert, boolean canDelete) {
		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		for(int i = 0; i < dp.length; i++)
		{
			for(int j = 0; j < dp[0].length; j++)
			{
				if(i == 0)
					dp[i][j] = j;
				else if(j == 0)
					dp[i][j] = i;
				else if(word1.charAt(i - 1) == word2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else
				{
					int min = Integer.MAX_VALUE;
					min = canReplace ? Math.min(min, dp[i - 1][j - 1]) : min;
					min = canDelete ? Math.min(min, dp[i - 1][j]) : min;
					min = canInsert ? Math.min(min, dp[i][j - 1]) : min;

					dp[i][j] = min + 1;
				}
			}
		}
		Util.printMatrix(dp);
		return dp[word1.length()][word2.length()];
	}

	public static void main(String[] args)
	{
		System.out.println(minDistance("sea", "eat", true, true, true));
	}
}
