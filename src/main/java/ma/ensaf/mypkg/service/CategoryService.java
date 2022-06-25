package ma.ensaf.mypkg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.ensaf.mypkg.Exception.CustomException;
import ma.ensaf.mypkg.models.Cart;
import ma.ensaf.mypkg.models.Category;
import ma.ensaf.mypkg.models.User;
import ma.ensaf.mypkg.repo.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
	CategoryRepo categoryRepo;
	
	public void createCategory(Category category) {
		
		categoryRepo.save(category);
	}
	
public List<Category> listCategory() {
		
		return categoryRepo.findAll();
	}

public void editCategory(int categoryId,Category updateCategory)
{
	Category category= categoryRepo.getById(categoryId);
	category.setCategoryName(updateCategory.getCategoryName());
	category.setDescription(updateCategory.getDescription());
	category.setImageUrl(updateCategory.getImageUrl());
	categoryRepo.save(category);
}

public boolean findById(int categoryId) {
    return categoryRepo.findById(categoryId).isPresent();
}



}
