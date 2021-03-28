package com.example.demo.domain.inventory;

import javax.persistence.Entity;

import com.example.demo.domain.EntityBaseId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Product extends EntityBaseId{

	private String customsTariffNumber;
	
	private String shop;
	
	private boolean hasSerialNumber;
	
	private String supplierNumber;
	
	private double salesPrice;
	
	private boolean ignorePicking;
	
	private String description;
	
	private double purchasePrice;
	
	private boolean isActive;
	
	private String factoryNumber;
	
	private double widthShipping;
	
	private String ean;
	
	private String sku;
	
	private String barcode;
	
	private int height;
	
	private long productId;
	
	private String producerName;
	
	private long externalId;
	
	private double heightShipping;
	
	private double depthShipping;
	
	private double volume;
	
	private double grossWeight;
	
	private double netWeight;
	
	private boolean isProductPart;
	
	private double depth;
	
	private double volumeShipping;
	
	private String productGroup;
	
	private String name;
	
	private double width;
	
	private String originCountry;
	
	private String externalArticleNumber;
	
}
