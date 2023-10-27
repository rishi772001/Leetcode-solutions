package com.rishi.util;

public class Util
{
	public static boolean isOutBound(int value, int size)
	{
		return value < 0 || value >= size;
	}
}
