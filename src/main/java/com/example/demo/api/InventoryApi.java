package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IProductService;

@RestController
@RequestMapping("/iv")
public class InventoryApi {

	@Autowired
	private IProductService productService;
	
	@GetMapping
	public ResponseEntity<String> getRemoteData(){
		
		productService.getRemoteData();
		
		return ResponseEntity.ok("OK");
	}
	
}
