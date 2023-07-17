package com.inventory.system.serviceimpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.system.expections.ProductIdRequiredException;
import com.inventory.system.expections.ProductNotFoundException;
import com.inventory.system.model.Product;
import com.inventory.system.repository.ProductRepository;
import com.inventory.system.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository repository;

	@Override
	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	@Override
	public void createProduct(Product product) {
		repository.save(product);
		
	}

	@Override
	public Product getProduct(Long id) {
		
		if(Objects.isNull(id)) {
			throw new ProductIdRequiredException("product id is required");
		}
		Optional<Product> product= repository.findById(id);
		if(product.isPresent()) {
			return product.get();
		}
		
		throw new ProductNotFoundException("requested product is not avaialble");
	}

	@Override
	public Product updateProduct(Product product) {
		getProduct(product.getProductId());
		Product updated= repository.save(product);
		return updated;
	}

	@Override
	public void deleteProduct(Product product) {
		getProduct(product.getProductId());
		repository.delete(product);
	}

}
