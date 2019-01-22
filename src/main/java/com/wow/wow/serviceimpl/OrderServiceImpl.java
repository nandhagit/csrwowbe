package com.wow.wow.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wow.wow.dto.OrderProjection;
import com.wow.wow.model.WowUser;
import com.wow.wow.repository.AddressRepository;
import com.wow.wow.repository.OrdersRepository;
import com.wow.wow.repository.WowUserRepository;
import com.wow.wow.service.OrderService;
import com.wow.wow.utility.UserUtil;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrdersRepository orderRepo;

	@Autowired
	private WowUserRepository userRepo;

	@Autowired
	AddressRepository addressRepo;

	@Override
	public List<OrderProjection> getOrders() {
		return orderRepo.findByUser(getUser());
	}

	@Override
	public List<OrderProjection> getAllOrders() {
		return orderRepo.findAllProjectedBy();
	}

	private WowUser getUser() {
		return userRepo.findById(UserUtil.getCurrentUser().getId()).orElse(null);
	}

	@Override
	public OrderProjection getOrderDetail(Long orderId) {
		return orderRepo.getById(orderId);
	}

}