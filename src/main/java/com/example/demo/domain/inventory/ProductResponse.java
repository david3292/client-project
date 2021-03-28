package com.example.demo.domain.inventory;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductResponse {

	@JsonProperty("Success")
	private boolean success;
	
	private List<Product> products;
	
	private int status;	
}
