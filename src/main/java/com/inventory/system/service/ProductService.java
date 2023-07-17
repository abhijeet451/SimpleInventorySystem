package com.inventory.system.service;

import java.util.List;

import com.inventory.system.model.Product;

public interface ProductService {

	List<Product> getAllProducts();

	void createProduct(Product product);

	Product getProduct(Long id);

	Product updateProduct(Product product);

	void deleteProduct(Product product);

}
