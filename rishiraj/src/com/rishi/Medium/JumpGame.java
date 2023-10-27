package com.rishi.Medium;

public class JumpGame
{
	private boolean jump(int[] nums, int i)
	{
		if (i == nums.length - 1)
		{
			return true;
		}
		if (i >= nums.length)
		{
			return false;
		}

		for (int jumpCount = 1; jumpCount <= nums[i]; jumpCount++)
		{
			boolean canJump = jump(nums, i + jumpCount);
			if (canJump) return true;
		}
		return false;
	}

	public boolean canJump(int[] nums) {
		return jump(nums, 0);
	}

	public boolean canJumpDP(int[] nums) {
		if (nums.length == 1)
			return true;

		int dp[] = new int[nums.length];

		for (int i = 0; i < nums.length; i++)
		{
			if (i != 0 && dp[i] == 0)
				continue;

			for (int j = i + 1; j < i + 1 + nums[i]; j++)
			{
				if (j < nums.length)
				{
					dp[j] = dp[j] + 1;
				}
			}

			if(dp[dp.length - 1] > 0) return true;
		}

		return dp[dp.length - 1] > 0;
	}
}
