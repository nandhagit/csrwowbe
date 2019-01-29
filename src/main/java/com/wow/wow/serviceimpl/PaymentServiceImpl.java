package com.wow.wow.serviceimpl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.wow.wow.model.Address;
import com.wow.wow.model.Cart;
import com.wow.wow.model.Orders;
import com.wow.wow.model.WowUser;
import com.wow.wow.repository.AddressRepository;
import com.wow.wow.repository.CartRepository;
import com.wow.wow.repository.OrdersRepository;
import com.wow.wow.repository.WowUserRepository;
import com.wow.wow.service.PaymentService;
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

	/*@Override
	public PaymentDetail proceedPayment(PaymentDetail paymentDetail) {
		paymentDetail = PaymentUtil.populatePaymentDetail(paymentDetail);
		savePaymentDetail(paymentDetail);
		return paymentDetail;
	}*/

	/*@Override
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
	}*/

	public Map<String, String> savePaymentDetail(String payid) {
		
		RazorpayClient razorpay = null;
		Map<String, String> orderDetails = new HashMap<>();
		try {
			razorpay = new RazorpayClient("rzp_test_yJuvKJouFP0Z3t", "IUvCVKivSGTyui5bszp1MC9T");
		} catch (RazorpayException e1) {
			e1.printStackTrace();
		}
		try {
			JSONObject captureRequest = new JSONObject();
			captureRequest.put("amount", 2000); // Amount should be in paise
			Payment payment = razorpay.Payments.capture(payid, captureRequest);
			System.out.println(payment);
			JSONObject notes = payment.get("notes");
			Orders order = new Orders();
			order.setAmount(((Integer)payment.get("amount")).doubleValue());
			order.setPaymentDate(new Date());
			order.setPaymentStatus("Pending");
			order.setProductInfo(payment.get("description"));
			order.setTransactionId(payment.get("id"));
			order.setUser(getUser());
			order.setCart(getCart(Long.valueOf((String) notes.get("cart"))));
			order.setAddress(getAddress(Long.valueOf((String) notes.get("address"))));
			order.setStatus("New");
			orderRepo.save(order);
			orderDetails.put("orderid", order.getId().toString());
		} catch (RazorpayException e) {
			System.out.println(e.getMessage());
		}
		return orderDetails;
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

	/*@Override
	public String razorCallback(PaymentDetail paymentResponse) {
		// TODO Auto-generated method stub
		return null;
	}*/

}