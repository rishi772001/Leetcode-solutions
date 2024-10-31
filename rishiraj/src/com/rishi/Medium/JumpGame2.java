package com.rishi.Medium;

public class JumpGame2 {

	public int jump(int[] nums) {
		/* [0,1,2,2,0] */
		if (nums.length == 1)
			return 0;

		int dp[] = new int[nums.length];

		for (int i = 0; i < nums.length; i++)
		{
			if (i != 0 && dp[i] == 0)
				continue;

			for (int j = i + 1; j < i + 1 + nums[i]; j++)
			{
				if (j < nums.length)
				{
					dp[j] = dp[j] != 0 ? Math.min(dp[j], dp[i] + 1) : dp[i] + 1;
				}
			}

			if(dp[dp.length - 1] > 0)
			{
				return dp[dp.length - 1];
			}
		}

		return dp[dp.length - 1] > 0 ? dp[dp.length - 1] : -1;
	}

	public static int jumpGreedy(int[] nums) {
		int near = 0; // left pointer
		int far = nums[near]; // right pointer
		int farthest = 0; // choose where to jump(curr index + jump value > farthest) - ranges between near and far
		int jumps = 0;

		if(nums.length == 1)
			return 0;

		while(far < nums.length)
		{
			while(near <= far)
			{
				if(nums[near] + near > farthest)
					farthest = nums[near] + near;
				near++;
			}

			if(far == nums.length - 1)
				return jumps + 1;

			if(farthest == far)
			{
				System.out.println("Cannot jump to the end");
				return -1;
			}
			far = farthest;
			jumps++;
		}

		return jumps + 1;
	}

	public static void main(String[] args)
	{
		System.out.println(jumpGreedy(new int[]{1,2,3}));
	}
}
