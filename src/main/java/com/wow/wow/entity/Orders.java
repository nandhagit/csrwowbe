package com.wow.wow.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Orders {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
	@SequenceGenerator(name = "order_seq", sequenceName = "order_seq", allocationSize = 1)
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

	@Column(name = "PAYMENT_ID")
	private String paymentId;

	@Column(name = "PAYMENT_MODE")
	private String paymentMode;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CART_ID")
	private @NotNull Cart cart;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID")
	private @NotNull Address address;

	@Column(name = "ORDER_STATUS")
	private @NotNull String orderStatus;

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

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	

}