package com.rishi.Medium;

public class UniquePaths
{
	public static int uniquePaths(int m, int n) {

        /*
            11
            12
            13
        */

		int[][] dp = new int[m][n];

		for (int i = 0; i < m; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if (i == 0 && j == 0)
					dp[i][j] = 1;

				else if (i < 1)
					dp[i][j] = dp[i][j - 1];

				else if (j < 1)
					dp[i][j] = dp[i - 1][j];

				else
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}

		// for (int i = 0; i < m; i++)
		// {
		//     for (int j = 0; j < n; j++)
		//         System.out.print(dp[i][j]);
		//     System.out.println();
		// }
		return dp[m - 1][n - 1];
	}

	public static void main(String[] args)
	{
		System.out.println(uniquePaths(3, 2));
	}
}