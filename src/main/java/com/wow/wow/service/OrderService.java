package com.wow.wow.service;

import java.util.List;

import com.wow.wow.dto.OrderDTO;

public interface OrderService {
	public List<OrderDTO> getOrders();

	public List<OrderDTO> getAllOrders();

	public OrderDTO getOrderDetail(Long orderId);
}
