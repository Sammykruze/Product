package com.product.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.product.model.ProductModel;


@Repository
public interface ProductRepository extends CrudRepository<ProductModel, Long> {
	
	List<ProductModel> findByProductCategory(String searchParam);
}


