package org.lee.service.imp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.lee.dao.OrderMapper;
import org.lee.service.IOrderService;
import org.lee.vo.Order;

@Service
public class OrderService implements IOrderService {
	@Autowired
	private OrderMapper orderMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
	public int insertBatchOrder(List<Order> orderList) {
		logger.debug("insert size is "+orderList.size());
		return orderMapper.insertBatchOrder(orderList);
	}
}
