package org.lee.service.imp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workin.commons.util.CollectionUtils;
import org.workin.json.util.JSONUtils;

import org.lee.dao.GoodsMapper;
import org.lee.redis.cache.impl.RedisOperation;
import org.lee.service.IGoodsService;
import org.lee.util.RequestProducer;
import org.lee.vo.Goods;
import org.lee.vo.GoodsOrder;

@Service
public class GoodsService implements IGoodsService {
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private RedisOperation redisOperation;
	@Autowired
	private RequestProducer requestProducer;
	public static final String EXCHANGE = "buyActivity";
	public static final String ROUTINGKEY = "goods";

	@Override
	public String addGoodsToActivity(Goods goods) {
		int updateRow = goodsMapper.updateGoodsStatus(goods);
		if (updateRow <= 0) {
			return "update error";
		}
		List<Goods> list = null;
		try {
			list = goodsMapper.selectGoods();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Date startTime = new Date();
		startTime.setTime(startTime.getTime()+10000);
		Date endTime = startTime;
		if (CollectionUtils.isNotEmpty(list)){
			for (Goods good : list) {
				goods.setStartTime(startTime);
				goods.setEndTime(endTime);
				goods.setIsActivity(1);
				redisOperation.addToRedisHash("goods:" + good.getId(),
						redisOperation.exchangeObjToMap(good));
			}
		}
		/*Goods result = goodsMapper.selectGoodsById(goods.getId());
		System.out.println(result);
		if (result != null) {
			String redisResult = redisOperation.addToRedisHash("goods:" + result.getId(),
					redisOperation.exchangeObjToMap(result));
			System.out.println(redisResult);
			if ("OK".equals(redisResult)) {
				return redisResult;
			}

		}*/

		return "OK";
	}

	@Override
	public String buyActivityGoods(int goodsId, int userId) {
		GoodsOrder goodsOrder = new GoodsOrder();
		goodsOrder.setGoodsId(goodsId);
		goodsOrder.setUserId(userId);
		String msg = JSONUtils.toString(goodsOrder);
		requestProducer.publish(EXCHANGE, ROUTINGKEY, msg);
		return "join the queue";
	}

}
