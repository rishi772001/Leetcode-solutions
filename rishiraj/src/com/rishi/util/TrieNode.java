package com.rishi.util;

public class TrieNode
{
	// Array for child nodes of each node
	public TrieNode[] child;

	// Used for indicating the end of a string
	public boolean wordEnd;
	public String word;

	// Constructor
	public TrieNode()
	{

		// Initialize the wordEnd
		// variable with false
		wordEnd = false;

		// Initialize every index of
		// the child array with null
		// In Java, we do not have to
		// explicitely assign null as
		// the values are by default
		// assigned as null
		child = new TrieNode[26];
	}
}

