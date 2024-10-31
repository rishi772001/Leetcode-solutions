package com.java.sample;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ConcurrentHashMapTrial
{
	private static final int threadSize = 5;

	private static final Map<Long, Long> map = new HashMap<>();

	public static void main(String[] args) throws InterruptedException
	{
		ExecutorService executorService = Executors.newFixedThreadPool(threadSize);
		for(long i = 0; i < threadSize; i++)
		{
			long taskStart = i * 100000;
			executorService.submit(new Task(taskStart));
		}

		executorService.shutdown();

		executorService.awaitTermination(10000000, TimeUnit.SECONDS);
		System.out.println(executorService.isTerminated());
		System.out.println(map.size());
		System.out.println(map);
	}

	static class Task implements Runnable
	{
		private final long start;

		Task(long start)
		{
			this.start = start;
		}

		@Override public void run()
		{
			for(long i = start; i < start + 10; i++)
			{
				map.put(i, i);
			}
		}
	}
}
