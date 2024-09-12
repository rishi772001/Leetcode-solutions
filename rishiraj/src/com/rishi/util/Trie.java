package com.rishi.util;

import java.util.List;

public class Trie
{
	public TrieNode root;

	public Trie(List<String> listOfWords)
	{
		root = new TrieNode();
		for(String word : listOfWords)
		{
			TrieNode node = root;
			for(char c : word.toCharArray())
			{
				int intValue = c - 'a';
				if(node.child[intValue] == null)
				{
					node.child[intValue] = new TrieNode();
					node = node.child[intValue];
				}
				else
				{
					node = node.child[intValue];
				}
			}
			node.wordEnd = true;
			node.word = word;
		}
	}
}
