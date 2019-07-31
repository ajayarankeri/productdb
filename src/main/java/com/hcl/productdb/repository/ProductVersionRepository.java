package com.hcl.productdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.hcl.productdb.entity.Product;
import com.hcl.productdb.dto.ProductsDto;
import com.hcl.productdb.entity.ProductVersion;

@Repository
public interface ProductVersionRepository extends JpaRepository<ProductVersion, Long>{
	
	@Query("SELECT new com.hcl.productdb.dto.ProductsDto(p.productId.productId,MAX(round(p.productVersion,2)),p.productName,p.productDescription)   FROM ProductVersion p GROUP BY p.productId.productId")
	public List<ProductsDto> findAllProducts();
	
	@Query("SELECT new com.hcl.productdb.dto.ProductsDto(p.productId.productId,MAX(round(p.productVersion,2)),p.productName,p.productDescription)   FROM ProductVersion p GROUP BY p.productId.productId having p.productId.productId=:id ")
	public ProductsDto findProductById(@Param("id") long id);

	public ProductVersion findDistinctByProductVersionAndProductIdAndProductDescriptionAndProductName(float version,Product id,String description,String productName);
}
