package com.rishi.Hard;

import com.rishi.util.Util;

public class CherryPickup
{
	/*
	[
	[1,1,-1],
	[1,-1,1],
	[-1,1,1]
	]
	 */

	public int cherryPickup(int[][] grid, int i, int j, int n, int m, int cherriesPicked)
	{
		if(Util.isOutBound(i, j, n, m) || grid[i][j] == -1)
		{
			return 0;
		}
		if(i == n-1 && j == m-1)
		{
			return grid[i][j] + cherriesPicked;
		}

		int temp = grid[i][j];
		grid[i][j] = -1;
		int maxCherryPickup = Integer.max(cherryPickup(grid, i+1, j, n, m, cherriesPicked + temp), cherryPickup(grid, i, j+1, n, m, cherriesPicked + temp));
		grid[i][j] = temp;
		return maxCherryPickup;
	}

	public int cherryPickup(int[][] grid) {
		return cherryPickup(grid, 0, 0, grid.length, grid[0].length, 0);
	}
}
