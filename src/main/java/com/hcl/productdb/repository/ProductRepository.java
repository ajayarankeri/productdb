package com.hcl.productdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.productdb.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
