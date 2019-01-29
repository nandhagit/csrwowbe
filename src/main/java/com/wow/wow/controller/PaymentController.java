package com.wow.wow.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wow.wow.service.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	/*@PostMapping(path = "/payment-details")
	public @ResponseBody PaymentDetail proceedPayment(@RequestBody PaymentDetail paymentDetail) {
		return paymentService.proceedPayment(paymentDetail);
	}*/

	/*@RequestMapping(path = "/payment-response", method = RequestMethod.POST)
	public void payuCallback(@RequestParam String mihpayid, @RequestParam String status, @RequestParam PaymentMode mode,
			@RequestParam String txnid, @RequestParam String hash) {
		PaymentCallback paymentCallback = new PaymentCallback();
		paymentCallback.setMihpayid(mihpayid);
		paymentCallback.setTxnid(txnid);
		paymentCallback.setMode(mode.toString());
		paymentCallback.setHash(hash);
		paymentCallback.setStatus(status);
		paymentService.payuCallback(paymentCallback);
	}*/

	@GetMapping(path = "/capture-payment")
	public Map<String, String> razorPayCallback(@RequestParam String payid) throws Exception {
		Map<String, String> exm = paymentService.savePaymentDetail(payid);
		return exm;
	}
}