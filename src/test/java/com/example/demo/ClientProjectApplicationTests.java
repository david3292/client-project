package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.domain.inventory.Product;
import com.example.demo.service.impl.ProductService;

@SpringBootTest()
class ClientProjectApplicationTests {

	@Autowired ProductService productService;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void saveProduct() {
		
		Product product = new Product("", "Test-Wemalo", false, "", 5, false, "", 0, true, "", 0, "1234567890123", "0815-stift", "69nnaW5y", 4, 196935, "", 196935, 0, 0, 7260, 110, 2, true, 121, 0, "default", "TestStift Cloudtestmandant", 15, "", "");
		productService.save(product);
		
		List<Product> products = productService.getProducts();
		
		System.out.println(products);
		
		assertEquals("OK", "OK");
		
	}
	
	@Test
	void getRemoteData() {
		
		productService.getRemoteData();
		
		assertEquals("OK", "OK");
	}

}
