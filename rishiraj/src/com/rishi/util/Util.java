package com.rishi.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util
{
	public static boolean isOutBound(int value, int size)
	{
		return value < 0 || value >= size;
	}

	public static boolean isOutBound(int i, int j, int n, int m)
	{
		return i < 0 || i >= n || j < 0 || j >= m;
	}

	public static List<Integer> convertToList(int[] arr)
	{
		return Arrays.stream(arr).boxed().collect(Collectors.toList());
	}

	public static void printMatrix(int[][] arr)
	{
		for(int[] row : arr)
		{
			System.out.println(Arrays.toString(row));
		}
	}
}
