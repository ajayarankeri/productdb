package com.hcl.productdb.dto;

import lombok.Data;

@Data
public class ProductsDto {

	private long productId;
	private float productVersion;
	private String productName;
	private String productDescription;
}
