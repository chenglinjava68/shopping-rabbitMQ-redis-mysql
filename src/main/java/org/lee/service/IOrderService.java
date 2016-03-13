package org.lee.service;

import java.util.List;

import org.lee.vo.Order;

public interface IOrderService {
	public int insertBatchOrder(List<Order> order);
}
