package com.rishi.Hard;

// Refer - https://www.youtube.com/watch?v=vURq_xYGr-k&ab_channel=PratikshaBakrola

public class LongestValidParanthesis
{
	public int longestValidParentheses(String s) {
		int left = 0, right = 0, max = 0;
		for(char c : s.toCharArray())
		{
			if(c == '(')
			{
				left++;
			}
			else
			{
				right++;
				if(right == left)
					max = Math.max(max, left + right);
				else if(right > left)
				{
					left = 0;
					right = 0;
				}
			}
		}
		left=0;
		right=0;
		for(int i = s.length() - 1; i >= 0; i--)
		{
			if(s.charAt(i) == '(')
			{
				left++;
				if(right == left)
					max = Math.max(max, left + right);
				else if(left > right)
				{
					left = 0;
					right = 0;
				}
			}
			else
			{
				right++;
			}
		}
		return max;
	}

	public static void main(String[] args)
	{
		System.out.println(new LongestValidParanthesis().longestValidParentheses("(()(((()"));
	}
}
