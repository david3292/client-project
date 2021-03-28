package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.EntityBaseId;

public interface RepositoryBaseId <T extends EntityBaseId> extends CrudRepository<T, Long>{

}
