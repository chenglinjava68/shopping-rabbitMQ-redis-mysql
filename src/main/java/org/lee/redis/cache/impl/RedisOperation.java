package org.lee.redis.cache.impl;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.workin.nosql.redis.dao.RedisCommandsDao;

import org.lee.vo.GoodsOrder;

@Component
public class RedisOperation {

	private int dbIndex = 0;
	public static final String ORDERGOODS = "order:goods:";
	public static final int SIZE = -1;
	protected Logger logger = Logger.getLogger(RedisOperation.class);

	@Autowired
	private RedisCommandsDao redisCommandsDao;

	public String addToRedisHash(final String key, final Map<String, Object> map) {
		redisCommandsDao.hMSet(dbIndex, key, map);
		return "OK";
	}

	/**
	 * 在redis生成订单set
	 * 
	 * @param key
	 * @param goodsOrder
	 * @param stockField
	 * @return
	 */
	public String addCart(String key, GoodsOrder goodsOrder, String stockField) {
		String result = "failed";
		String orderKey = ORDERGOODS + goodsOrder.getGoodsId();
		boolean isJoin = redisCommandsDao.sIsMember(dbIndex, orderKey, String.valueOf(goodsOrder.getUserId()));
		if (isJoin) {
			logger.info(
					"the user:" + goodsOrder.getGoodsId() + " already buy the goods(" + goodsOrder.getGoodsId() + ").");
			return "bought";
		}

		Integer value = redisCommandsDao.hGet(dbIndex, key, stockField);
		if (value!=null && value >= SIZE) {
			redisCommandsDao.sAdd(dbIndex,orderKey, new String[] { String.valueOf(goodsOrder.getUserId()) });
			Integer stock = redisCommandsDao.hGet(dbIndex, key, stockField);
			stock = stock - SIZE;
			result = String.valueOf(redisCommandsDao.hSet(dbIndex, key, stockField, stock));
		} else {
			logger.debug(value + " is stock");
		}
		return result;
	}

	public Map<String, Object> exchangeObjToMap(Object obj) {
		Field[] fields = obj.getClass().getDeclaredFields();
		Map<String, Object> map = new HashMap<>();
		for (Field field : fields) {
			field.setAccessible(true);
			Object fieldValue = null;
			String fieldName = null;
			try {
				fieldName = field.getName();
				fieldValue = field.get(obj);

			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				field.setAccessible(false);
			}
			if (fieldValue != null) {
				map.put(fieldName, fieldValue);
			}

		}
		return map;
	}

	/**
	 * 根据正则表达式获取符合条件的key
	 * 
	 * @param pattern
	 * @return
	 */
	public Set<String> getKeysForRegex(String pattern, boolean daemon) {
		Set<String> set = new HashSet<String>();
		set = redisCommandsDao.keys(dbIndex, pattern);
		return set;
	}

	/**
	 * 通过key获取集合所有的值
	 * 
	 * @param key
	 * @return
	 */
	public Set<String> getSetValue(String key, boolean daemon) {

		Set<String> set = new HashSet<String>();
		set = redisCommandsDao.sMembers(dbIndex, key);
		return set;
	}

	/**
	 * 通过key获取散列所有的值
	 * 
	 * @param key
	 * @return
	 */
	public Map<String, Object> getHashValue(String key, boolean daemon) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = redisCommandsDao.hGetAll(dbIndex, key);
		return map;
	}

	/**
	 * 删除redis的key
	 * 
	 * @param key
	 * @return
	 */
	public long deleteRedisKey(String key) {
		long line = redisCommandsDao.del(dbIndex, key);
		if (line != 0)
			logger.info("del "+line+" line");
		else
			logger.info("failed tried del  "+key);
		return line;
	}

	public int getDbIndex() {
		return dbIndex;
	}

	public void setDbIndex(int dbIndex) {
		this.dbIndex = dbIndex;
	}

}
