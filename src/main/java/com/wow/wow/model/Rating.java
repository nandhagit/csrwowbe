package com.wow.wow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	private String review;
	
	@Column(name="USER_ID")
	private @NotNull Long user;

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

}
