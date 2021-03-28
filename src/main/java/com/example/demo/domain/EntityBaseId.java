package com.example.demo.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EntityBaseId {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;
	
}
