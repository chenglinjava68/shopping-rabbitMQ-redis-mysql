package org.lee.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import org.lee.vo.Order;

@Repository
public interface OrderMapper {
	public int insertBatchOrder(List<Order> order);
}
