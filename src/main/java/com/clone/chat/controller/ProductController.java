package com.clone.chat.controller;


import com.clone.chat.dto.ProductDto;
import com.clone.chat.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDto> getAllProducts() throws Exception {
        return productService.getAllProduct();
    }

    @PostMapping
    public void insertProduct(@RequestBody ProductDto productDto) throws Exception {
        productService.insertCustomer(productDto);
    }
}
