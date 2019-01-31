package com.wow.wow.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
	@SequenceGenerator(initialValue = 10, name = "product_seq", sequenceName = "product_seq", allocationSize = 1)
	@Column
	private Long id;

	@Column
	private @NotNull String name;

	@Column
	private String description;

	@Column(unique = true)
	private @NotNull String code;

	@Column
	private @NotNull double price;

	@Column
	private @NotNull String size;

	@Column
	private @NotNull String category;

	@Column(name = "SUBTYPE")
	private @NotNull String subType;

	@Column(name = "IMAGE_URL")
	private @NotNull String imageURL;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "PRODUCT_ID")
	private Set<Rating> ratings;

	@Column(name = "CREATED_DATE")
	private @NotNull Date createdDate;

	@Column(name = "LAST_MODIFIED_DATE")
	private @NotNull Date lastModifiedDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public Set<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", code=" + code + ", price="
				+ price + ", size=" + size + ", category=" + category + ", subType=" + subType + ", imageURL="
				+ imageURL + ", ratings=" + ratings + ", createdDate=" + createdDate + ", lastModifiedDate="
				+ lastModifiedDate + "]";
	}

}
