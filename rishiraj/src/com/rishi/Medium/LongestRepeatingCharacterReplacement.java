package com.rishi.Medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement
{
	public int characterReplacement(String s, int k)
	{
		int out = 0;
		Map<Character, Integer> countMap = new HashMap<>();
		int left = 0;
		int i = 0;
		while(i < s.length())
		{
			countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0) + 1);
			int maxCount = 0;
			int totalCount = 0;
			char maxChar = 'A';
			for(char key : countMap.keySet())
			{
				if(countMap.get(key) > maxCount)
				{
					maxCount = countMap.get(key);
					maxChar = key;
				}
				totalCount++;
			}

			if(totalCount - maxCount > k)
			{
				countMap.put(s.charAt(left), countMap.get(s.charAt(left)) - 1);
				left++;
			}
			else
				i++;

			out = Math.max(out, i - left);
		}

		return out;
	}
}