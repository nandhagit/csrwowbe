package com.wow.wow;
import com.wow.wow.model.PaymentCallback;
import com.wow.wow.model.PaymentDetail;

public interface PaymentService {

    public PaymentDetail proceedPayment(PaymentDetail paymentDetail) ;

    public String payuCallback(PaymentCallback paymentResponse) ;

}