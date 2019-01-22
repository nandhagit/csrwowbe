package com.wow.wow.dto;

import java.util.Date;

public interface OrderProjection {

	public Long getId();

	public Double getAmount();

	public String getPaymentStatus();

	public Date getPaymentDate();

	public String getMihpayId();

	public String getTransactionId();

	public String getPaymentMode();

	public UserProjection getUser();

	public CartProjection getCart();

	public AddressProjection getAddress();

	public String getStatus();

}
