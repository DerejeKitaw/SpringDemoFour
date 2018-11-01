package com.dkitaw.backend.service;

import java.util.List;

import com.dkitaw.backend.shared.dto.CategoryDTO;

public interface CategoryService {
	List<CategoryDTO> getCategories(int page, int limit);

	CategoryDTO createCategory(CategoryDTO category);

	CategoryDTO getCategoryByCategoryId(String CategoryId);
}
