package com.rishi.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak
{
	/*
	 applepenapplee
	 apple pen penapplee

	 */

	public static boolean wordBreakHelper(String s, int len, List<String> wordDict, int current, String temp)
	{
		if(current == len)
			return wordDict.contains(temp);

		// Break the word at current
		if(wordDict.contains(temp) && wordBreakHelper(s, len, wordDict, current+1, String.valueOf(s.charAt(current))))
			return true;

		// Dont break the word at current
		return wordBreakHelper(s, len, wordDict, current+1, temp + s.charAt(current));
	}

	public boolean wordBreakBruteforce(String s, List<String> wordDict) {
		return wordBreakHelper(s, s.length(), wordDict, 0, "");
	}

	public static boolean wordBreak(String s, List<String> wordDict) {
		/*
		 		a p p l e p e n a p p l e e
		 		0 0 0 0 1 0 0 1 0 0 0 0 0 1

		 */

		int[] dp = new int[s.length()];
		for(int i = 0; i < s.length(); i++)
		{
			String temp = "";
			for(int j = i; j >= 0 ; j--)
			{
				if(wordDict.contains(temp))
				{
					dp[i] = 1;
					break;
				}
				else
					temp = s.charAt(j) + temp;
			}
			if(wordDict.contains(temp))
				dp[i] = 1;
		}
		System.out.println(Arrays.toString(dp));
		return dp[s.length() - 1] == 1;
	}

	public static void main(String[] args)
	{
//		System.out.println(wordBreak("aaaaaaa", List.of("aa", "aaaa")));
	}
}
