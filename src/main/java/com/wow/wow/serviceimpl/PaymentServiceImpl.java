package com.wow.wow.serviceimpl;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.wow.wow.model.OrderDTO;
import com.wow.wow.model.Orders;
import com.wow.wow.model.PaymentCallback;
import com.wow.wow.model.PaymentDetail;
import com.wow.wow.model.PaymentStatus;
import com.wow.wow.model.WowUser;
import com.wow.wow.repository.OrdersRepository;
import com.wow.wow.repository.WowUserRepository;
import com.wow.wow.security.JwtUser;
import com.wow.wow.service.PaymentService;
import com.wow.wow.service.UserService;
import com.wow.wow.utility.PaymentUtil;
import com.wow.wow.utility.UserUtil;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private OrdersRepository paymentRepository;
    
    @Autowired
    WowUserRepository userRepo;
    
    @Autowired
    OrdersRepository orderRepo;

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
            String paymentStatus = null;
            if(paymentResponse.getStatus().equals("failure")){
                paymentStatus = "Failed";
            }else if(paymentResponse.getStatus().equals("success")) {
                paymentStatus = "Success";
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
        payment.setPaymentDate(new Date());
        payment.setPaymentStatus("Pending");
        payment.setProductInfo(paymentDetail.getProductInfo());
        payment.setTransactionId(paymentDetail.getTxnId());
        payment.setUser(UserUtil.getCurrentUser().getId());
        paymentRepository.save(payment);
    }
    
	@Override
	public List<Orders> getOrders() {
		return orderRepo.findByWowUser(UserUtil.getCurrentUser().getId());
	}

	@Override
	public List<Orders> getAllOrders() {
		return orderRepo.findAll();
	}
    
    


}