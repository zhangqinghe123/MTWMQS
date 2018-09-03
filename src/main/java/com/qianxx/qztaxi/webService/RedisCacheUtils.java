package com.qianxx.qztaxi.webService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheUtils<T> {

	@SuppressWarnings("rawtypes")
	@Autowired
	@Qualifier("jedisTemplate")
	public RedisTemplate redisTemplate;

	/**
	 * 缓存基本的对象，Integer、String、实体类等
	 * @param key 缓存的键值
	 * @param value 缓存的值
	 * @return 缓存的对象
	 */
	@SuppressWarnings({ "hiding", "unchecked" })
	public <T> ValueOperations<String, T> setCacheObject(String key, T value, Integer expireMinutes) {
		ValueOperations<String, T> operation = redisTemplate.opsForValue();
		operation.set(key, value);
		if (expireMinutes != null) {
			redisTemplate.expire(key, expireMinutes, TimeUnit.MINUTES);
		}
		return operation;
	}

	/**
	 * 获得缓存的基本对象。
	 * @param key 缓存键值
	 * @param operation
	 * @return 缓存键值对应的数据
	 */
	@SuppressWarnings({ "hiding", "unchecked" })
	public <T> T getCacheObject(String key) {
		ValueOperations<String, T> operation = redisTemplate.opsForValue();
		return operation.get(key);
	}

	/**
	 * 如果redis中不存在记录则加入
	 * @param key
	 * @param value
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "hiding" })
	public <T> ValueOperations<String, T> setCacheObjectIfAbsent(String key, T value, Integer expireMinutes) {
		ValueOperations<String, T> operation = redisTemplate.opsForValue();
		operation.setIfAbsent(key, value);
		if (expireMinutes != null) {
			redisTemplate.expire(key, expireMinutes, TimeUnit.MINUTES);
		}
		return operation;
	}

	/**
	 * 缓存List数据
	 * @param key 缓存的键值
	 * @param dataList 待缓存的List数据
	 * @return 缓存的对象
	 */
	@SuppressWarnings({ "hiding", "unchecked", "rawtypes" })
	public <T> ListOperations<String, T> setCacheList(String key, List<T> dataList) {
		ListOperations listOperation = redisTemplate.opsForList();
		if (null != dataList) {
			int size = dataList.size();
			for (int i = 0; i < size; i++) {
				listOperation.rightPush(key, dataList.get(i));
			}
		}
		return listOperation;
	}

	/**
	 * 获得缓存的list对象
	 * @param key 缓存的键值
	 * @return 缓存键值对应的数据
	 */
	@SuppressWarnings({ "hiding", "unchecked" })
	public <T> List<T> getCacheList(String key) {
		List<T> dataList = new ArrayList<T>();
		ListOperations<String, T> listOperation = redisTemplate.opsForList();
		Long size = listOperation.size(key);
		for (int i = 0; i < size; i++) {
			dataList.add((T) listOperation.index(key, i));
		}
		return dataList;
	}

	/**
	 * 缓存Set
	 * @param key 缓存键值
	 * @param dataSet 缓存的数据
	 * @return 缓存数据的对象
	 */
	@SuppressWarnings({ "hiding", "unchecked" })
	public <T> BoundSetOperations<String, T> setCacheSet(String key, Set<T> dataSet) {
		BoundSetOperations<String, T> setOperation = redisTemplate.boundSetOps(key);
		Iterator<T> it = dataSet.iterator();
		while (it.hasNext()) {
			setOperation.add(it.next());
		}
		return setOperation;
	}

	/**
	 * 获得缓存的set
	 */
	@SuppressWarnings({ "unchecked" })
	public Set<T> getCacheSet(String key) {
		Set<T> dataSet = new HashSet<T>();
		BoundSetOperations<String, T> operation = redisTemplate.boundSetOps(key);
		Long size = operation.size();
		for (int i = 0; i < size; i++) {
			dataSet.add(operation.pop());
		}
		return dataSet;
	}

	/**
	 * 缓存Map
	 */
	@SuppressWarnings({ "hiding", "unchecked", "rawtypes" })
	public <T> HashOperations<String, String, T> setCacheMap(String key, Map<String, T> dataMap) {
		HashOperations hashOperations = redisTemplate.opsForHash();
		if (null != dataMap) {
			for (Map.Entry<String, T> entry : dataMap.entrySet()) {
				hashOperations.put(key, entry.getKey(), entry.getValue());
			}
		}
		return hashOperations;
	}

	/**
	 * 获得缓存的Map
	 */
	@SuppressWarnings({ "hiding", "unchecked" })
	public <T> Map<String, T> getCacheMap(String key) {
		Map<String, T> map = redisTemplate.opsForHash().entries(key);
		return map;
	}

	/**
	 * 缓存Map
	 */
	@SuppressWarnings({ "hiding", "unchecked", "rawtypes" })
	public <T> HashOperations<String, Integer, T> setCacheIntegerMap(String key, Map<Integer, T> dataMap) {
		HashOperations hashOperations = redisTemplate.opsForHash();
		if (null != dataMap) {
			for (Map.Entry<Integer, T> entry : dataMap.entrySet()) {
				hashOperations.put(key, entry.getKey(), entry.getValue());
			}
		}
		return hashOperations;
	}

	/**
	 * 获得缓存的Map
	 */
	@SuppressWarnings({ "hiding", "unchecked" })
	public <T> Map<Integer, T> getCacheIntegerMap(String key) {
		Map<Integer, T> map = redisTemplate.opsForHash().entries(key);
		return map;
	}

	/**
	 * 删除缓存
	 */
	@SuppressWarnings("unchecked")
	public void deleteCache(Object key) {
		redisTemplate.delete(key);
	}

}