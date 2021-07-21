package com.wow.wow.service;

import java.util.Map;

public interface PaymentService {

	//public PaymentDetail proceedPayment(PaymentDetail paymentDetail);

	//public String payuCallback(PaymentCallback paymentResponse);
	
	//public String razorCallback(PaymentDetail paymentResponse);
	public Map<String, String> savePaymentDetail(String payid);

}