package com.rishi.Medium;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK
{
	public static int subarraySum(int[] nums, int k) {
		int n = nums.length;
		Map<Integer, Integer> prefixSumMap = new HashMap<>();
		int count = 0;
		int sum = 0;
		for(int i = 0; i < n; i++)
		{
			sum += nums[i];

			// Subarray from zeroth index to current element exist
			if(sum == k)
				count++;

			// Subarray from that index to current index exist
			if(prefixSumMap.containsKey(sum - k))
				count+=prefixSumMap.get(sum - k);

			prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);
		}
		return count;
	}

	public static void main(String[] args)
	{
		System.out.println(subarraySum(new int[]{-1,-1, 1}, 0));
	}
}
