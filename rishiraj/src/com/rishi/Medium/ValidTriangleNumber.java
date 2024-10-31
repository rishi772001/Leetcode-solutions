package com.rishi.Medium;

import java.util.HashSet;

public class ValidTriangleNumber
{
	public int triangleNumber(int[] nums) {
		int count = 0;

		for(int base = 0; base < nums.length; base++)
		{
			for(int side1 = base + 1; side1< nums.length; side1++)
			{
				for(int side2 = side1 + 1; side2< nums.length; side2++)
				{
					if(side1 + side2 > base)
						count++;
				}
			}
		}

		return count;
	}
}
