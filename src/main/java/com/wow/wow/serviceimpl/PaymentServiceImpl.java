package com.wow.wow.serviceimpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wow.wow.model.Address;
import com.wow.wow.model.Cart;
import com.wow.wow.model.Orders;
import com.wow.wow.model.PaymentCallback;
import com.wow.wow.model.PaymentDetail;
import com.wow.wow.model.WowUser;
import com.wow.wow.repository.AddressRepository;
import com.wow.wow.repository.CartRepository;
import com.wow.wow.repository.OrdersRepository;
import com.wow.wow.repository.WowUserRepository;
import com.wow.wow.service.PaymentService;
import com.wow.wow.utility.PaymentUtil;
import com.wow.wow.utility.UserUtil;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private OrdersRepository orderRepo;

	@Autowired
	private WowUserRepository userRepo;

	@Autowired
	private CartRepository cartRepo;

	@Autowired
	AddressRepository addressRepo;

	@Override
	public PaymentDetail proceedPayment(PaymentDetail paymentDetail) {
		paymentDetail = PaymentUtil.populatePaymentDetail(paymentDetail);
		savePaymentDetail(paymentDetail);
		return paymentDetail;
	}

	@Override
	public String payuCallback(PaymentCallback paymentResponse) {
		String msg = "Transaction failed.";
		Orders payment = orderRepo.findByTransactionId(paymentResponse.getTxnid());
		if (payment != null) {
			// TODO validate the hash
			String paymentStatus = null;
			if (paymentResponse.getStatus().equals("failure")) {
				paymentStatus = "Failed";
			} else if (paymentResponse.getStatus().equals("success")) {
				paymentStatus = "Success";
				msg = "Transaction success";
			}
			payment.setPaymentStatus(paymentStatus);
			payment.setMihpayId(paymentResponse.getMihpayid());
			payment.setPaymentMode(paymentResponse.getMode());
			orderRepo.save(payment);
		}
		return msg;
	}

	private void savePaymentDetail(PaymentDetail paymentDetail) {
		Orders order = new Orders();
		order.setAmount(Double.parseDouble(paymentDetail.getAmount()));
		order.setPaymentDate(new Date());
		order.setPaymentStatus("Pending");
		order.setProductInfo(paymentDetail.getProductInfo());
		order.setTransactionId(paymentDetail.getTxnId());
		order.setUser(getUser());
		order.setCart(getCart(paymentDetail.getCart()));
		order.setAddress(getAddress(paymentDetail.getAddress()));
		order.setStatus("New");
		orderRepo.save(order);
	}

	private WowUser getUser() {
		return userRepo.findById(UserUtil.getCurrentUser().getId()).orElse(null);
	}

	private Cart getCart(Long cartId) {
		return cartRepo.findById(cartId).orElse(null);
	}

	private Address getAddress(Long addressId) {
		return addressRepo.findById(addressId).orElse(null);
	}

}