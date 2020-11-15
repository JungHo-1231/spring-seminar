package com.clone.chat.service;

import com.clone.chat.dto.CustomerDto;
import com.clone.chat.dto.ProductDto;

import java.util.List;

public interface ProductService {
    public List<ProductDto> getAllProduct() throws Exception;

    public void insertCustomer(ProductDto productDto) throws Exception;

}
