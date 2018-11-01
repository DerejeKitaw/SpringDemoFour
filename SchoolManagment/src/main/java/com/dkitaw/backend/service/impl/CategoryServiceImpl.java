package com.dkitaw.backend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dkitaw.backend.exception.CategoryServiceException;
import com.dkitaw.backend.io.entity.CategoryEntity;
import com.dkitaw.backend.io.entity.repository.CategoryRepository;
import com.dkitaw.backend.service.CategoryService;
import com.dkitaw.backend.shared.Utils;
import com.dkitaw.backend.shared.dto.CategoryDTO;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	CategoryRepository categoryRepository;
	Utils utils;
	public CategoryServiceImpl(CategoryRepository categoryRepository, Utils utils) {
		this.categoryRepository = categoryRepository;
		this.utils= utils;
	}

	@Override
	public List<CategoryDTO> getCategories(int page, int limit) {
		
		List<CategoryDTO> returnValue = new ArrayList<>();

	    if (page > 0)
	      page = page - 1; // avoid page=0

	    Pageable pageableRequest = PageRequest.of(page, limit);

	    Page<CategoryEntity> categoryPage = categoryRepository.findAll(pageableRequest);
	    List<CategoryEntity> categories = categoryPage.getContent();

	    for (CategoryEntity categoryEntity : categories) {
	    	CategoryDTO categoryDTO = new CategoryDTO();
	      BeanUtils.copyProperties(categoryEntity, categoryDTO);
	      returnValue.add(categoryDTO);
	    }
	    return returnValue;
	}

	@Override
	public CategoryDTO createCategory(CategoryDTO category) {
		
		if(categoryRepository.findByName(category.getName())!= null) throw new RuntimeException("Category name exists");
		
		ModelMapper modelMapper = new ModelMapper();
		CategoryEntity categoryEntity = modelMapper.map(category, CategoryEntity.class);

	    String publicCategoryId = utils.generateCategoryId(30);
	    categoryEntity.setCategoryId(publicCategoryId);

	    CategoryEntity storedCategoryDetails = categoryRepository.save(categoryEntity);

	    CategoryDTO returnValue = modelMapper.map(storedCategoryDetails, CategoryDTO.class);
	    return returnValue;
	}

	@Override
	public CategoryDTO getCategoryByCategoryId(String categoryId) {
		CategoryDTO returnValue = new CategoryDTO();
		
		CategoryEntity categoryEntity = categoryRepository.findByCategoryId(categoryId);
	    if (categoryEntity == null)
	      throw new CategoryServiceException("Category with categoryId:  " +  categoryId + " not found");
	    
	    BeanUtils.copyProperties(categoryEntity, returnValue);

	    return returnValue;
	}


}
