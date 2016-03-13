package org.lee.redis.cache;

import org.lee.vo.Goods;

public interface GoodsCacheService {
	
	public void set(Goods goods);

    public Goods getGoods(long goodsId);

}
