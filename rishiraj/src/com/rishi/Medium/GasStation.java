package com.rishi.Medium;

public class GasStation
{
	/*
	gas = [1,2,3,4,5]
	cost = [3,4,5,1,2]
	 */
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int ptr = 0;
		int currentGas = 0;
		int currCount = 0;
		int totalCount = 0;

		while(currCount <= cost.length && totalCount++ <= cost.length * 2)
		{
			if(currentGas >= 0)
			{
				currentGas += gas[ptr] - cost[ptr];
				currCount++;
			}
			else
			{
				currentGas = gas[ptr] - cost[ptr];
				currCount = 1;
			}
			ptr++;
			ptr = ptr % cost.length;
		}

		System.out.println(currCount);
		return currCount == cost.length + 1? (ptr + cost.length - 1) % cost.length : -1;
	}

	public static void main(String[] args)
	{
		System.out.println(canCompleteCircuit(new int[]{3,1,1}, new int[]{1,2,2}));
		System.out.println(canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
		System.out.println(canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}));
		System.out.println(canCompleteCircuit(new int[]{1,2}, new int[]{0,1}));
	}
}
