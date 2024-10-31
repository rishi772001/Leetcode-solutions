package com.rishi.Easy;

public class MajorityElement
{
	/*
			3,2,3

			11
			10
			11

			11

	 */
	public static int majorityElement(int[] nums) {
		int mask = 1;
		int output = 0;
		for(int i = 0; i < 32; i++)
		{
			int count = 0;
			for(int n : nums)
			{
				if((n & mask) > 0)
				{
					count++;
				}
				if(count > (nums.length / 2))
				{
					output += (int) Math.pow(2, i);
					break;
				}
			}
			mask = mask << 1;
		}

		int verify = 0;
		for(int n : nums)
			if(n == output)
				verify++;

		if(verify > nums.length / 2)
			return output;
		return -1;
	}

	public static int majorityElement1(int[] nums) {
		int res = 0;
		int majority = 0;

		for (int n : nums) {
			if (majority == 0) {
				res = n;
			}

			majority += n == res ? 1 : -1;
		}

		return res;
	}

	public static void main(String[] args)
	{
		System.out.println(majorityElement(new int[]{1000000000,1000000000,-1000000000,-1000000000,-1000000000}));
	}
}
