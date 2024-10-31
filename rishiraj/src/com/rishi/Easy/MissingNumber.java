package com.rishi.Easy;

public class MissingNumber
{
	public static int missingNumber(int[] nums) {
		int n = nums.length;
		int s = 0;
		for(int i : nums)
		{
			s += i;
		}

		int maxSum = (n * (n + 1)) / 2;
		return Math.abs(maxSum - s);
	}

	public static void main(String[] args)
	{
		System.out.println(missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
	}
}
