package com.deppon.lts.dao;
/**
 * jedis客户端(单机)
 * @author chenhaitao
 *
 */
public interface JedisClient {
	public String get(String key);
	public String set(String key, String value);
	public String hget(String hkey, String key);
	public long hset(String hkey, String key, String value);
	public long incr(String key);
	public long ttl(String key);
}
