package com.java.sample;

import java.util.ArrayList;
import java.util.List;

public class Splitwise
{
	public static void simplyfy(int[][] graph)
	{
		/*
				0 ->
		 */
	}

	public static void main(String[] args)
	{
		/*
		 user   0 	1 	2 	3
			0	0 	100 20 	0
			1	10 	0 	20 	60
			2   0 	50 	30 	0
			3   20 	45 	0 	0
		 */

		int[][] graph = new int[][] {
			{0, 100, 20, 0},
			{10, 0, 20, 60},
			{0, 50, 30, 0},
			{20, 45, 0, 0}};

		/*
		0: [(1, 100), (2, 20)]
		1: [(0, 10), (2, 20), (3, 60)]
		2: [(1, 50)]
		3: [(0, 20), (1, 45)]
		 */

		List<List<Integer>> list = new ArrayList<>();
		/*
						0
					(100)
				1

				2
						3


		 */

	}
}
