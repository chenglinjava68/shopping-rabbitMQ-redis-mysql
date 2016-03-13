package org.lee.service;

import org.lee.vo.Goods;

public interface IGoodsService {
	public String addGoodsToActivity(Goods goods);
	public String buyActivityGoods(int goodsId,int userId);
}
