package com.hcl.productdb.controller;

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

import com.hcl.productdb.exception.NoOrderFoundException;
import com.hcl.productdb.exception.ResourceNotFoundException;
import com.hcl.productdb.service.ProductService;




@Controller
@RestController
@RequestMapping("/")
public class ProductController {
	
	@Autowired
	ProductService  productService;

	@GetMapping("/products")
	public ResponseEntity<Object> productHistory() throws ResourceNotFoundException, NoOrderFoundException {
		return new ResponseEntity<>(productService.productHistory(),HttpStatus.OK);
		
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Object> productById(@PathVariable long id) throws ResourceNotFoundException, NoOrderFoundException {
		return new ResponseEntity<>(productService.getLatestProductVersion(id),HttpStatus.OK);
		
	}
}
