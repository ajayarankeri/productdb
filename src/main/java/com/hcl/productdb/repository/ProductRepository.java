package com.hcl.productdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.productdb.entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	

}
