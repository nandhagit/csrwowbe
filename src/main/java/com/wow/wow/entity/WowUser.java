package com.wow.wow.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "WOWUSER")
public class WowUser {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	@SequenceGenerator(initialValue = 10, name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
	private Long id;

	@Column(name = "USERNAME", length = 50, unique = true)
	@NotNull
	@Size(min = 4, max = 50)
	private String username;

	@Column(name = "PASSWORD", length = 100)
	@NotNull
	@Size(min = 4, max = 100)
	private String signinpassword;

	@Column(name = "FIRSTNAME", length = 50)
	@NotNull
	@Size(min = 4, max = 50)
	private String firstname;

	@Column(name = "LASTNAME", length = 50)
	@NotNull
	@Size(min = 4, max = 50)
	private String lastname;

	@Column(name = "EMAIL", length = 50, unique = true)
	@NotNull
	@Size(min = 4, max = 50)
	private String email;

	@Column(name = "ENABLED")
	@NotNull
	private Boolean enabled;

	@Column(name = "LASTPASSWORDRESETDATE")
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date lastPasswordResetDate;

	@Column(name = "PHONENUMBER", unique = true)
	@NotNull
	private Long phone;

	@Column(name = "DATEOFBIRTH")
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date dob;

	@ManyToMany(fetch = FetchType.EAGER)
	@JsonIgnoreProperties("users")
	@JoinTable(name = "USER_AUTHORITY", joinColumns = {
			@JoinColumn(name = "USER_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID") })
	private List<Authority> authorities;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CART")
	private Cart cart;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	public Date getLastPasswordResetDate() {
		return lastPasswordResetDate;
	}

	public void setLastPasswordResetDate(Date lastPasswordResetDate) {
		this.lastPasswordResetDate = lastPasswordResetDate;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getSigninpassword() {
		return signinpassword;
	}

	public void setSigninpassword(String signinpassword) {
		this.signinpassword = signinpassword;
	}
	
	

}
