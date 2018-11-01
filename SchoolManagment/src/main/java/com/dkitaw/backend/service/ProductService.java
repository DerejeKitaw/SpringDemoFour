package com.dkitaw.backend.service;

import java.util.List;

import com.dkitaw.backend.shared.dto.ProductDTO;

public interface ProductService {
	ProductDTO get(int productId);
	List<ProductDTO> list();	
	boolean add(ProductDTO product);
	boolean update(ProductDTO product);
	boolean delete(ProductDTO product);

	List<ProductDTO> getProductsByParam(String param, int count);	
	
	
	// business methods
	List<ProductDTO> listActiveProducts();	
	List<ProductDTO> listActiveProductsByCategory(int categoryId);
	List<ProductDTO> getLatestActiveProducts(int count);
}
