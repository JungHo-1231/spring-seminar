package com.clone.chat.service;

import com.clone.chat.dto.ProductDto;
import com.clone.chat.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDto> getAllProduct() throws Exception {
        return productMapper.getAllProduct();
    }

    @Override
    public void insertCustomer(ProductDto productDto) throws Exception {
        productMapper.insertProduct(productDto);
    }
}
