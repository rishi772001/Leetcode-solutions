package com.rishi.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords
{
//	s = "barfoothefoobarman", words = ["foo","bar"]
	public List<Integer> findSubstring(String s, String[] words) {
		HashMap<String, Integer> wordCount = new HashMap<>();
		for(String word : words)
		{
			wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
		}

		List<Integer> out = new ArrayList<>();

		for(int start = 0; start < words[0].length(); start++)
		{
			
			StringBuilder curr = new StringBuilder();
			for(int i = start; i < start + words[0].length(); i++)
			{
				curr.append(i);
			}
			if(wordCount.getOrDefault(curr.toString(), 0) == 0)
				continue;
			else
				out.add(start);
		}

		return out;
	}
}
