package com.hcl.productdb.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hcl.productdb.dto.ProductsDto;
import com.hcl.productdb.dto.ResponseDto;
import com.hcl.productdb.exception.NoOrderFoundException;
import com.hcl.productdb.exception.ResourceNotFoundException;



@Component
public interface ProductService {

 public List<ProductsDto> productHistory() throws ResourceNotFoundException, NoOrderFoundException;
 
 public ProductsDto getLatestProductVersion(long id);
}
