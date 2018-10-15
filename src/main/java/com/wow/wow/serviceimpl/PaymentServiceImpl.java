package com.wow.wow.serviceimpl;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wow.wow.model.Orders;
import com.wow.wow.model.PaymentCallback;
import com.wow.wow.model.PaymentDetail;
import com.wow.wow.model.PaymentStatus;
import com.wow.wow.repository.OrdersRepository;
import com.wow.wow.service.PaymentService;
import com.wow.wow.utility.PaymentUtil;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private OrdersRepository paymentRepository;

    @Override
    public PaymentDetail proceedPayment(PaymentDetail paymentDetail) {
        paymentDetail = PaymentUtil.populatePaymentDetail(paymentDetail);
        savePaymentDetail(paymentDetail);
        return paymentDetail;
    }

    @Override
    public String payuCallback(PaymentCallback paymentResponse) {
        String msg = "Transaction failed.";
        Orders payment = paymentRepository.findByTransactionId(paymentResponse.getTxnid());
        if(payment != null) {
            //TODO validate the hash
            PaymentStatus paymentStatus = null;
            if(paymentResponse.getStatus().equals("failure")){
                paymentStatus = PaymentStatus.Failed;
            }else if(paymentResponse.getStatus().equals("success")) {
                paymentStatus = PaymentStatus.Success;
                msg = "Transaction success";
            }
            payment.setPaymentStatus(paymentStatus);
            payment.setMihpayId(paymentResponse.getMihpayid());
            payment.setPaymentMode(paymentResponse.getMode());
            paymentRepository.save(payment);
        }
        return msg;
    }

    private void savePaymentDetail(PaymentDetail paymentDetail) {
        Orders payment = new Orders();
        payment.setAmount(Double.parseDouble(paymentDetail.getAmount()));
        payment.setEmail(paymentDetail.getEmail());
        payment.setName(paymentDetail.getName());
        payment.setPaymentDate(new Date());
        payment.setPaymentStatus(PaymentStatus.Pending);
        payment.setPhone(paymentDetail.getPhone());
        payment.setProductInfo(paymentDetail.getProductInfo());
        payment.setTransactionId(paymentDetail.getTxnId());
        paymentRepository.save(payment);
    }

}