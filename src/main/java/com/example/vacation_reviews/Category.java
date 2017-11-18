package com.example.vacation_reviews;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private Long categoryId;

	private String name;
	private String description;

	@OneToMany(mappedBy = "category")
	private Set<Review> reviews;

	public Long getCategoryId() {
		return categoryId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Set<Review> getReviews() {
		return reviews;
	}
	
	//Required by JPA
	private Category() {
	}

	public Category(String name, String description) {
		this.name = name;
		this.description = description;
	}

}