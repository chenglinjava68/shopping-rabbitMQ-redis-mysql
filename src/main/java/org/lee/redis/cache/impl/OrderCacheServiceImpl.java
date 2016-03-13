package org.lee.redis.cache.impl;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



import org.lee.redis.cache.OrderCacheService;
import org.lee.service.IOrderService;
import org.lee.vo.Order;

@Component
public class OrderCacheServiceImpl implements OrderCacheService {
	@Autowired
	private RedisOperation redisOperation;
	@Autowired
	private IOrderService orderService;
	public static final String STOCK = "stock";
	public static final String ENDTIME = "endTime";
	public static final String ORDERGOODS = "order:goods:";
	public static final String GOODSPATTERN = "goods:*";
	public static final String GOODS="goods:";
	public static final ExecutorService excutorService = Executors.newFixedThreadPool(4);

	@Override
	public void set(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Order getOrder(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
