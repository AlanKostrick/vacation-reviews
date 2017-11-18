package com.example.vacation_reviews;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ReviewPopulator implements CommandLineRunner {

	@Resource
	private ReviewRepository reviewRepo;
	
	@Resource
	private CategoryRepository categoryRepo;
	
	@Resource
	private TagRepository tagRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Tag rest = new Tag("Rest");
		tagRepo.save(rest);
		Tag adventure = new Tag("Adventure");
		tagRepo.save(adventure);
		
		Category beach = new Category("Beach", "Sit by the water and enjoy");
		Category mountain = new Category("Mountain", "Take in the views");
		categoryRepo.save(beach);
		categoryRepo.save(mountain);
		
	
		Review property1 = new Review (1, "Aloha", "/images/hawaii.jpg", beach,"This vacation home will have you forgetting the mainland and wish for eternal island life.", "Florida", rest);
		reviewRepo.save(property1);
		Review property2 = new Review (2, "Flo Rida", "/images/palmsprings.jpg", beach,"This vacation home will have you craving for more of the sunshine state.", "Palm Springs", rest);
		reviewRepo.save(property2);
		Review property3 = new Review (3, "Riding High", "/images/tahoe.jpg", mountain,"This vacation home will make you one with nature.", "Tahoe", adventure);
		reviewRepo.save(property3);
		
		
	


	}

}