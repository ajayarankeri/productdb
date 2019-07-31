package com.hcl.productdb.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProductVersionDto implements Serializable {
       /**
	 * 
	 */
	private static final long serialVersionUID = -5934708072236032355L;


	private Long Id;
	
	
	private String productName;
	
	
	private Double productPrice;
	
	
	private String productDescription;
	
	
	private Float productVersion;
	
	private long productId;

}
