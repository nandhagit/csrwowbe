package com.wow.wow.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Orders {

	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column(name = "USER_ID")
	private Long wowUser;
	@Column(name = "PRODUCT_INFO")
	private String productInfo;
	@Column
	private Double amount;
	@Column(name = "PAYMENT_STATUS")
	private String paymentStatus;
	@Column(name = "PAYMENT_DATE")
	private Date paymentDate;
	@Column(name = "TRANSACTION_ID")
	private String transactionId;
	@Column(name = "MIH_PAY_ID")
	private String mihpayId;
	@Column(name = "PAYMENT_MODE")
	private String paymentMode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUser() {
		return wowUser;
	}

	public void setUser(Long user) {
		this.wowUser = user;
	}

	public String getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getMihpayId() {
		return mihpayId;
	}

	public void setMihpayId(String mihpayId) {
		this.mihpayId = mihpayId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

}