package com.rishi.Medium;

public class LongestCommonSubsequence
{
	/*
	        a b c d e
	      0 0 0 0 0 0
	    a 0 1 1 1 1 1
	    b 0 1 2 2 2 2
	    p 0 1 2 2 2 2
	    e 0 1 2 2 2 3
	 */
	public static int longestCommonSubsequence(String text1, String text2) {
		int[][] dp = new int[text1.length() + 1][text2.length() + 1];
		for(int i = 0; i <= text1.length(); i++)
		{
			for(int j = 0; j <= text2.length(); j++)
			{
				if(i == 0 || j == 0)
					dp[i][j] = 0;
				else if(text1.charAt(i - 1) == text2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1] + 1; // if character matches, We will add one to the value with excluding both i and j character
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // if character not matches, We will take the value with max of excluding either ith or jth character
			}
		}
		return dp[text1.length()][text2.length()];
	}
}
