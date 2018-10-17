package com.wow.wow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wow.wow.model.Orders;
import com.wow.wow.model.PaymentCallback;
import com.wow.wow.model.PaymentDetail;
import com.wow.wow.model.PaymentMode;
import com.wow.wow.repository.OrdersRepository;
import com.wow.wow.service.PaymentService;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins="http://localhost:4200")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    
    @Autowired
    private OrdersRepository orderRepo;

    @PostMapping(path = "/payment-details")
    public @ResponseBody PaymentDetail proceedPayment(@RequestBody PaymentDetail paymentDetail){
        return paymentService.proceedPayment(paymentDetail);
    }

    @RequestMapping(path = "/payment-response", method = RequestMethod.POST)
    public void payuCallback(@RequestParam String mihpayid, @RequestParam String status, @RequestParam PaymentMode mode, @RequestParam String txnid, @RequestParam String hash){
        PaymentCallback paymentCallback = new PaymentCallback();
        paymentCallback.setMihpayid(mihpayid);
        paymentCallback.setTxnid(txnid);
        paymentCallback.setMode(mode.toString());
        paymentCallback.setHash(hash);
        paymentCallback.setStatus(status);
        paymentService.payuCallback(paymentCallback);
    }
    @RequestMapping(path = "/orders", method = RequestMethod.GET)
    public List<Orders> getUserOrders(){
        return paymentService.getOrders();
    }
    
    @RequestMapping(path = "/admin/orders", method = RequestMethod.GET)
    public List<Orders> getAllOrders(){
        return paymentService.getAllOrders();
    }
}