package org.lee.redis.cache;

import org.lee.vo.Order;

public interface OrderCacheService {
	
	public void set(Order order);

    public Order getOrder(long userId);

}
