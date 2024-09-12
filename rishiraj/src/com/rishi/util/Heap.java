package com.rishi.util;

import java.util.List;

public class Heap
{
	List<Integer> nums;

	public Heap(List<Integer> nums)
	{
		this.nums = nums;
		buildHeap();
	}

	public int size()
	{
		return nums.size();
	}

	/**
	 * 1. Replace the last element to the root and delete it
	 * 2. heapify the root
	 */
	public int pop()
	{
		if(nums.isEmpty())
		{
			throw new ArrayIndexOutOfBoundsException("Could not pop from empty array");
		}
		if(nums.size() == 1)
		{
			return nums.remove(0);
		}

		int max = nums.get(0);
		nums.set(0, nums.remove(nums.size() - 1));
		heapify(0);
		return max;
	}

	/**
	 * 1. Add the element to the last
	 * 2. heapify from the parent of newly added element till the root
	 */
	public void push(int val)
	{
		nums.add(val);
		int parent = ((nums.size() - 1) - 1) / 2;
		while(parent >= 0)
		{
			heapify(parent);
			if(parent == 0)
			{
				return; // Ithu en potan na.. if the value is 0, (0 - 1) / 2 returns 0(As 0.5 is rounded of to 0 in integer division) and the loop is infinite.
			}
			parent = (parent - 1) / 2;
		}
	}

	/**
	 * To heapify the current node, we need all its subtree nodes should be a heap,
	 * So we start from reverse and start heapifying till the root.
	 */
	private void buildHeap()
	{
		// We are starting with the Last non-leaf node as we need not heapify leaf nodes
		int i = (nums.size() / 2) - 1;
		while(i >= 0)
		{
			heapify(i--);
		}
	}

	/**
	 * swap the root with either left or right(which is max) and heapify the affected subtree
	 */
	private void heapify(int i)
	{
		int left = i * 2 + 1;
		int right = i * 2 + 2;

		int largest = i;
		if(left < nums.size() && nums.get(left) > nums.get(largest))
			largest = left;
		if(right < nums.size() && nums.get(right) > nums.get(largest))
			largest = right;

		if(largest != i)
		{
			int temp = nums.get(i);
			nums.set(i, nums.get(largest));
			nums.set(largest, temp);
			heapify(largest); // Heapify the affected sub tree due to swap
		}
	}
}
