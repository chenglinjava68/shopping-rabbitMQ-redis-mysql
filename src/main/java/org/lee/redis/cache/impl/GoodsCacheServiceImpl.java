package org.lee.redis.cache.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.workin.commons.util.StringUtils;
import org.workin.nosql.redis.dao.RedisCommandsDao;

import org.lee.redis.cache.GoodsCacheService;
import org.lee.service.IOrderService;
import org.lee.vo.Goods;

@Component
public class GoodsCacheServiceImpl implements GoodsCacheService {
	@Autowired
	private RedisCommandsDao redisCommandsDao;
	@Autowired
	private IOrderService orderService;
	public static final String STOCK = "stock";
	public static final String ENDTIME = "endTime";
	public static final String ORDERGOODS = "order:goods:";
	public static final String GOODSPATTERN = "goods:*";
	public static final String GOODS="goods:";
	public static final ExecutorService excutorService = Executors.newFixedThreadPool(4);

	@Override
	public void set(Goods goods) {
		redisCommandsDao.sAdd(0, "order:goods:1", "goods");
		redisCommandsDao.set(1, StringUtils.toString(goods.getId()), goods);
	}

	@Override
	public Goods getGoods(long goodsId) {
		// TODO Auto-generated method stub
		return null;
	}

}
