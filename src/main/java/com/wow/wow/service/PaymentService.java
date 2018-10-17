package com.wow.wow.service;
import java.util.List;

import com.wow.wow.model.Orders;
import com.wow.wow.model.PaymentCallback;
import com.wow.wow.model.PaymentDetail;

public interface PaymentService {

    public PaymentDetail proceedPayment(PaymentDetail paymentDetail) ;

    public String payuCallback(PaymentCallback paymentResponse) ;
    
    public List<Orders> getOrders();
    
    public List<Orders> getAllOrders();

}