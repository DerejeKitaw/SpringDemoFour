package com.dkitaw.backend.ui.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dkitaw.backend.service.CategoryService;
import com.dkitaw.backend.shared.dto.CategoryDTO;
import com.dkitaw.backend.ui.model.request.CategoryDetailRequestModel;
import com.dkitaw.backend.ui.model.response.CategoryRest;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

@RestController 
@RequestMapping("category")
public class CategoryController {
	
	CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService=categoryService;
	}
	
	@GetMapping(path = "/{categoryId}")
	  public CategoryRest getCategory(@PathVariable String categoryId) {

	    CategoryRest returnValue = new CategoryRest();

	    CategoryDTO categoryDTO = categoryService.getCategoryByCategoryId(categoryId);

	    ModelMapper modelMapper = new ModelMapper();
	    returnValue = modelMapper.map(categoryDTO, CategoryRest.class);

	    return returnValue;
	  }
	
	@GetMapping(path="all")
	public List<CategoryRest> getCategories(@RequestParam(value = "page", defaultValue = "0") int page,
		      @RequestParam(value = "limit", defaultValue = "25") int limit) {
		List<CategoryRest> returnValue = new ArrayList<>();
		List<CategoryDTO>categoryies=categoryService.getCategories(page, limit);
		Type listType = new TypeToken<List<CategoryRest>>() {
	    }.getType();
	    returnValue = new ModelMapper().map(categoryies, listType);

	    return returnValue;
	}
	@PostMapping(path = "/create")
	  public CategoryRest createCategory(@RequestBody CategoryDetailRequestModel categoryDetails) throws Exception{

	    CategoryRest returnValue = new CategoryRest();

	    ModelMapper modelMapper = new ModelMapper();
	    CategoryDTO categoryDTO = modelMapper.map(categoryDetails, CategoryDTO.class);

	    CategoryDTO createCategory = categoryService.createCategory(categoryDTO);
	    returnValue = modelMapper.map(createCategory, CategoryRest.class);
	    return returnValue;
	  }

}
