package com.wow.wow.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Orders {

	@Id
	@GeneratedValue
	@Column
	private Long id;

	@JoinColumn(name = "USER_ID")
	@ManyToOne(cascade = { CascadeType.ALL, CascadeType.MERGE })
	private WowUser user;

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

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cart")
	private @NotNull Cart cart;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address")
	private @NotNull Address address;

	@Column
	private @NotNull String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public WowUser getUser() {
		return user;
	}

	public void setUser(WowUser wowUser) {
		this.user = wowUser;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}