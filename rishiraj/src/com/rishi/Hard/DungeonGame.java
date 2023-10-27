package com.rishi.Hard;

public class DungeonGame
{
		private static int calc(int[][] dungeon, int i, int j, int currEnergy, int currMinEnergy, int maxEnergy)
		{
			int m = dungeon.length;
			int n = dungeon[0].length;

			if (i == m - 1 && j == n - 1) {
//				System.out.println(Math.max(maxEnergy, Math.min(currMinEnergy, currEnergy + dungeon[i][j])));
				return Math.max(maxEnergy, currMinEnergy);
			}

			if (check(i, j, m, n))
				return maxEnergy;

			return Math.max(calc(dungeon, i, j + 1, currEnergy + dungeon[i][j], Math.min(currMinEnergy, currEnergy + dungeon[i][j]), maxEnergy), calc(dungeon, i + 1, j, currEnergy + dungeon[i][j], Math.min(currMinEnergy, currEnergy + dungeon[i][j]), maxEnergy));
		}

		private static boolean check(int i, int j, int m, int n)
		{
			return i < 0 || j < 0 || i >= m || j >= n;
		}

		public static int calculateMinimumHP(int[][] dungeon)
		{
			return Math.abs(calc(dungeon, 0, 0, 0, 0, Integer.MIN_VALUE)) + 1;
		}

	public static void main(String[] args)
	{
		int[][] arr = {{-2,400},{-5,-10},{10,-300}};
		System.out.println(calculateMinimumHP(arr));

					/*
[[-2,-3,3],
[-5,-10,1],
[10,30,-5]]
*/
	}
}
