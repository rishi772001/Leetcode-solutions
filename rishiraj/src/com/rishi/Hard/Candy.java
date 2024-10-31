package com.rishi.Hard;

import java.util.Arrays;

public class Candy
{
	/*
		1,2,3,2,4,2

		1,2,2,1,2,1

		1,2,3,1,2,1
	 */
	public int candy(int[] ratings) {
		int[] chocolates = new int[ratings.length];
		Arrays.fill(chocolates, 1);

		int[] chocolatesRev = new int[ratings.length];
		Arrays.fill(chocolatesRev, 1);

		// Iterating all the elements except boundary
		for(int i = 1; i < ratings.length - 1; i++)
		{
			if(ratings[i - 1] < ratings[i])
			{
				chocolates[i] = chocolates[i - 1] + 1;
			}
		}
		if(ratings[0] > ratings[1])
		{
			chocolates[0] = chocolates[1] + 1;
		}
		if(ratings[ratings.length - 1] > ratings[ratings.length - 2])
		{
			chocolates[ratings.length - 1] = chocolates[ratings.length - 2] + 1;
		}

		// Iterating all the elements except boundary
		for(int i = ratings.length - 2; i > 1; i--)
		{
			if(ratings[i + 1] < ratings[i])
			{
				chocolatesRev[i] = chocolatesRev[i + 1] + 1;
			}
		}
		if(ratings[0] > ratings[1])
		{
			chocolatesRev[0] = chocolatesRev[1] + 1;
		}
		if(ratings[ratings.length - 1] > ratings[ratings.length - 2])
		{
			chocolatesRev[ratings.length - 1] = chocolatesRev[ratings.length - 2] + 1;
		}

		int sum = 0;
		for(int i = 0; i < ratings.length; i++)
		{
			sum += Math.max(chocolates[i], chocolatesRev[i]);
		}

		System.out.println(Arrays.toString(chocolates));
		System.out.println(Arrays.toString(chocolatesRev));

		return sum;
	}
}
