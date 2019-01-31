/*package com.wow.wow.dto;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import com.wow.wow.model.Rating;

public interface ProductProjection {

	public String getName() {

	public String getDescription() {

	public Long getId() {

	public String getCode() {

		public double getPrice() {

	public String getSize() {

	public String getCategory() {

	public String getSubType() {

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
*/