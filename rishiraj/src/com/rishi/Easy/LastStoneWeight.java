package com.rishi.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.rishi.util.Heap;
import com.rishi.util.TreeNode;
import com.rishi.util.Util;

/**
 * 1. Build an max heap
 * 2. Pop top two elements and push again to heap until the heap size is one
 */
public class LastStoneWeight
{
	public static int lastStoneWeight(int[] stones) {
		Heap heap = new Heap(Util.convertToList(stones));
		while(heap.size() > 1)
		{
			int elem1 = heap.pop();
			int elem2 = heap.pop();
			int ans = Math.abs(elem2 - elem1);
			heap.push(ans);
		}
		return heap.pop();
	}

	public static void main(String[] args)
	{
		System.out.println(lastStoneWeight(new int[]{2,7,4,1,8,1}));
	}

}
