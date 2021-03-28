package com.example.demo.service;

import java.util.Collection;
import java.util.List;

import com.example.demo.domain.inventory.Product;

public interface IProductService {

	Product save(Product product);
	
	void saveAll(Collection<Product> products);
	
	List<Product> getProducts();
	
	List<Product> getRemoteData();
	
}
