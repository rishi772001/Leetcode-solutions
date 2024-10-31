package com.rishi.Hard;

import java.util.ArrayList;
import java.util.List;

public class WordSearchTwo
{
	public static List<String> findWords(char[][] board, String[] words) {
		List<String> out = new ArrayList<String>();
		for(String word : words) // O(n)
		{
			if(find(board, word, out)) out.add(word);
		}

		return out;
	}

	// O(n2)
	private static boolean find(char[][] board, String word, List<String> out)
	{
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board[i].length; j++)
			{
				if(word.charAt(0) == board[i][j] && find(board, board.length, board[i].length, word, 0, i, j))
				{
					return true;
				}
			}
		}
		return false;
	}

	//O(n2)
	public static boolean find(char[][] board, int n, int m, String word, int curr, int i, int j)
	{
		if(i < 0 || j < 0 || i >= n || j >= m)
			return false;


		if(board[i][j] == word.charAt(curr))
		{
			if(curr == word.length() - 1)
			{
				return true;
			}

			char temp = board[i][j];
			board[i][j] = '*';

			boolean isExist = find(board, n, m,word, curr + 1, i + 1, j) ||
				find(board, n, m, word, curr + 1, i - 1, j) ||
				find(board, n, m, word, curr + 1, i, j + 1) ||
				find(board, n, m, word, curr + 1, i, j - 1);

			board[i][j] = temp;
			return isExist;
		}
		return false;
	}

	public static void main(String[] args)
	{
		char[][] board = {{'a', 'a'}};
		findWords(board, new String[]{"aa"});
	}
}