package com.hcl.productdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.productdb.dto.ProductListDto;
import com.hcl.productdb.service.ProductService;
import com.hcl.productdb.serviceimpl.ProductServiceImpl;

@RestController
@RequestMapping("")
public class ProductController {
	
	@Autowired
	ProductService productServiceImpl;
	
	@PostMapping("/uploadFile")
    public void uploadFile(@RequestParam("file") MultipartFile file) {
		
		
	}
	
	@PostMapping("/send/product")
	ResponseEntity<Object> sendProductList(@RequestBody ProductListDto productListDto){
	
		productServiceImpl.sendMessage(productListDto);
		return new ResponseEntity<>("Ok",HttpStatus.OK);
	}

}
