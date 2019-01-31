package com.wow.wow.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rating_seq")
	@SequenceGenerator(initialValue = 10, name = "rating_seq", sequenceName = "rating_seq", allocationSize = 1)
	@Column
	private Long id;

	@Column
	private int rating;

	@Column
	private String title;

	@Column
	private String review;

	@Column(name = "USER_ID")
	private @NotNull Long user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name = "product_id")
	private @NotNull Product product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", rating=" + rating + ", title=" + title + ", review=" + review + ", user=" + user
				+ ", product=" + product + ", getId()=" + getId() + ", getRating()=" + getRating() + ", getReview()="
				+ getReview() + ", getUser()=" + getUser() + ", getTitle()=" + getTitle() + ", getProduct()="
				+ getProduct() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
