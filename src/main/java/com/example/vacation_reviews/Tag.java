package com.example.vacation_reviews;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	
	@ManyToMany(mappedBy="tags")
	private Set<Review> reviewsWithTag;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<Review> getReviewsWithTag() {
		return reviewsWithTag;
	}
	
	private Tag() {}
	
	public Tag(String name) {
		this.name = name;
	}

}