package com.java.sample;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RedisConnector
{
	public static void main(String[] args)
	{
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(100); // Maximum number of connections

		// Create the JedisPool

			// Get a Jedis connection from the pool
			ExecutorService executorService = Executors.newFixedThreadPool(5);
			for(int i = 1; i <= 5; i++)
			{
				int finalI = i;
				executorService.execute(() -> {
							try(JedisPool jedisPool = new JedisPool(config, "localhost", 6379, 200000))
							{
								try(Jedis jedis = jedisPool.getResource())
								{
//									String res = jedis.get("key");
									jedis.set("key", String.valueOf(finalI));
//									System.out.println(res);
								}
							}
					});
			}
			executorService.shutdown();
		}

}
