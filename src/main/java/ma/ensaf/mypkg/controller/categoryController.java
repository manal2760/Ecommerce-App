package ma.ensaf.mypkg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.ensaf.mypkg.common.ApiResponse;
import ma.ensaf.mypkg.models.Category;
import ma.ensaf.mypkg.service.CategoryService;

@RestController
@RequestMapping("category")
public class categoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createCategory(@RequestBody Category category)
	{
		categoryService.createCategory(category);
		  return new ResponseEntity<>(new ApiResponse(true, "a new category created"), HttpStatus.CREATED);
		
	}
	
	@GetMapping("/list")
	public List<Category> listCategory()
	{
		return categoryService.listCategory();
		
	}
	
	@PostMapping("/update/{categoryId}")
	public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoryId") int categoryId,@RequestBody Category category)
	{
		if (!categoryService.findById(categoryId)) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category does not exist"), HttpStatus.NOT_FOUND);
        }
		categoryService.editCategory(categoryId, category);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "category has been updated"), HttpStatus.OK);
	}
	
	

}
