package com.inventory.system.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.system.expections.ProductIdRequiredException;
import com.inventory.system.model.Product;
import com.inventory.system.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping("/create")
	public ResponseEntity<?> createProduct(@RequestBody Product product){
		service.createProduct(product);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> list=service.getAllProducts();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") Long id){
		Product product=service.getProduct(id);
		return new ResponseEntity<>(product,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product){
		Product updatedProduct=service.updateProduct(product);
		return new ResponseEntity<Product>(updatedProduct,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteProduct(@RequestBody Product product){
		if(Objects.isNull(product.getProductId())) {
			throw new ProductIdRequiredException("product id required");
		}else {
			service.deleteProduct(product);
			return new ResponseEntity<>(product,HttpStatus.ACCEPTED);
		}
	}
	
	
}
