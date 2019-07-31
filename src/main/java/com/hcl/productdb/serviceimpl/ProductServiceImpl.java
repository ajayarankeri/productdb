package com.hcl.productdb.serviceimpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.productdb.dto.ResponseDto;
import com.hcl.productdb.entity.Product;
import com.hcl.productdb.entity.ProductVersion;
import com.hcl.productdb.repository.ProductRepository;
import com.hcl.productdb.repository.ProductVersionRepository;
import com.hcl.productdb.service.ProductService;

@Component
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductVersionRepository  productVersionRepository;

	@Override
	public ResponseDto uploadFileDate(MultipartFile file) throws IOException  {

		List<Product> tempProductList = new ArrayList<Product>();
		List<ProductVersion> tempProductVersionList = new ArrayList<ProductVersion>();
	    XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
	    XSSFSheet worksheet = workbook.getSheetAt(0);

	    for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
	        Product product = new Product();
	        ProductVersion productVersion = new ProductVersion();

	        XSSFRow row = worksheet.getRow(i);

	        product.setProductId((long) row.getCell(5).getNumericCellValue());
	        product.setProductCode((long) row.getCell(0).getNumericCellValue());
	        
	        productVersion.setProductDescription(row.getCell(1).getStringCellValue());
	        productVersion.setProductName(row.getCell(2).getStringCellValue());
	        productVersion.setProductPrice(row.getCell(3).getNumericCellValue());
	        productVersion.setProductVersion((float) row.getCell(4).getNumericCellValue());
	        productVersion.setProductId(product);
	        
	        
	            tempProductList.add(product);  
	            tempProductVersionList.add(productVersion);
	           
	    }
	    
	    productRepository.saveAll(tempProductList);
	    productVersionRepository.saveAll(tempProductVersionList);
	    System.out.println(tempProductList);
	    System.out.println("====================================");
	    System.out.println(tempProductVersionList);
	    
	    return new ResponseDto("sucess", 300, "Your File Uploaded Successfully");
		
	}

}
