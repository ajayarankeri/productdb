package com.hcl.productdb.mq;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;

import com.hcl.productdb.dto.ProductVersionDto;
import com.hcl.productdb.entity.Product;
import com.hcl.productdb.entity.ProductVersion;
import com.hcl.productdb.repository.ProductRepository;
import com.hcl.productdb.repository.ProductVersionRepository;


public class ProductReciver {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductVersionRepository productVersionRepository;
	
	List<ProductVersionDto> list;
	
	@JmsListener(destination = "product.queue")
	public void receiveQueue(List<ProductVersionDto> productList) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	System.out.println("list data"+productList);
	//	List<ProductVersionDto> list=productList;
	 	
	     for (ProductVersionDto productVersionDto : productList) {
	    	 System.out.println("add version"+productVersionDto);
			  Optional<Product> product=productRepository.findById(productVersionDto.getProductId());
			  System.out.println("add version"+product.isPresent());
			  if(product.isPresent()) {
 		    	 if(null==productVersionRepository.findDistinctByProductVersionAndProductIdAndProductDescriptionAndProductName(productVersionDto.getProductVersion(),product.get(),productVersionDto.getProductDescription(),productVersionDto.getProductName())) {
 		    		  
 		    		 ProductVersion productVersion=new ProductVersion();
 		    		 productVersion.setProductDescription(productVersionDto.getProductDescription());
 		    		 productVersion.setProductId(product.get());
 		    		 productVersion.setProductName(productVersionDto.getProductName());
 		    		 productVersion.setProductPrice(productVersionDto.getProductPrice());
 		    		 productVersion.setProductVersion(productVersionDto.getProductVersion());
 		    		 productVersionRepository.save(productVersion);
 		    	 }
 		    	 else
 		    	 {
 		    		 ProductVersion productVersion=productVersionRepository.findDistinctByProductVersionAndProductIdAndProductDescriptionAndProductName(productVersionDto.getProductVersion(),product.get(),productVersionDto.getProductDescription(),productVersionDto.getProductName());
 		    		productVersion.setProductDescription(productVersionDto.getProductDescription());
		    		 productVersion.setProductId(product.get());
		    		 productVersion.setProductName(productVersionDto.getProductName());
		    		 productVersion.setProductPrice(productVersionDto.getProductPrice());
		    		 productVersion.setProductVersion(productVersionDto.getProductVersion());
		    		 productVersionRepository.save(productVersion);
 		    	 }
 		      }
 		      
	     }	
		
	
	}
	
	
}
