package com.wow.wow.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wow.wow.dto.OrderDTO;
import com.wow.wow.entity.WowUser;
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

	ModelMapper mapper = new ModelMapper();
	
	UserUtil userUtil = new UserUtil();

	@Override
	public List<OrderDTO> getOrders() {
		return orderRepo.findByUser(userUtil.getUser()).stream().map(order -> mapper.map(order, OrderDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<OrderDTO> getAllOrders() {
		return orderRepo.findAll().stream().map(order -> mapper.map(order, OrderDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public OrderDTO getOrderDetail(Long orderId) {
		return mapper.map(orderRepo.findById(orderId), OrderDTO.class);
	}

}