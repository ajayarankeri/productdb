package com.hcl.productdb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ProductsDto {

	private long product_id;
	private float product_Version;
	private String product_name;
	private String product_description;
}
