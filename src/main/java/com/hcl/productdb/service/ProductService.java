package com.hcl.productdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.productdb.dto.ProductListDto;
import com.hcl.productdb.mq.ProductSender;

@Service
public interface ProductService {
	
	
	public void sendMessage(ProductListDto productListDto);
}
