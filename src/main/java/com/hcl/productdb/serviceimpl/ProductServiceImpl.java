package com.hcl.productdb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hcl.productdb.dto.ProductsDto;
import com.hcl.productdb.dto.ResponseDto;
import com.hcl.productdb.entity.Product;
import com.hcl.productdb.exception.NoOrderFoundException;
import com.hcl.productdb.exception.ResourceNotFoundException;
import com.hcl.productdb.repository.ProductRepository;
import com.hcl.productdb.repository.ProductVersionRepository;
import com.hcl.productdb.service.ProductService;





@Service
public class ProductServiceImpl implements ProductService {
	


	
	@Autowired
	ProductVersionRepository  productRepository;

	@Override
	public List<ProductsDto> productHistory() throws ResourceNotFoundException, NoOrderFoundException {
		
		return productRepository.findAllProducts();
	}

	@Override
	public ProductsDto getLatestProductVersion(long id) {
		
		return productRepository.findProductById(id);
	}

}