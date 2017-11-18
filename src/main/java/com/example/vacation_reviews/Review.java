package com.example.vacation_reviews;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Review {
	@Id
	@GeneratedValue
	private long id;
	
	private String title;
	private String image;
	
	@ManyToOne
	private Category category;
	
	@ManyToMany
	private Set<Tag> tags;
	
	@Lob
	private String content;
	
	private String location;
	
	protected Review() {
		
	}
	

	public Review(long id, String title, String image, Category category, String content, String location, Tag...tags) 
	{
		this.id = id;
		this.title = title;
		this.image = image;
		this.category = category;
		this.content = content;
		this.location = location;
		this.tags = new HashSet<>(Arrays.asList(tags));
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public Set<Tag> getTags() {
		return tags;
	}
	
	public void remove(Tag tag) {
		tags.remove(tag);
	}
	public void add(Tag tag) {
		tags.add(tag);
	}
	

}
