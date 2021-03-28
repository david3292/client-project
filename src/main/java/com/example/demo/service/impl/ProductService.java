package com.example.demo.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.MainProjectInfo;
import com.example.demo.domain.inventory.Product;
import com.example.demo.domain.inventory.ProductResponse;
import com.example.demo.repository.inventory.IProductRepository;
import com.example.demo.service.IProductService;

@Service
public class ProductService implements IProductService{
	
	private static final String PRODUCTS = "/v1/product";
	private static final String PRODUCTS_GET_ALL = "/getAll";
	

	@Autowired
	private IProductRepository productRepository;
	
	@Autowired 
	private SecurityService securityService;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void saveAll(Collection<Product> products) {
		productRepository.saveAll(products);
	}

	@Override
	public List<Product> getProducts() {
		return (List<Product>) productRepository.findAll();
	}
	
	@Override
	public List<Product> getRemoteData(){
		
		String token = securityService.getToken();
		
		HttpHeaders headers = getHeaderHttp(token);
		HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);
		
		final String url = new StringBuilder().append(MainProjectInfo.BASE_URL).append(PRODUCTS).append(PRODUCTS_GET_ALL).toString();
		
		ResponseEntity<ProductResponse> productResponse = restTemplate.exchange(url, HttpMethod.GET, jwtEntity, ProductResponse.class);
		
		System.out.println(productResponse.getBody());
		
		productRepository.saveAll(productResponse.getBody().getProducts());
		
		return null;
	}
	
	private HttpHeaders getHeaderHttp(String token) {		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.add("Authorization", "Bearer ".concat(token));		
		
		return headers;
	}
}
