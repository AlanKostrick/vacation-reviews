package com.example.vacation_reviews;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {
	
	@Resource
	ReviewRepository reviewRepo;

	@Resource
	TagRepository tagRepo;
	
	@Resource 
	CategoryRepository categoryRepo;
	
	@RequestMapping("/reviews")
	public String getAllRentals(Model model) {
		model.addAttribute("reviewsAsCollection", reviewRepo.findAll());
		return "reviews";
	}

	@RequestMapping("/review")
	public String getOneRental(@RequestParam(value="id") Long id, Model model) {
		model.addAttribute("review", reviewRepo.findOne(id));
		return "onereview";
	}
	
	@RequestMapping("/home")
	public String fetchReviews(Model model) {
		model.addAttribute("reviewsAsCollection", reviewRepo.findAll());
		return "reviews";
	}
	
	@RequestMapping("/onereview")
    public String fetchOne(@RequestParam(value="id") Long id, Model model) {
         model.addAttribute("onereview", reviewRepo.findOne(id));
 		model.addAttribute("tags", tagRepo.findAll());

         
         return "onereview";
     }
	
	@RequestMapping("/categories")
	public String getAllCategories(Model model) {
		model.addAttribute("categoriesAsCollection", categoryRepo.findAll());
		return "categories";
	}
	
	

	@RequestMapping("/category")
	public String getOneCategory(@RequestParam(value="id") Long categoryId, Model model) {
		model.addAttribute("oneCategory", categoryRepo.findOne(categoryId));
		return "category";
	}
	
	
	@RequestMapping("/alltags")
	public String showAllTags(Model model) {
		model.addAttribute("tags", tagRepo.findAll());
		return "tags";
		
	}
	
	@RequestMapping("/tag")
	public String fetchTagDetail(@RequestParam("id") Long id, Model model) {
		Tag selectedTag = tagRepo.findOne(id);
		model.addAttribute(selectedTag);
		return "tag";
	}
	
	@RequestMapping("onereview/tags/delete")
	public String deleteOneTag(@RequestParam long tagId, @RequestParam long reviewId) {
		Tag toDelete = tagRepo.findOne(tagId);
		Review review = reviewRepo.findOne(reviewId);
		review.remove(toDelete);
		reviewRepo.save(review);
		return "redirect:/onereview?id=" + reviewId;
	}
	
	@RequestMapping("/tags/delete")
	public String deleteTag(@RequestParam long tagId) {
		Tag toDelete = tagRepo.findOne(tagId);
 		for(Review review: toDelete.getReviewsWithTag()) {
 			review.remove(toDelete);
 			reviewRepo.save(review);
 		}
		
		tagRepo.delete(toDelete);
		return "redirect:/alltags";
	}
	
		
		@RequestMapping("/createTag")
		public String createTag(@RequestParam(value="id") Long id, String name) {
			Tag tag = new Tag(name);
			tagRepo.save(tag); 
			Review review = reviewRepo.findOne(id);
			review.add(tag);
			reviewRepo.save(review);
			return "redirect:/onereview?id=" + id;
		}

}
