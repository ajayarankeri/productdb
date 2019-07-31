package com.hcl.productdb.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProductListDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -961525938575377784L;
	private List<ProductVersionDto> productList;

}
