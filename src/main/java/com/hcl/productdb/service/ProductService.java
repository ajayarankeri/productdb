package com.hcl.productdb.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.productdb.dto.ProductListDto;
import com.hcl.productdb.mq.ProductSender;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.productdb.dto.ProductsDto;
import com.hcl.productdb.dto.ResponseDto;
import com.hcl.productdb.exception.ColumnIndexMisMatchException;
import com.hcl.productdb.exception.NoOrderFoundException;
import com.hcl.productdb.exception.ResourceNotFoundException;



@Component
public interface ProductService {

 public List<ProductsDto> productHistory() throws ResourceNotFoundException, NoOrderFoundException;
 
 public ProductsDto getLatestProductVersion(long id) throws ResourceNotFoundException, NoOrderFoundException;

 public	ResponseDto uploadFileData(MultipartFile file) throws IOException, ColumnIndexMisMatchException;

	public void sendMessage(ProductListDto productListDto);

}
