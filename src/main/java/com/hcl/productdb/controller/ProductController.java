package com.hcl.productdb.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.productdb.exception.ColumnIndexMisMatchException;
import com.hcl.productdb.exception.NoOrderFoundException;
import com.hcl.productdb.exception.ResourceNotFoundException;
import com.hcl.productdb.service.ProductService;




@Controller
@RestController
@RequestMapping("/")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/uploadFile")
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) throws IOException, ColumnIndexMisMatchException {
		
		return new ResponseEntity<>(productService.uploadFileData(file),HttpStatus.OK);	
		
		
	}

	@GetMapping("/products")
	public ResponseEntity<Object> productHistory() throws ResourceNotFoundException, NoOrderFoundException {
		return new ResponseEntity<>(productService.productHistory(),HttpStatus.OK);
		
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Object> productById(@PathVariable long id) throws ResourceNotFoundException, NoOrderFoundException {
		return new ResponseEntity<>(productService.getLatestProductVersion(id),HttpStatus.OK);
		
	}
}
