package org.lee.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import org.lee.vo.Goods;

@Repository
public interface GoodsMapper {
	public int updateGoodsStatus(Goods goods);

	public Goods selectGoodsById(int goodsId);

	public List<Goods> selectGoods();
}
