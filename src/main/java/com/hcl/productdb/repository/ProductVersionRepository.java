package com.hcl.productdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.productdb.entity.Product;
import com.hcl.productdb.entity.ProductVersion;

public interface ProductVersionRepository extends JpaRepository<ProductVersion, Long>{

	public ProductVersion findDistinctByProductVersionAndProductIdAndProductDescriptionAndProductName(float version,Product id,String description,String productName);
}
