package com.wow.wow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wow.wow.dto.OrderDTO;
import com.wow.wow.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(path = "/orders", method = RequestMethod.GET)
	public List<OrderDTO> getUserOrders() {
		return orderService.getOrders();
	}

	@RequestMapping(path = "/admin/orders", method = RequestMethod.GET)
	public List<OrderDTO> getAllOrders() {
		return orderService.getAllOrders();
	}

	@RequestMapping(path = "/orderdetail", method = RequestMethod.GET)
	public OrderDTO getOrderDetail(@RequestParam("orderId") Long orderId) {
		return orderService.getOrderDetail(orderId);
	}
}