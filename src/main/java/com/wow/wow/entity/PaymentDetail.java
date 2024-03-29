package com.wow.wow.entity;

public class PaymentDetail {
	
	private String email;
	private String name;
	private String phone;
	private String productInfo;
	private String amount;
	private String txnId;
	private String hash;
	private String sUrl;
	private String fUrl;
	private String key;
	private Long cart;
	private Long address;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getTxnId() {
		return txnId;
	}

	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getsUrl() {
		return sUrl;
	}

	public void setsUrl(String sUrl) {
		this.sUrl = sUrl;
	}

	public String getfUrl() {
		return fUrl;
	}

	public void setfUrl(String fUrl) {
		this.fUrl = fUrl;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Long getCart() {
		return cart;
	}

	public void setCart(Long cart) {
		this.cart = cart;
	}

	public Long getAddress() {
		return address;
	}

	public void setAddress(Long address) {
		this.address = address;
	}

}