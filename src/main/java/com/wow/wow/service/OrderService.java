package com.wow.wow.service;

import java.util.List;

import com.wow.wow.dto.OrderProjection;

public interface OrderService {
	public List<OrderProjection> getOrders();

	public List<OrderProjection> getAllOrders();

	public OrderProjection getOrderDetail(Long orderId);
}
