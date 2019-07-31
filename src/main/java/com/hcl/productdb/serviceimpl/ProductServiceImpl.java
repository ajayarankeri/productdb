package com.hcl.productdb.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hcl.productdb.dto.ProductListDto;
import com.hcl.productdb.mq.ProductReciver;
import com.hcl.productdb.mq.ProductSender;
import com.hcl.productdb.service.ProductService;

@Component
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductSender productSender;
	
	@Autowired
	ProductReciver productReciver;
	
	public void sendMessage(ProductListDto productListDto) {
		productSender.sendMessage(productListDto.getProductList());
	
	}
	
   
}
