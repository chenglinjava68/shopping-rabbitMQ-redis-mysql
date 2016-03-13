package org.lee.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.workin.web.spring.ControllerSupport;

import org.lee.dao.GoodsMapper;
import org.lee.redis.cache.GoodsCacheService;
import org.lee.redis.cache.OrderCacheService;
import org.lee.request.AddGoodsRequest;
import org.lee.service.IGoodsService;
import org.lee.vo.Goods;
import org.lee.vo.User;

@Controller
public class GoodsController extends ControllerSupport {

	@Autowired
	private IGoodsService promotionService;

	@Autowired
	OrderCacheService orderCacheService;
	
	@Autowired
	GoodsCacheService goodsCacheService;

	@Autowired
	GoodsMapper goodsMapper;

	@RequestMapping(value = "/addGoodsToActivity", method = RequestMethod.POST)
	@ResponseBody
	public String addGoodsToActivity(AddGoodsRequest request) {
		Goods goods = new Goods();
		goods.setId(request.getGoodsId());
		/*System.out.println(request.getStartTime());
		try{
			goods.setStartTime(Timestamp.valueOf(request.getStartTime()));
			goods.setEndTime(Timestamp.valueOf(request.getEndTime()));
			goods.setIsActivity('1');
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		System.out.println("before");*/
		String result = promotionService.addGoodsToActivity(goods);
		return result;
	}

	@RequestMapping("/buyActivityGoods")
	@ResponseBody
	public String buyActivityGoods(int goodsId,HttpServletRequest request){
		User user=(User) request.getSession().getAttribute("user");
		return promotionService.buyActivityGoods(goodsId, user.getId());
		
	}

	@RequestMapping("/goods")
	@ResponseBody
	public Goods goods(int goodsId,HttpServletRequest request){
		User user=(User) request.getSession().getAttribute("user");
		Goods goods = goodsMapper.selectGoodsById(goodsId);
		goodsCacheService.set(goods);
		return goodsCacheService.getGoods(goods.getId());
		
	}
}
