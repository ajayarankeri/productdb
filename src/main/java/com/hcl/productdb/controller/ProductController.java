package com.hcl.productdb.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.productdb.service.ProductService;

@RestController
@RequestMapping("")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/uploadFile")
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		
		return new ResponseEntity<>(productService.uploadFileDate(file),HttpStatus.OK);	
		
		
	}

}
