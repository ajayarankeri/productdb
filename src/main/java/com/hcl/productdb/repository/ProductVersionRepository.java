package com.hcl.productdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.productdb.entity.ProductVersion;

public interface ProductVersionRepository extends JpaRepository<ProductVersion, Long>{

}
