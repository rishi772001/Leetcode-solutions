package com.rishi.Hard;

import java.util.ArrayList;
import java.util.List;

import com.rishi.util.TreeNode;
import com.rishi.util.Trie;
import com.rishi.util.TrieNode;

/**
 * Cases to be handled yet:
 */
public class WordBreakTwo
{
	/*
	s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
	               			    /
	               c        a 		s        d
	               a		n		a	 o       a
	               t=cat	d		n    g		 r
	               s=cats			d			 k


	 */
	public static List<String> wordBreak(String s, List<String> wordDict) {
		Trie trie = new Trie(wordDict);
		List<String> output = new ArrayList<String>();
		StringBuilder stringBuilder = new StringBuilder();
		findWords(trie.root, output, s, 0, stringBuilder);
		return output;
	}

	private static void findWords(TrieNode trie, List<String> output, String s, int currIndex, StringBuilder currentBuilder)
	{
		TrieNode node = trie;
		while(currIndex < s.length())
		{
			char currChar = s.charAt(currIndex);
			int intValue = currChar - 'a';
			if(node != null && node.child[intValue] != null)
			{
				node = node.child[intValue];
				if(node.wordEnd)
				{
					currentBuilder.append(node.word);
					currentBuilder.append(" ");
					node = trie;
				}
			}
			else
				node = trie;

			
			currIndex++;
		}
		output.add(currentBuilder.toString());
	}


	public static List<String> wordBreakDP(String s, List<String> wordDict)
	{
		/*
		     012       3        456         789
			"cat       s        and         dog"
			   (0, cat)(0, cats)  (4, and)    (7, dog)
			   					  (3, sand)
		*/
		return null;
	}

	public static void main(String[] args)
	{
		System.out.println(wordBreak("catsanddog", List.of("cat","cats","and","sand","dog")));
	}
}
