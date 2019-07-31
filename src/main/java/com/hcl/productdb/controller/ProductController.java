package com.hcl.productdb.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("")
public class ProductController {
	
	@PostMapping("/uploadFile")
    public void uploadFile(@RequestParam("file") MultipartFile file) {
		
		
	}

}
