package com.rishi.Medium;

public class PalindromicSubStrings
{
	public static int countSubstrings(String s) {
		int count = 0;
		for(int i = 0; i < s.length(); i++)
		{
			// Imagine i is the middle element of the palindromic substring we are trying to find
			count += countPalindromes(i, i, s);
			count += countPalindromes(i, i + 1, s);
		}
		return count;
	}

	private static int countPalindromes(int left, int right, String s)
	{
		int count = 0;
		// Start expanding the string in both left and right if it matches until it reaches end of string
		while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
		{
			count += 1;
			left -= 1;
			right += 1;
		}
		return count;
	}

	public static void main(String[] args)
	{
		countSubstrings("aaa");
	}
}
