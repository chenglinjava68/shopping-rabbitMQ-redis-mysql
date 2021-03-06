package org.lee.redis.cache.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.lee.service.IOrderService;
import org.lee.vo.Order;

@Component
public class RedistoRdmb implements Runnable ,InitializingBean{
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
	
	private static final Logger logger = LoggerFactory.getLogger(RedistoRdmb.class);
	public void run() {
		while (true) {
			
			try{
				Thread.sleep(3000);
				//System.out.println(orderService);
			Set<String> set = redisOperation.getKeysForRegex(GOODSPATTERN,false);
			for (final String str : set) {
				//excutorService.execute(new Thread(new Runnable() {

				//	@Override
				//	public void run() {*/
						// System.out.println("before"+UUID.randomUUID().toString());
						//System.out.println(str);
						Map<String, Object> map = redisOperation.getHashValue(str,false);
						//System.out.println(checkEndGoodsOrder(map));
						if (checkEndGoodsOrder(map)) {
							addRedisDataToMysql(map);
							redisOperation.deleteRedisKey(ORDERGOODS + map.get("id"));
							//redisOperation.deleteRedisKey(GOODS+map.get("id"));
						}

					}

				//}));

			//}
			}catch(Exception e){
				e.printStackTrace();
			}
			/*finally{
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		}
	}

	public int addRedisDataToMysql(Map<String, Object> map) {
		Integer id = (Integer) map.get("id");
		String key = ORDERGOODS + id;
		Set<String> set = redisOperation.getSetValue(key,true);
		List<Order> list = new ArrayList<Order>();
		for (String tmp : set) {
			Order order = new Order();
			order.setGoodsId(id);
			//System.out.println("after" + UUID.randomUUID().toString());
			order.setOrderId(UUID.randomUUID().toString());
			order.setPrice((Float) map.get("price"));
			order.setPromotionPrice((Float) map.get("promotionPrice"));
			order.setUserId(Integer.parseInt(tmp));
			order.setCreateTime(new Date());
			list.add(order);

		}
		if(list==null||list.size()==0){
			return 0;
		}
		return orderService.insertBatchOrder(list);
	}

	public boolean checkEndGoodsOrder(Map<String, Object> map) {
		Date currentTime = new Date();
		Date endTime = (Date)map.get(ENDTIME);
		if (endTime != null && endTime.before(currentTime)) {
			return true;
		}
		Integer stock = (Integer) map.get(STOCK);
		if (stock != null && stock <1) {
			logger.info(endTime+" msg stock "+stock);
			return true;
		}
		return false;
	}


	public void afterPropertiesSet() throws Exception {
		new Thread(this).start();
	}
}
