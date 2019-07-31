//package com.hcl.productdb.servicetest;
//
//import static org.junit.Assert.assertNotNull;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.charset.StandardCharsets;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.commons.io.IOUtils;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.hcl.productdb.entity.Product;
//import com.hcl.productdb.entity.ProductVersion;
//import com.hcl.productdb.exception.ColumnIndexMisMatchException;
//import com.hcl.productdb.repository.ProductRepository;
//import com.hcl.productdb.repository.ProductVersionRepository;
//import com.hcl.productdb.serviceimpl.ProductServiceImpl;
//
//@RunWith(MockitoJUnitRunner.class)
//public class ProductServiceImplTest {
//
//	@InjectMocks
//	ProductServiceImpl productServiceImpl;
//	
//	@Mock
//	ProductRepository productRepository;
//	
//	@Mock
//	ProductVersionRepository productVersionRepository;
//	
//	Product product;
//	ProductVersion productVersion;
//	List<Product> tempProductList = new ArrayList<Product>();
//	List<ProductVersion> tempProductVersionList = new ArrayList<ProductVersion>();
//	MultipartFile file;
//		
//
//	
//	@Before
//	public void setUp(){
//		product = new Product();
//		product.setProductCode(1L);
//		product.setProductId(1l);
//		
//		productVersion = new ProductVersion();
//		
//		productVersion.setId(1l);
//		productVersion.setProductDescription("Shoes");
//		productVersion.setProductName("eclemma");
//		productVersion.setProductPrice(10000d);
//		productVersion.setProductVersion(0.1f);
//		
//		
//		tempProductList.add(product);  
//        tempProductVersionList.add(productVersion);
//		
//	}
//	
//	@Test(expected=NullPointerException.class)
//	public void uploadFileDataFailTest() throws ColumnIndexMisMatchException, IOException {
//		Mockito.when( productRepository.saveAll(Mockito.any())).thenReturn(tempProductList);
//		Mockito.when(productVersionRepository.saveAll(Mockito.any())).thenReturn(tempProductVersionList);
//		
//		assertNotNull(productServiceImpl.uploadFileData(file));
//	}
//	
//	@Test
//	public void uploadFileDataPassTest() throws ColumnIndexMisMatchException, IOException {
//		Mockito.when( productRepository.saveAll(Mockito.any())).thenReturn(tempProductList);
//		Mockito.when(productVersionRepository.saveAll(Mockito.any())).thenReturn(tempProductVersionList);
//		
//		ClassLoader classLoader = getClass().getClassLoader();
//
//        try (InputStream inputStream = classLoader.getResourceAsStream("productDb.xlsx")) {
//
//            String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
//            System.out.println(result);
//            
////            assertNotNull(productServiceImpl.uploadFileData(result));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//	
//	}	
//}
