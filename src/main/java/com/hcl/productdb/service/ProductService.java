package com.hcl.productdb.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.productdb.dto.ResponseDto;

@Service
public interface ProductService {

	ResponseDto uploadFileDate(MultipartFile file) throws IOException;

}
